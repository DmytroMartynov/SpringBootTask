package dmytro.martynov.service;

import dmytro.martynov.domain.PaymentRequest;
import dmytro.martynov.domain.RequestStatus;
import dmytro.martynov.repos.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class MainService {
    @Autowired
    RequestRepo requestRepo;

    public String addReq(Integer requestNumber, String date) {
        PaymentRequest paymentRequest = new PaymentRequest(requestNumber,RequestStatus.getRandom().toString(), date);
        requestRepo.save(paymentRequest);
        return "unique request id: " + paymentRequest.getId() + ". request status: " +
                paymentRequest.getStatus() + ", saved!";
    }

    public Iterable< PaymentRequest > getAll() {
        return requestRepo.findAll();
    }

    public String getStatus(Long id) {
        return requestRepo.findById(id).get().getStatus();
    }

    @Scheduled(fixedDelay = 60_000)
    public String paymentHolding() {
        Iterable< PaymentRequest > requestList = getAll();
        for (PaymentRequest iter : requestList) {
            if (iter.getStatus().equals(RequestStatus.ERROR.toString())) {
                iter.setStatus(RequestStatus.HELD.toString());
                requestRepo.save(iter);
                return "Request status was changed from ERROR to Held!";
            } else if (iter.getStatus().equals(RequestStatus.PROCESSED.toString())) {
                iter.setStatus(RequestStatus.HELD.toString());
                requestRepo.save(iter);
                return "Request status was changed from PROCESSED to Held!";
            }
        }
        return "Payment is OK!";
    }
}



