package de.muenchen.aigner.math_tool.controller;

import de.muenchen.aigner.math_tool.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    // GET /numbers/5
    @GetMapping("/{id}")
    public Number getNumber(@PathVariable Long id) {
        return numberService.getNumberById(id);
    }

    // GET /numbers?isPrim=true
    @GetMapping
    public List<Number> getNumbers(@RequestParam(required = false) Boolean isPrim) {
        if (Boolean.TRUE.equals(isPrim)) {
            return numberService.getAllPrimes();
        }
        // Optional: return all
        throw new UnsupportedOperationException("Nur Primabfrage derzeit unterstützt.");
    }

    // POST /numbers?start=1&end=100
    @PostMapping
    public List<Number> createNumbers(@RequestParam int start, @RequestParam int end) {
        return numberService.createNumberRange(start, end);
    }
}
