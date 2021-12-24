package by.academy.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class User implements Serializable {

    public User(String email,
                LocalDateTime lastEmailChangeDate,
                String password,
                LocalDateTime lastPasswordChangeDate,
                String nickname,
                String gender,
                String age,
                String birthday,
                LocalDateTime date) {
        this.email = email;
        this.lastEmailChangeDate = lastEmailChangeDate;
        this.password = password;
        this.lastPasswordChangeDate = lastPasswordChangeDate;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.date = date;
    }

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
