package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;

import java.util.Optional;

class InMemoryCourseRepositoryShould {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseId id = new CourseId("decf33ca-81a7-419f-a07a-74f214e928e5");
        repository.save(new Course(id, "my-name", "my-duration"));
    }


    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseId id = new CourseId("decf33ca-81a7-419f-a07a-74f214e928e5");
        Course course = new Course(id, "my-name", "my-duration");

        repository.save( course);

        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void search_not_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        CourseId id = new CourseId("65cc2174-30bf-4630-9392-f8084f088cc6");
        Assert.assertFalse(repository.search(id).isPresent());
    }
}
