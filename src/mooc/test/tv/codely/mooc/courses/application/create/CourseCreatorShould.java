package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.mockito.Mockito.*;

final class CourseCreatorShould {

    @Test
    void save_a_valid_course() throws Exception {
        CourseRepository courseRepository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(courseRepository);

        CreateCourseRequest request = new CreateCourseRequest("decf33ca-81a7-419f-a07a-74f214e928e5", "my-name", "my-duration");

        CourseId id = new CourseId(request.id());
        Course course = new Course(id, request.name(), request.duration());

        creator.create(request);

        verify(courseRepository, atLeastOnce()).save(course);
    }
}
