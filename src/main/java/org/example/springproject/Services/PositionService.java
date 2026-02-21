package org.example.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.springproject.Entities.Position;
import org.example.springproject.Repository.PositionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService implements IPositionService {

    private PositionRepository positionRepository;

    @Override
    public Position ajouterPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public List<Position> ajouterPositions(List<Position> positions) {
        return positionRepository.saveAll(positions);
    }

    @Override
    public Position modifierPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void supprimerPosition(Long idPosition) {
        positionRepository.deleteById(idPosition);
    }

    @Override
    public List<Position> listPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position recupererPosition(Long idPosition) {
        return positionRepository.findById(idPosition).orElse(null);
    }
}