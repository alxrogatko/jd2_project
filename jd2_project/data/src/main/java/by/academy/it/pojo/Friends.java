package by.academy.it.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friends")
@NoArgsConstructor
@Getter
public class Friends {

    public Friends(String requesterId, String requesterNickname, String receiverId, String receiverNickname, LocalDateTime addDate, String status) {
        this.requesterId = requesterId;
        this.requesterNickname = requesterNickname;
        this.receiverId = receiverId;
        this.receiverNickname = receiverNickname;
        this.addDate = addDate;
        this.status = status;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Setter
    @Column(name = "requester_id")
    private String requesterId;

    @Setter
    @Column(name = "requester_nickname")
    private String requesterNickname;

    @Setter
    @Column(name = "receiver_nickname")
    private String receiverNickname;

    @Setter
    @Column(name = "receiver_id")
    private String receiverId;

    @Setter
    @Column(name = "add_date")
    private LocalDateTime addDate;

    @Setter
    @Column(name = "status")
    private String status;
}
