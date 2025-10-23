package az.iradasboot.rentacar.service;

import az.iradasboot.rentacar.dto.PaymentDto;
import az.iradasboot.rentacar.dto.ReservationDto;
import az.iradasboot.rentacar.dto.VehicleDto;
import az.iradasboot.rentacar.entity.ReservationEntity;
import az.iradasboot.rentacar.entity.VehicleEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VehicleService {
    void createVehicle( VehicleDto dto);
    List<VehicleEntity> findAll();
    void addCustomers(ReservationDto reservationDto);
    Page<VehicleEntity> getVehicle();
    void getCustomers(ReservationDto reservationDto);
    void addPayment (PaymentDto paymentDto);
    Page<VehicleEntity> getVehicle(int pageNumber, int pageSize);

    ReservationEntity save(@Valid ReservationDto dto);
}
