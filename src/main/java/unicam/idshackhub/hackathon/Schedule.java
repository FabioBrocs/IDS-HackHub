package unicam.idshackhub.hackathon;

import lombok.Getter;
import lombok.Setter;
import unicam.idshackhub.utlities.Finished;

import java.time.LocalDateTime;

@Getter
@Setter
@Finished
public class Schedule {
    private LocalDateTime startRegistrationDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;

    public Schedule(LocalDateTime startRegistrationDate, LocalDateTime startDate, LocalDateTime endDate, String location) {
        if (startRegistrationDate != null && startDate != null && endDate != null && location != null) {
            if(startRegistrationDate.isBefore(startDate) && startRegistrationDate.isAfter(endDate)) {
                this.startRegistrationDate = startRegistrationDate;
                this.startDate = startDate;
                this.endDate = endDate;
                this.location = location;
            }
        }
    }

}
