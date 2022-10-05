package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterNewAccountModel {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String matchPassword;
}
