package pl.bogo.course.repository;

import org.h2.jdbcx.JdbcDataSource;
import pl.bogo.course.domain.Course;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


class CourseJdbcRepository implements CourseRepository {

    private static final String H2_DATABASE_URL = "jdbc:h2:file:%s;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";
    private static final String INSERT_COURSE = """
            MERGE INTO Courses (id, name, length, url)
            VALUES (?, ?, ?, ?)
            """;

    private static final String ADD_NOTES = """
            UPDATE Courses SET notes = ?
            WHERE id = ?
            """;
    private final DataSource ds;

    public CourseJdbcRepository(String databaseFile) {
        JdbcDataSource jds = new JdbcDataSource();
        jds.setURL(H2_DATABASE_URL.formatted(databaseFile));
        this.ds = jds;
    }


    @Override
    public void addNotes(String id, String notes) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement(ADD_NOTES);
            ps.setString(1, notes);
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Failed to add notes to " + id, e);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        try (Connection c = ds.getConnection()) {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM COURSES");
            List<Course> courses = new ArrayList<>();
            while (rs.next()) {
                Course course = new Course(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), Optional.ofNullable(rs.getString(5)));
                courses.add(course);
            }
            return Collections.unmodifiableList(courses);
        } catch (SQLException e) {
            throw new RepositoryException("Failed to retrieve courses", e);
        }
    }

    @Override
    public void save(Course course) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement(INSERT_COURSE);
            ps.setString(1, course.id());
            ps.setString(2, course.name());
            ps.setLong(3, course.length());
            ps.setString(4, course.url());
            ps.execute();
        } catch (SQLException e) {
            throw new RepositoryException("Failed to save " + course, e);
        }
    }
}
