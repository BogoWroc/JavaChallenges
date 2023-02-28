package pl.bogo.course.cli;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bogo.course.cli.service.CourseRetrievalService;
import pl.bogo.course.cli.service.CourseStorageService;
import pl.bogo.course.cli.service.PluralsightCourse;
import pl.bogo.course.repository.CourseRepository;
import pl.bogo.course.repository.CourseRepositoryFactory;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("Course retriever ...");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as first argument.");
            return;
        }


        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected error");
            throw new RuntimeException(e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofMillis(200))
                .build();
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService(httpClient);
        CourseRepositoryFactory courseRepositoryFactory = new CourseRepositoryFactory();
        CourseRepository courseRepository = courseRepositoryFactory.openCourseRepository("./courses.db");
        CourseStorageService courseStorageService = new CourseStorageService(courseRepository);


        List<PluralsightCourse> coursesToStore = courseRetrievalService.getCoursesFor(authorId)
                .stream()
                .filter(not(PluralsightCourse::isRetired))
                .toList();
        LOG.info("Retrieved the following {} courses {}", coursesToStore.size(), coursesToStore);
        courseStorageService.store(coursesToStore);
        LOG.info("Courses successfully stored");
    }
}
