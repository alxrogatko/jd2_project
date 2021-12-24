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

    public Friends(String ownerId, String ownerName, String friendId, String friendName, LocalDateTime addDate, String status) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.friendId = friendId;
        this.friendName = friendName;
        this.addDate = addDate;
        this.status = status;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Setter
    @Column(name = "owner_id")
    private String ownerId;

    @Setter
    @Column(name = "owner_name")
    private String ownerName;

    @Setter
    @Column(name = "friend_name")
    private String friendName;

    @Setter
    @Column(name = "friend_id")
    private String friendId;

    @Setter
    @Column(name = "add_date")
    private LocalDateTime addDate;

    @Setter
    @Column(name = "status")
    private String status;
}
