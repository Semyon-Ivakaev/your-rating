package dev.baseapi.Yourrating.user.subscription.model;

import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(schema = "your_rating", name = "subscriptions")
@EntityListeners(AuditingEntityListener.class)
// listener для авто создания временной отметки. В классе приложения добавить @EnableJpaAuditing, в app.yml добавить props
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserProfile follower;

    @OneToOne
    private UserProfile followed;

    @CreatedDate // @EntityListeners
    @Column(nullable = false, updatable = false) // создается, но не обновляется
    private Instant createdTimestamp;
}
