package dmytro.martynov.repos;

import dmytro.martynov.domain.PaymentRequest;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepo extends CrudRepository< PaymentRequest, Long > {
}
