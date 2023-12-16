/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 12:47 PM
 * Project Name: userservice
 */

package io.getarrays.userservice.resource;


import io.getarrays.userservice.model.HttpResponse;
import io.getarrays.userservice.model.User;
import io.getarrays.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpResponse> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("user", newUser))
                        .message("User created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<HttpResponse> confirmNewUserAccount(@RequestParam("token") String token){
        Boolean isSuccess = userService.verifyToken(token);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Success:",isSuccess))
                        .message("Account verified")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


}
