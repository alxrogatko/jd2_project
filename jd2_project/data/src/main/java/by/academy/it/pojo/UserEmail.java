package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
}
