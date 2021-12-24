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

    public Friends(String ownerId, String friendId, LocalDateTime addDate, String status) {
        this.ownerId = ownerId;
        this.friendId = friendId;
        this.addDate = addDate;
        this.status = status;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    private String ownerId;
    @Setter
    private String friendId;
    @Setter
    private LocalDateTime addDate;
    @Setter
    private String status;
}
