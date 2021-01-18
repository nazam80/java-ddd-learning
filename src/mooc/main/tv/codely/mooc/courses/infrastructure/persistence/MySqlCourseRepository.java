package tv.codely.mooc.courses.infrastructure.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional
public class MySqlCourseRepository  extends HibernateRepository<Course> implements CourseRepository {
    
	public MySqlCourseRepository(SessionFactory sessionFactory) {
		super(sessionFactory, Course.class);	
	}

	

    @Override
    public void save(Course course) {
    	persist(course);        
    }

    @Override
    public Optional<Course> search(CourseId id) {
    	return byId(id);        
    }
}
