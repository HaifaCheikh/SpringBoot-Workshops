package org.example.springproject.Services;

import org.example.springproject.Entities.Course;
import java.util.List;

public interface ICourseService {

    Course ajouterCourse(Course course);

    List<Course> ajouterCourses(List<Course> courses);

    Course modifierCourse(Course course);

    void supprimerCourse(Long idCourse);

    List<Course> listCourses();

    Course recupererCourse(Long idCourse);
}