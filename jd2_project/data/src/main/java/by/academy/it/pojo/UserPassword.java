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
@Table(name = "user_password")
@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class UserPassword implements Serializable {

    public UserPassword(String userId, String password, LocalDateTime date) {
        this.userId = userId;
        this.password = password;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "id")
    private String id;

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
