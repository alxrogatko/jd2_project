package by.academy.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class Messages {

    public Messages(String senderId, String receiverId, String message, LocalDateTime messageDate) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.messageDate = messageDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private LocalDateTime messageDate;
}
