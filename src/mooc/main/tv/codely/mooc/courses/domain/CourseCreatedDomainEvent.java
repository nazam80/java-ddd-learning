package tv.codely.mooc.courses.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import tv.codely.shared.domain.bus.event.DomainEvent;

public final class CourseCreatedDomainEvent extends DomainEvent<CourseCreatedDomainEvent> {
	private static final String EVENT_NAME = "course.created";
	private static final String DURATION_KEY = "duration";
	private static final String NAME_KEY = "name";
	
	private final String name;
	private final String duration;

	public CourseCreatedDomainEvent(String aggregateId, String name, String duration) {
		super(aggregateId);

		this.name = name;
		this.duration = duration;
	}

	public CourseCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name,
			String duration) {
		super(aggregateId, eventId, occurredOn);

		this.name = name;
		this.duration = duration;
	}

	@Override
	public String eventName() {
		return EVENT_NAME;
	}

	@Override
	public Map<String, Serializable> toPrimitives() {
		return  Map.of(NAME_KEY, name, DURATION_KEY, duration);
	}

	@Override
	public CourseCreatedDomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body,
			String eventId, String occurredOn) {
		return new CourseCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get(NAME_KEY),
				(String) body.get(DURATION_KEY));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseCreatedDomainEvent that = (CourseCreatedDomainEvent) o;
		return name.equals(that.name) && duration.equals(that.duration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, duration);
	}
}
