package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.CreateCourseRequestMother;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class CourseCreatorShould {

    @Test
    void save_a_valid_course() throws Exception {
        CourseRepository courseRepository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(courseRepository);

        CreateCourseRequest request = CreateCourseRequestMother.random();

        Course course = CourseMother.fromRequest(request);

        creator.create(request);

        verify(courseRepository, atLeastOnce()).save(course);
    }
}
