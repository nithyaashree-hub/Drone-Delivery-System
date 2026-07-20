package com.sfl.packageservice.service;

import com.sfl.packageservice.entity.Package;
import com.sfl.packageservice.exception.PackageNotFoundException;
import com.sfl.packageservice.repository.PackageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(PackageService.class);

    // Register Package
    public Package registerPackage(Package pack) {

        logger.info("Registering Package");

        if (repository.findByPackageId(pack.getPackageId()) != null) {

            logger.error("Package ID already exists");

            throw new RuntimeException("Package ID already exists");
        }
        pack.setStatus("CREATED");
        logger.info("Package Registered Successfully");

        return repository.save(pack);
    }

    // Get All Packages
    public List<Package> getAllPackages() {

        logger.info("Fetching All Packages");

        return repository.findAll();
    }

    // Get Package By ID
    public Package getPackageById(int id) {

        logger.info("Fetching Package with ID {}", id);

        Package pack = repository.findById(id).orElse(null);

        if (pack == null) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        return pack;
    }
    public Package getPackageByPackageId(String packageId) {

        Package pack = repository.findByPackageId(packageId);

        if (pack == null) {
            throw new PackageNotFoundException("Package Not Found");
        }

        return pack;
    }

    // Update Package
    public Package updatePackage(int id, Package pack) {

        logger.info("Updating Package with ID {}", id);

        Package oldPackage = repository.findById(id).orElse(null);

        if (oldPackage == null) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        Package duplicatePackage = repository.findByPackageId(pack.getPackageId());

        if (duplicatePackage != null && duplicatePackage.getId() != id) {

            logger.error("Package ID already exists");

            throw new RuntimeException("Package ID already exists");
        }

        oldPackage.setPackageId(pack.getPackageId());
        oldPackage.setPackageName(pack.getPackageName());
        oldPackage.setWeight(pack.getWeight());
        oldPackage.setDestination(pack.getDestination());

        logger.info("Package Updated Successfully");

        return repository.save(oldPackage);
    }
    public Package updatePackageByPackageId(String packageId, Package pack) {

        Package oldPackage = repository.findByPackageId(packageId);

        if (oldPackage == null) {
            throw new PackageNotFoundException("Package Not Found");
        }

        oldPackage.setSender(pack.getSender());
        oldPackage.setReceiver(pack.getReceiver());
        oldPackage.setWeight(pack.getWeight());
        oldPackage.setStatus(pack.getStatus());

        return repository.save(oldPackage);
    }

    // Delete Package
    public String deletePackage(int id) {

        logger.info("Deleting Package with ID {}", id);

        Package pack = repository.findById(id).orElse(null);

        if (pack == null) {

            logger.error("Package Not Found");

            throw new PackageNotFoundException("Package Not Found");
        }

        repository.delete(pack);

        logger.info("Package Deleted Successfully");

        return "Package Deleted Successfully";
    }

}