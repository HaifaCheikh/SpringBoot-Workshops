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

    @GetMapping
    public List<Course> list() {
        return courseService.listCourses();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.recupererCourse(id);
    }

    @PostMapping
    public Course add(@RequestBody Course course) {
        return courseService.ajouterCourse(course);
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseService.modifierCourse(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.supprimerCourse(id);
    }
}