package com.sfl.packageservice.controller;

import com.sfl.packageservice.entity.Package;
import com.sfl.packageservice.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
public class PackageController {

    @Autowired
    private PackageService service;

    // Register Package
    @PostMapping
    public Package registerPackage(@Valid @RequestBody Package pack) {

        return service.registerPackage(pack);

    }

    // Get All Packages
    @GetMapping
    public List<Package> getAllPackages() {

        return service.getAllPackages();

    }

    @RestController
    public class HomeController {

        @GetMapping("/")
        public String home() {
            return "Package Service is Running";
        }
    }
    // Get Package By ID
    @GetMapping("/{id}")
    public Package getPackageById(@PathVariable int id) {

        return service.getPackageById(id);

    }
    @GetMapping("/package/{packageId}")
    public Package getPackageByPackageId(@PathVariable String packageId) {

        return service.getPackageByPackageId(packageId);

    }
    // Update Package
    @PutMapping("/{id}")
    public Package updatePackage(@PathVariable int id,
                                 @Valid @RequestBody Package pack) {

        return service.updatePackage(id, pack);

    }
    @PutMapping("/package/{packageId}")
    public Package updatePackageByPackageId(@PathVariable String packageId,
                                            @RequestBody Package pack) {
        return service.updatePackageByPackageId(packageId, pack);
    }

    // Delete Package
    @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable int id) {

        return service.deletePackage(id);

    }

}