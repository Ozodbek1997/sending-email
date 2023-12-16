/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 11:37 AM
 * Project Name: userservice
 */


package io.getarrays.userservice.repository;

import io.getarrays.userservice.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {

    Confirmation findByToken(String token);

}
