/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 11:20 AM
 * Project Name: userservice
 */

package io.getarrays.userservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name;
        private String email;
        private String password;
        private Boolean isEnabled;


}
