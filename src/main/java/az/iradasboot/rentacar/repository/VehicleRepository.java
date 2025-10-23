package az.iradasboot.rentacar.repository;

import az.iradasboot.rentacar.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity,Long> , JpaSpecificationExecutor<VehicleEntity> {
    List<VehicleEntity> findByBrandIgnoreCase(String brand);
    List<VehicleEntity> findByBrandContainingIgnoreCase(String brand);
}
