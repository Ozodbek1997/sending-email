/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 11:25 AM
 * Project Name: userservice
 */

package io.getarrays.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "confirmations")
public class Confirmation {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String token;

        private LocalDateTime cretedDate;

        @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
        @JoinColumn(nullable = false,name = "user_id")
        private User user;

        public Confirmation(User user){
                this.user = user;
                this.cretedDate = LocalDateTime.now();
                this.token = UUID.randomUUID().toString();
        }


}
