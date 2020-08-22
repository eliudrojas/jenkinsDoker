package jenkinsDocker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jenkinsDocker.entity.ThemeParkRide;

public interface ThemeParkRideRepository extends CrudRepository<ThemeParkRide, Long> {
	
	List <ThemeParkRide> findByName(String name);
}
