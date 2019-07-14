package dmytro.martynov.domain;


import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class PaymentRequest {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "requestNumber", nullable = false, unique = false)
    private Integer requestNumber;

    @Column(name = "dateOfRequest", nullable = false, unique = false)
    private Timestamp dateOfRequest;
    @Column(name = "status", nullable = false, unique = false)
    private String status;

    public Timestamp getdateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(String stringDate) {
        Date date = null;
        try {
            date = formatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        this.dateOfRequest = new Timestamp(date.getTime());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "id=" + id +
                ", requestNumber=" + requestNumber +
                ", startDate=" + formatter.format(dateOfRequest) +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber) {
        this.requestNumber = requestNumber;
    }

}

