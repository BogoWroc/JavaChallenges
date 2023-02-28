package pl.bogo.course.server;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bogo.course.repository.CourseRepository;
import pl.bogo.course.repository.CourseRepositoryFactory;

import java.net.URI;

public class CourseServer {
    private static final Logger LOG = LoggerFactory.getLogger(CourseServer.class);
    private static final String BASE_URI = "http://localhost:8080";
    private static final String DATABASE_FILE = "./courses.db";

    public static void main(String[] args) {
        LOG.info("Starting HTTP server");
        CourseRepository courseRepository = CourseRepositoryFactory.openCourseRepository(DATABASE_FILE);
        ResourceConfig config = new ResourceConfig().register(new CourseResource(courseRepository));

        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }
}