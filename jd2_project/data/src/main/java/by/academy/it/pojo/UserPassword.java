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
@Table(name = "user_password")
@Getter
@Component
@Scope("prototype")
public class UserPassword {

    public UserPassword(String userId, String password, LocalDateTime date) {
        this.userId = userId;
        this.password = password;
        this.date = date;
    }

    @Id
    @Column(name = "user_id")
    @Setter
    private String userId;

    @Column(name = "user_password")
    @Setter
    private String password;

    @Column(name = "change_date")
    @Setter
    private LocalDateTime date;
}
