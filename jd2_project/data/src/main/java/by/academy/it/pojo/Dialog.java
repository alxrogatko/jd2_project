package by.academy.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dialog")
@NoArgsConstructor
@Getter
@Component
@Scope("prototype")
public class Dialog {

    public Dialog(String firstUser, String firstUserNickname, String secondUser, String secondUserNickname, String lastMessage, String lastMessageSenderNickname, LocalDateTime createDate) {
        this.firstUser = firstUser;
        this.firstUserNickname = firstUserNickname;
        this.secondUser = secondUser;
        this.secondUserNickname = secondUserNickname;
        this.lastMessage = lastMessage;
        this.lastMessageSenderNickname = lastMessageSenderNickname;
        this.createDate = createDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "first_user")
    private String firstUser;

    @Column(name = "first_user_nickname")
    private String firstUserNickname;

    @Column(name = "second_user")
    private String secondUser;

    @Column(name = "second_user_nickname")
    private String secondUserNickname;

    @Column(name = "last_message")
    private String lastMessage;

    @Column(name = "last_message_sender_nickname")
    private String lastMessageSenderNickname;

    @Column(name = "create_date")
    private LocalDateTime createDate;

}
