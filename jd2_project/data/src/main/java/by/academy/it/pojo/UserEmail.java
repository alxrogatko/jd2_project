package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_email")
@Getter
public class UserEmail {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "change_date")
    @Setter
    private LocalDateTime date;

    @Column(name = "first_authorisation")
    @Setter
    private boolean firstAuthorisation;
}
