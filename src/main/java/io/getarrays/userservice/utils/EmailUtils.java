/**
 * @author: Bek
 * Date: 12/16/2023
 * Time: 4:27 PM
 * Project Name: userservice
 */

package io.getarrays.userservice.utils;

public class EmailUtils {


    public static String getEmailMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\nYour account has been created. Please click the link below to verify your account. \n\n" +
                getVerificationUrl(host, token) + "\n\nThe support team";
    }

    private static String getVerificationUrl(String host, String token) {
        return host + "/api/users?token=" + token;
    }

}
