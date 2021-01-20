package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;

import tv.codely.mooc.courses.CourseModuleUnitTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseCreatedDomainEvent;
import tv.codely.mooc.courses.domain.CourseCreatedDomainEventMother;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses.domain.CreateCourseRequestMother;

final class CourseCreatorShould extends CourseModuleUnitTestCase {

    @Test
    void save_a_valid_course() throws Exception {

        CourseCreator creator = new CourseCreator(repository, eventBus);

        CreateCourseRequest request = CreateCourseRequestMother.random();

        Course course = CourseMother.fromRequest(request);
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

        creator.create(request);

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }
}
