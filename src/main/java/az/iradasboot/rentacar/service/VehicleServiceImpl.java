package az.iradasboot.rentacar.service;

import az.iradasboot.rentacar.dto.PaymentDto;
import az.iradasboot.rentacar.dto.ReservationDto;
import az.iradasboot.rentacar.dto.VehicleDto;
import az.iradasboot.rentacar.entity.PaymentEntity;
import az.iradasboot.rentacar.entity.ReservationEntity;
import az.iradasboot.rentacar.entity.VehicleEntity;
import az.iradasboot.rentacar.repository.PaymentRepository;
import az.iradasboot.rentacar.repository.ReservationRepository;
import az.iradasboot.rentacar.repository.VehicleRepository;
import az.iradasboot.rentacar.specification.VehicleSpecification;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ReservationRepository reservationRepository;
    private final PaymentRepository paymentRepository;
    public List<VehicleEntity> searchByBrand(String brand) {
        log.info("Searching vehicles by brand: {}", brand);
        return vehicleRepository.findByBrandContainingIgnoreCase(brand);
    }

    @Override
    public ReservationEntity save(@Valid ReservationDto dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setCustomerName(dto.getCustomerName());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setTotalPrice(dto.getTotalPrice());
        return reservationRepository.save(entity);
    }


    @Override
    public List<VehicleEntity> findAll() {
        return vehicleRepository.findAll();
    }
    @Override
    public void createVehicle(VehicleDto dto){
        log.info("Creating new vehicle: {} {}", dto.getBrand(), dto.getModel());
        var v = VehicleEntity.builder()
                .transmission(dto.getTransmission())
                .year(dto.getYear())
                .airConditioning(dto.getAirConditioning())
                .doors(dto.getDoors())
                .model(dto.getModel())
                .brand(dto.getBrand())
                .seats(dto.getSeats())
                .stock(dto.getStock())
                .dailyPrice(dto.getDailyPrice())
                .horsepower(dto.getHorsepower())
                .status(dto.getStatus())
                .luggage(dto.getLuggage())
                .imageUrl(dto.getImageUrl())
                .build();
        vehicleRepository.save(v);
        log.info("Vehicle successfully saved: {} {}", v.getBrand(), v.getModel());


    }

    @Override
    public void addCustomers(ReservationDto dto){
        log.info("Customers are add");
        var r = ReservationEntity.builder()
                .customerName(dto.getCustomerName())
                .age(dto.getAge())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .totalPrice(dto.getTotalPrice())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    @Override
    public void addPayment(PaymentDto paymentDto){
        log.info("payment finis succesfully");
        var p = PaymentEntity.builder()
                .paymentMethod(paymentDto.getPaymentMethod())
                .reservationId(paymentDto.getReservationId())
                .build();
    }

    @Override
    public Page<VehicleEntity> getVehicle(){
        log.info("Fetching first page of vehicles (size 5)");
        Pageable pageable = PageRequest.of(0,5);
        return vehicleRepository.findAll(pageable);
    }
    @Override
    public Page<VehicleEntity> getVehicle(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return vehicleRepository.findAll(pageable);
    }

    public List<VehicleEntity> specGet(String brand, String model){
        log.info("Running specification search for brand: {}", brand);
        return vehicleRepository.findAll(Specification.allOf(VehicleSpecification.searchBrand(brand),VehicleSpecification.searchModel(model)));
    }

    @Override
    public void getCustomers(ReservationDto dto){


    }

}
