package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_password")
@Getter
public class UserPassword {

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
