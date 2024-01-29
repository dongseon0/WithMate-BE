package com.gdscewha.withmate.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId", updatable = false)
    private Long id;

    @Column(nullable = false, name = "userName", unique = true)
    private String userName;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "passwd")
    private String passwd;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(nullable = false, name = "birth")
    private String birth;

    @Column(nullable = false, name = "country")
    private String country;

    @Builder.Default
    @Column(nullable = false, name = "regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate regDate = LocalDate.now();

    @Builder.Default
    @Column(nullable = false, name = "loginDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate loginDate = LocalDate.now();

    @Builder.Default
    @Column(nullable = false, name = "isRelationed")
    private Boolean isRelationed = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Member updateLoginDate() {
        this.loginDate = LocalDate.now();
        return this;
    }
}
