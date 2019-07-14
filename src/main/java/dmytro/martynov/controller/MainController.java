package dmytro.martynov.controller;

import dmytro.martynov.domain.PaymentRequest;
import dmytro.martynov.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/add")
    public String addRequest
            (@RequestParam Integer requestNumber, @RequestParam String date) {
        return mainService.addReq(requestNumber, date);
    }

    @GetMapping("/all")
    public Iterable< PaymentRequest > getAllRequests() {
        return mainService.getAll();
    }


    @GetMapping("/getStatus")
    public String getStatusById(@RequestParam Long id) {
        return mainService.getStatus(id);
    }


    @PostMapping("/main")
    public String paymentStatus() {
        return mainService.paymentHolding();
    }


}



