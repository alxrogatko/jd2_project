package by.academy.it.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info")
@Getter
public class UserInfo {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    @Setter
    private String userId;

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
    private Date birthday;
}
