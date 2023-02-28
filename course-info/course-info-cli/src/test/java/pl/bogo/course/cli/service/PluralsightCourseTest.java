package pl.bogo.course.cli.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PluralsightCourseTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            01:08:54.987687, 68
            00:05:37, 5
            00:00:00, 0
            """)
    void durationInMinutes(String actualDuration, long expectedDuration) {
        PluralsightCourse pc = new PluralsightCourse("id", "Test course", actualDuration, "url", false);
        assertEquals(expectedDuration, pc.durationInMinutes());
    }
}