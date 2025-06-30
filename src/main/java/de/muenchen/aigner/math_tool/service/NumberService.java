package de.muenchen.aigner.math_tool.service;

import de.muenchen.aigner.math_tool.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    @Autowired
    private NumberRepository numberRepository;

    public List<Number> getAllPrimes() {
        return numberRepository.findByIsPrimTrue();
    }

    public Number getNumberById(Long id) {
        return numberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zahl nicht gefunden"));
    }

    public List<Number> createNumberRange(int start, int end) {
        List<Number> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            Number number = new Number();
            number.intValue(i);
            number.setPrim(false); // Prim-Erkennung später
            result.add(number);
        }
        return numberRepository.saveAll(result);
    }
}
