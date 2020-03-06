package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CourseModuleInfrastructureTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;

import java.util.Optional;


class MySqlCourseRepositoryShould  extends CourseModuleInfrastructureTestCase {

    @Test
    void save_a_valid_course() {
        Course course = CourseMother.random();
        mySqlCourseRepository.save(course);
    }


    @Test
    void search_an_existing_course() {
        Course course = CourseMother.random();
        mySqlCourseRepository.save(course);

        Assert.assertEquals(Optional.of(course), mySqlCourseRepository.search(course.id()));
    }

    @Test
    void search_not_existing_course() {
        CourseId id = CourseIdMother.random();
        Assert.assertFalse(mySqlCourseRepository.search(id).isPresent());
    }
}
