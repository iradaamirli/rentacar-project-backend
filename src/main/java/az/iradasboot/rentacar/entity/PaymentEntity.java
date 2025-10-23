package az.iradasboot.rentacar.entity;

import az.iradasboot.rentacar.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long reservationId;
    @NotBlank(message = "Payment method must not be empty")
    @Pattern(
            regexp = "^(CASH|CARD|ONLINE)$",
            message = "The payment method can only be CASH, CARD, or ONLINE."
    )
    private PaymentMethod paymentMethod;
    private LocalDate paymentDate;
}
