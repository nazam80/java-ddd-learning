package tv.codely.apps.mooc.backend.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.courses.application.create.CourseCreator;
import tv.codely.mooc.courses.application.create.CreateCourseRequest;

@RestController
public final class CoursesPutController {

    private CourseCreator creator;

    public CoursesPutController(CourseCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity create(@PathVariable  String id, @RequestBody Request body){
        creator.create(new CreateCourseRequest(id, body.getName(), body.getDuration()));

        return new ResponseEntity(HttpStatus.CREATED);
    }

}

final class Request{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private String duration;
}
