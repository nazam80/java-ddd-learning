package tv.codely.shared.domain;

public class IntegerMother {

    public static int random(){
        return MotherCreator.random().number().randomDigit();
    }
}
