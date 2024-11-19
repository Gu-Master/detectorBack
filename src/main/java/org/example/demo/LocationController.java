package org.example.demo;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationDataRepository repository;

    public LocationController(LocationDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<LocationData> saveLocation(@RequestBody LocationData locationData) {
        System.out.println("post");
        LocationData savedData = repository.save(locationData);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping
    public ResponseEntity<?> getAllLocations() {
        return ResponseEntity.ok(repository.findAll());
    }
}
