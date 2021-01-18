package tv.codely.mooc.steps.infrastructure.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import tv.codely.mooc.courses.domain.StepRepository;
import tv.codely.mooc.steps.domain.Step;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional
public class MySqlStepRepository  extends HibernateRepository<Step> implements StepRepository {
    
	public MySqlStepRepository(SessionFactory sessionFactory) {
		super(sessionFactory, Step.class);	
	}

	

    @Override
    public void save(Step step) {
    	persist(step);        
    }

    @Override
    public Optional<? extends Step> search(StepId id) {
    	return byId(id);        
    }
}
