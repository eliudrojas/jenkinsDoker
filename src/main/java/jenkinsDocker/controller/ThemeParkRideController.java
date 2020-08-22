package jenkinsDocker.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jenkinsDocker.entity.ThemeParkRide;
import jenkinsDocker.repository.ThemeParkRideRepository;

@RestController
public class ThemeParkRideController {

	private ThemeParkRideRepository themeParkRideRepository;
	
	public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
		super();
		this.themeParkRideRepository = themeParkRideRepository;
	}


	@GetMapping(value = "/getRide", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable < ThemeParkRide > getRides() {
		return themeParkRideRepository.findAll();
	}
	
	@GetMapping(value=  "/getRide/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide getRide(@PathVariable("id") long id) {
		return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid id %s", id)));
	}
	
	@PostMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide theme) {
		return themeParkRideRepository.save(theme);
	}
}
