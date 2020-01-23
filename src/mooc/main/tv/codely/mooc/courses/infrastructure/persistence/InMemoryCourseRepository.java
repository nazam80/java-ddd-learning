package tv.codely.mooc.courses.infrastructure.persistence;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

@Service
public class InMemoryCourseRepository implements CourseRepository {
    @Override
    public void save(Course course) {
        //TODO
    }
}
