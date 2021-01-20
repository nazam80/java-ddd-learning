package tv.codely.mooc.courses;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

public abstract class CourseModuleUnitTestCase extends UnitTestCase{
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp(){
    	super.setUp();
        repository = mock(CourseRepository.class);
    }

    public void shouldHaveSaved(Course course){
        verify(repository, atLeastOnce()).save(course);
    }

}

