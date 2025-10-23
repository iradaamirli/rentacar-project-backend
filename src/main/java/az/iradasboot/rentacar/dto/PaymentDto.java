package az.iradasboot.rentacar.dto;

import az.iradasboot.rentacar.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentDto {
    private Long reservationId;
    private PaymentMethod paymentMethod;
}
