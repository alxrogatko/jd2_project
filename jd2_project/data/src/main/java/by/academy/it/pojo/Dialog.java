package by.academy.it.pojo;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dialog")
@Getter
@Component
@Scope("prototype")
public class Dialog {

    public Dialog(String firstUser, String secondUser, String lastMessage, LocalDateTime createDate) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.lastMessage = lastMessage;
        this.createDate = createDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "first_user")
    private String firstUser;

    @Column(name = "second_user")
    private String secondUser;

    @Column(name = "last_message")
    private String lastMessage;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
