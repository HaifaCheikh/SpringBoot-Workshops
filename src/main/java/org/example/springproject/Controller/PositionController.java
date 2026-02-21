package org.example.springproject.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.springproject.Entities.Position;
import org.example.springproject.Services.IPositionService;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@AllArgsConstructor
public class PositionController {

    private IPositionService positionService;

    @GetMapping
    public List<Position> list() {
        return positionService.listPositions();
    }

    @GetMapping("/{id}")
    public Position get(@PathVariable Long id) {
        return positionService.recupererPosition(id);
    }

    @PostMapping
    public Position add(@RequestBody Position position) {
        return positionService.ajouterPosition(position);
    }

    @PutMapping
    public Position update(@RequestBody Position position) {
        return positionService.modifierPosition(position);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        positionService.supprimerPosition(id);
    }
}