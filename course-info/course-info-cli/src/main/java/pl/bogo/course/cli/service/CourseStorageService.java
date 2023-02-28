package pl.bogo.course.cli.service;

import pl.bogo.course.domain.Course;
import pl.bogo.course.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";

    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void store(List<PluralsightCourse> courses) {
        courses.stream()
                .map(it -> new Course(it.id(), it.title(), it.durationInMinutes(), PS_BASE_URL + it.contentUrl(), Optional.empty()))
                .forEach(courseRepository::save);
    }
}
