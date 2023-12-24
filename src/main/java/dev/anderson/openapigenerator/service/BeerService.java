package dev.anderson.openapigenerator.service;

import dev.anderson.openapigenerator.repository.BeerRepository;
import dev.anderson.openapigenerator.model.Beer;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

  private final BeerRepository beerRepository;

  public ResponseEntity<Beer> addBeer(Beer beer) {
    try {
      return ResponseEntity.ok(beerRepository.save(beer));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<Void> deleteBeer(Long id) {
    try {
      beerRepository.deleteById(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<Beer> updateBeer(Beer beer) {
    Beer dummyBeer = beerRepository.findById(beer.getId()).orElse(null);

    if (dummyBeer == null) {
      beerRepository.save(beer);
    }
    return ResponseEntity.badRequest().build();
  }

  public ResponseEntity<List<Beer>> getBeers() {
    return ResponseEntity.ok(beerRepository.findAll());
  }
}
