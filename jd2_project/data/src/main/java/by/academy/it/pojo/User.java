package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
public class User {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "user_id")
    @Setter
    private String id;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "last_email_change_date")
    @Setter
    private LocalDateTime lastEmailChangeDate;

    @Column(name = "password")
    @Setter
    private String password;

    @Column(name = "last_password_change_date")
    @Setter
    private LocalDateTime lastPasswordChangeDate;

    @Column(name = "nickname")
    @Setter
    private String nickname;

    @Column(name = "gender")
    @Setter
    private String gender;

    @Column(name = "age")
    @Setter
    private String age;

    @Column(name = "birthday")
    @Setter
    private String birthday;

    @Column(name = "create_date")
    @Setter
    private LocalDateTime date;
}
