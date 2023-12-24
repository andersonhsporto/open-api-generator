package dev.anderson.openapigenerator.controller;

import dev.anderson.openapigenerator.api.BeerApi;
import dev.anderson.openapigenerator.model.Beer;
import dev.anderson.openapigenerator.service.BeerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BeerController implements BeerApi {

  private final BeerService beerService;

  @Override
  public ResponseEntity<Beer> _addBeer(Beer beer) {
    return beerService.addBeer(beer);
  }

  @Override
  public ResponseEntity<List<Beer>> _beerGet() {
    return beerService.getBeers();
  }

  @Override
  public ResponseEntity<Void> _deleteBeer(Long id) {
    return beerService.deleteBeer(id);
  }

  @Override
  public ResponseEntity<Beer> _updateBeer(Beer beer) {
    return beerService.updateBeer(beer);
  }
}
