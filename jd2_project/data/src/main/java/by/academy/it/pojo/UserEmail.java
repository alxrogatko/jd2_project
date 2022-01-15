package by.academy.it.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_email")
@Data
@NoArgsConstructor
@Component
@Scope("prototype")
public class UserEmail implements Serializable {

    public UserEmail(String userId, String email, LocalDateTime date) {
        this.userId = userId;
        this.email = email;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "change_date")
    private LocalDateTime date;


}
