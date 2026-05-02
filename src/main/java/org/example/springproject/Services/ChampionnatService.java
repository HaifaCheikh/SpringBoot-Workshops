package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.example.springproject.Entities.Pilote;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Championnat;
import org.example.springproject.Entities.Course;
import org.example.springproject.Repository.ChampionnatRepository;
import org.example.springproject.Repository.CourseRepository;
import org.example.springproject.DTO.PiloteDto;


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

    @Override
    public List<PiloteDto> listeWinners(Integer annee) {
        List<Championnat> championnats = championnatRepository
                .findAll()
                .stream()
                .filter(c -> c.getAnnee() != null && c.getAnnee() > annee)
                .collect(java.util.stream.Collectors.toList());

        List<PiloteDto> winners = new java.util.ArrayList<>();

        championnats.forEach(championnat -> {

            if (championnat.getCourses() != null) {
                championnat.getCourses().forEach(course -> {
                    if (course.getPositions() != null) {
                        course.getPositions().stream()
                                .filter(p -> p.getClassement() != null
                                        && p.getClassement() == 1)
                                .forEach(position -> {
                                    Pilote pilote = position.getPilote();
                                    if (pilote != null) {
                                        PiloteDto dto = new PiloteDto(
                                                pilote.getLibelleP(),
                                                pilote.getNbrPointsTotal(),
                                                championnat.getLibelleC()
                                        );
                                        boolean exists = winners.stream()
                                                .anyMatch(w ->
                                                        w.getLibelleP()
                                                                .equals(dto.getLibelleP())
                                                                && w.getLibelleC()
                                                                .equals(dto.getLibelleC()));
                                        if (!exists) {
                                            winners.add(dto);
                                        }
                                    }
                                });
                    }
                });
            }
        });

        return winners;
    }

}