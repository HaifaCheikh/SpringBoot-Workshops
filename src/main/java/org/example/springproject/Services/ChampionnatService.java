package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Championnat;
import org.example.springproject.Entities.Course;
import org.example.springproject.Repository.ChampionnatRepository;
import org.example.springproject.Repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChampionnatService implements IChampionnatService {

    private ChampionnatRepository championnatRepository;
    private CourseRepository courseRepository;

    @Override
    public Championnat ajouterChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }

    @Override
    public List<Championnat> ajouterChampionnats(List<Championnat> championnats) {
        return championnatRepository.saveAll(championnats);
    }

    @Override
    public Championnat modifierChampionnat(Championnat championnat) {
        return championnatRepository.save(championnat);
    }

    @Override
    public void supprimerChampionnat(Long idChampionnat) {
        championnatRepository.deleteById(idChampionnat);
    }

    @Override
    public List<Championnat> listChampionnats() {
        return championnatRepository.findAll();
    }

    @Override
    public Championnat recupererChampionnat(Long idChampionnat) {
        return championnatRepository.findById(idChampionnat).orElse(null);
    }

    @Override
    public Championnat addChampionnatAndAssociatedCourses(Championnat championnat) {
        if (championnat.getCourses() != null) {
            championnat.getCourses().forEach(c -> c.setChampionnat(championnat));
        }
        return championnatRepository.save(championnat);
    }

    @Override
    public String affecterCourseAChampionnat(Long idCourse, Long idChampionnat) {
        Championnat championnat = championnatRepository
                .findById(idChampionnat).orElse(null);
        Course course = courseRepository
                .findById(idCourse).orElse(null);
        if (championnat != null && course != null) {
            course.setChampionnat(championnat);
            courseRepository.save(course);
            return "Course affectée avec succès au championnat";
        }
        return "Erreur : championnat ou course introuvable";
    }

}