package az.iradasboot.rentacar.dto;

import az.iradasboot.rentacar.enums.VehicleStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDto {
    private String brand;
    private String model;
    private String transmission;
    private Boolean airConditioning;
    private Integer year;
    private Integer seats;
    private Integer doors;
    private Integer horsepower;
    private Integer luggage;
    private Double dailyPrice;
    private Integer stock;
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;
    private String imageUrl;
}
