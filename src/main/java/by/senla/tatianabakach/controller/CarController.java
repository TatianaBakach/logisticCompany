package by.senla.tatianabakach.controller;

import by.senla.tatianabakach.dto.CarDTO;
import by.senla.tatianabakach.exception.DtoValidationException;
import by.senla.tatianabakach.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/{id}")
    public CarDTO findById(@PathVariable("id") final Integer id) {
        return carService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO create(@Valid @RequestBody final CarDTO carDTO,
                         final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DtoValidationException(bindingResult);
        }
        return carService.save(carDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO update(@PathVariable("id") final Integer id,
                         @Valid @RequestBody final CarDTO carDTO,
                         final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DtoValidationException(bindingResult);
        }
        return carService.update(id, carDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDTO> delete(@PathVariable("id") final Integer id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page/{page-number}")
    public Page<CarDTO> findAll(@PathVariable(name = "page-number") final Integer pageNumber,
                                @RequestParam(name = "sort-field", defaultValue = "id") final String sortField,
                                @RequestParam(name = "sort-dir", defaultValue = "asc") final String sortDir) {
        return carService.findAll(pageNumber, sortField, sortDir);
    }
}
