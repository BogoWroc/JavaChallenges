package pl.bogo.course.repository;

public class CourseRepositoryFactory {
    public static CourseRepository openCourseRepository(String databaseFile){
        return new CourseJdbcRepository(databaseFile);
    }
}
