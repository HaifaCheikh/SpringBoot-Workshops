package org.example.springproject.Services;

import org.example.springproject.Entities.Position;
import java.util.List;

public interface IPositionService {

    Position ajouterPosition(Position position);

    List<Position> ajouterPositions(List<Position> positions);

    Position modifierPosition(Position position);

    void supprimerPosition(Long idPosition);

    List<Position> listPositions();

    Position recupererPosition(Long idPosition);
}