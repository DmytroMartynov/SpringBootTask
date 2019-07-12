package dmytro.martynov.Controller;

import dmytro.martynov.domain.PaymentRequest;
import dmytro.martynov.repos.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    RequestRepo requestRepo;

    @GetMapping("/add")
    public @ResponseBody
    String addRequest
            (@RequestParam Integer requestNumber,
             @RequestParam String date) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setRequestNumber(requestNumber);
        paymentRequest.setDate(date);
        requestRepo.save(paymentRequest);
        return "Request with unique number: " + paymentRequest.getId() + " saved!";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable< PaymentRequest > getAllRequests() {
        return requestRepo.findAll();
    }


    @GetMapping("/findRequest")
    public @ResponseBody
    String findRequestById(@RequestParam Long id) {
        return "Request completed for realization: " + requestRepo.findById(id);
    }
}
