package com.sfl.packageservice.repository;

import com.sfl.packageservice.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Integer> {

    Package findByPackageId(String packageId);

}