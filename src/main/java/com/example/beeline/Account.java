package com.example.beeline;




import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Account {

    @Id
    private Integer account_id;

    @Column(nullable = false)
    private Integer amount;

}
