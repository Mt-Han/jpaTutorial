package com.shop.app.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private Long idx;


    @Column(unique = true)
    private String loginId;

    private String password;

    private String name;
}
