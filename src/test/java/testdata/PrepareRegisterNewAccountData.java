package testdata;

import models.RegisterNewAccountModel;
import utils.FakeMessageGenerator;

public class PrepareRegisterNewAccountData {


    public static RegisterNewAccountModel getValidData() {
        String password = FakeMessageGenerator.generatePassword();
        return RegisterNewAccountModel.builder().firstName(FakeMessageGenerator.generateName())
                .lastName(FakeMessageGenerator.generateSurname())
                .emailAddress(FakeMessageGenerator.generateEmail())
                .password(password)
                .matchPassword(password)
                .build();

    }
}
