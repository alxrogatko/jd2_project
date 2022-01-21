package by.academy.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "settings")
@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class Settings {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "avatar_img")
    private byte[] avatarImg;

}
