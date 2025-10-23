package az.iradasboot.rentacar.specification;

import az.iradasboot.rentacar.entity.VehicleEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class VehicleSpecification {
    public static Specification<VehicleEntity> searchBrand (String brand){
        return (r,q,c) ->
                brand == null ? c.conjunction() : c.equal(r.get("brand"),brand);
    }
    public static Specification<VehicleEntity> searchModel (String model){
        return (r,q,c) ->
                model == null ? c.conjunction() : c.equal(r.get("model"),model);
    }
}
