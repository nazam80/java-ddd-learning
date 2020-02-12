package tv.codely.mooc.courses.application.create;


import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

@Service
public final class CourseCreator {

    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequest request) {
        Course course = new Course(new CourseId(request.id()), new CourseName(request.name()),
            new CourseDuration(request.duration()));
        repository.save(course);
    }
}
