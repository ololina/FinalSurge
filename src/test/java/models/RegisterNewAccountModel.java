package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterNewAccountModel {

    private String firstName;
    public String lastName;
    public String emailAddress;
    public String password;
    public String matchPassword;
}
