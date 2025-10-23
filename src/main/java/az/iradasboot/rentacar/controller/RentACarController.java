package az.iradasboot.rentacar.controller;

import az.iradasboot.rentacar.dto.PaymentDto;
import az.iradasboot.rentacar.dto.ReservationDto;
import az.iradasboot.rentacar.dto.VehicleDto;
import az.iradasboot.rentacar.entity.ReservationEntity;
import az.iradasboot.rentacar.entity.VehicleEntity;
import az.iradasboot.rentacar.service.VehicleService;
import az.iradasboot.rentacar.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/rentacar")
@RequiredArgsConstructor
public class RentACarController {

    private final VehicleService vehicleService;
    private final VehicleServiceImpl vehicleServiceImpl;


    @GetMapping("getAll")
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping("get")
    public Page<VehicleEntity> getVehicle(){
        return vehicleService.getVehicle();
    }

    @GetMapping("reservation")
    public void getCustomers(){

    }


    @GetMapping("/get/filter")
    public List<VehicleEntity> specGet(@RequestParam(value = "brand",required = false) String brand ,@RequestParam(value = "model",required = false) String model){
        return vehicleServiceImpl.specGet(brand,model);
    }

    @PostMapping()
    public void createVehicle(@Valid @RequestBody VehicleDto dto){
        vehicleService.createVehicle(dto);
    }

    @PostMapping("reservation/add")
    public ResponseEntity<Map<String, Object>> addReservation(@Valid @RequestBody ReservationDto dto) {
        ReservationEntity saved = vehicleService.save(dto);
        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getId());
        response.put("message", "Rezervasyon başarıyla oluşturuldu");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/payment/add")
    public void addCustomer(@Valid @RequestBody PaymentDto paymentDto){
        vehicleService.addPayment(paymentDto);

    }

}
