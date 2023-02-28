package pl.bogo.course.cli.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CourseRetrievalService {

    private static final String PS_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final HttpClient httpClient;

    public CourseRetrievalService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public List<PluralsightCourse> getCoursesFor(String authorId) {
        HttpRequest req = HttpRequest
                .newBuilder(URI.create(PS_URI.formatted(authorId)))
                .GET()
                .build();

        try {
            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return switch (res.statusCode()){
                case 200 -> getPluralsightCourses(res);
                case 404 -> List.of();
                default -> throw new RuntimeException("Pluralsight API call failed with status code " + res.statusCode());
            };
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not call Pluralsight API", e);
        }
    }

    private static List<PluralsightCourse> getPluralsightCourses(HttpResponse<String> res) throws JsonProcessingException {
        JavaType type = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(List.class, PluralsightCourse.class);
        return OBJECT_MAPPER.readValue(res.body(), type);
    }
}
