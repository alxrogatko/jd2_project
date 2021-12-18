package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_email")
@Getter
@Setter
@Component
@Scope("prototype")
public class UserEmail {

    public UserEmail(String userId, String email, LocalDateTime date) {
        this.userId = userId;
        this.email = email;
        this.date = date;
    }

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "change_date")
    private LocalDateTime date;


}
