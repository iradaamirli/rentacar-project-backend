package az.iradasboot.rentacar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "reservation")
@Builder
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Customer name must not be empty ")
    private String customerName;
    private Integer age;
    @Size(max = 16, min = 5)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",
            message = "Password ən az 6 simvol, 1 böyük hərf, 1 kiçik hərf və 1 rəqəm olmalıdır"
    )
//    @NotBlank(message = "Password must not be empty ")
    private String password;
    @Email(message = "Email is not correct")
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        if (startDate != null && endDate != null && vehicle != null && vehicle.getDailyPrice() != null) {
            long days = ChronoUnit.DAYS.between(startDate, endDate);
            if (days <= 0) days = 1;
            totalPrice = days * vehicle.getDailyPrice();
        }
    }
}
