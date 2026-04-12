package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Course;
import org.example.springproject.Services.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private ICourseService courseService;

    @PostMapping
    public Course ajouterCourse(@RequestBody Course course) {
        return courseService.ajouterCourse(course);
    }

    @PostMapping("/all")
    public List<Course> ajouterCourses(@RequestBody List<Course> courses) {
        return courseService.ajouterCourses(courses);
    }

    @PutMapping
    public Course modifierCourse(@RequestBody Course course) {
        return courseService.modifierCourse(course);
    }

    @DeleteMapping("/{id}")
    public void supprimerCourse(@PathVariable("id") Long idCourse) {
        courseService.supprimerCourse(idCourse);
    }

    @GetMapping
    public List<Course> listCourses() {
        return courseService.listCourses();
    }

    @GetMapping("/{id}")
    public Course recupererCourse(@PathVariable("id") Long idCourse) {
        return courseService.recupererCourse(idCourse);
    }
}