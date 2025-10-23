package az.iradasboot.rentacar.entity;

import az.iradasboot.rentacar.enums.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicle")
@Builder
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    @NotBlank(message = "Model must not be empty ")
    private String model;
    private String transmission;
    private Boolean airConditioning;
    private Integer year;
    private Integer seats;
    private Integer doors;
    private Integer horsepower;
    private Integer luggage;
    @Min(30)
    @Max(350)
    private Double dailyPrice;
    private Integer stock;
    @CreationTimestamp
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;
    private String imageUrl;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReservationEntity> reservations;
}
