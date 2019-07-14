package dmytro.martynov.repos;

import dmytro.martynov.domain.PaymentRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RequestRepo extends CrudRepository< PaymentRequest, Long > {
  PaymentRequest findByStatus(String status);
}
