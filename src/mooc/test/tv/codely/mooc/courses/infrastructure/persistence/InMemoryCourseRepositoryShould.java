package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;

import java.util.Optional;

class InMemoryCourseRepositoryShould {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();
        repository.save(course);
    }


    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();
        repository.save(course);

        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void search_not_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseId id = CourseIdMother.random();
        Assert.assertFalse(repository.search(id).isPresent());
    }
}
