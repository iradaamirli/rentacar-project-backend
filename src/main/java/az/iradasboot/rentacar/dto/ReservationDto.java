package az.iradasboot.rentacar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationDto {
    private String customerName;
    private Integer age;
    private String password;
    private String email;
    private Double totalPrice;
    private LocalDate startDate;
    private LocalDate endDate;

}
