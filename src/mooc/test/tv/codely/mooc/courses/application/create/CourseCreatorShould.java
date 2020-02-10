package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.mockito.Mockito.*;

final class CourseCreatorShould {

    @Test
    void save_a_valid_course() throws Exception {
        CourseRepository courseRepository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(courseRepository);
        Course course = new Course("my-id", "my-name", "my-duration");

        creator.create(new CreateCourseRequest(course.id(), course.name(), course.duration()));

        verify(courseRepository, atLeastOnce()).save(course);
    }
}
