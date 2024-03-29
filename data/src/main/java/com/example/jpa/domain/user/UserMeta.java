package com.example.jpa.domain.user;

import com.example.jpa.constant.Gender;
import com.example.jpa.domain.base.AbstractDate;
import com.example.jpa.domain.base.BirthDate;
import com.example.jpa.domain.base.Name;
import lombok.*;

import javax.persistence.*;

@Getter
@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMeta extends AbstractDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column
    private BirthDate birthDate;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private User user;

    @Builder
    private UserMeta(Name name, Gender gender, BirthDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
