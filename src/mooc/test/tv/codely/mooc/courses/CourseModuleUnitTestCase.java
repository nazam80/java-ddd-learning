package tv.codely.mooc.courses;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class CourseModuleUnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp(){
        repository = mock(CourseRepository.class);
    }

    public void shouldHaveSaved(Course course){
        verify(repository, atLeastOnce()).save(course);
    }

}

