package pl.bogo.course.repository;

import pl.bogo.course.domain.Course;

import java.util.List;

public interface CourseRepository {

    void addNotes(String id, String notes);

    List<Course> getAllCourses();

    void save(Course course);
}
