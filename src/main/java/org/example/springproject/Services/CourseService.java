package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Course;
import org.example.springproject.Repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    private CourseRepository courseRepository;

    @Override
    public Course ajouterCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> ajouterCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    @Override
    public Course modifierCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void supprimerCourse(Long idCourse) {
        courseRepository.deleteById(idCourse);
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course recupererCourse(Long idCourse) {
        return courseRepository.findById(idCourse).orElse(null);
    }
}