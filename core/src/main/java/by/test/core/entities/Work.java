package by.test.core.entities;

import by.test.core.utils.DefaultInstantDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "works")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time_spent_on_work")
    private Integer timeSpentOnWork;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = DefaultInstantDeserializer.class)
    private Instant updatedAt;
}
