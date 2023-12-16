/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 3:40 PM
 * Project Name: userservice
 */

package io.getarrays.userservice.service;

public interface EmailService {


    void sendSimpleMailMessage(String name, String to, String token);
    void sendMimeMessageWithAttachements(String name, String to, String token);
    void sendMimeMessageWithEmbeddedImages(String name, String to, String token);
    void sendMimeMessageWithEmbedFiles(String name, String to, String token);
    void sendHtmlEmail(String name, String to, String token);
    void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token);


}
