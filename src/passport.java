import java.io.IOException;
import java.util.Scanner;

public class passport {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input line with data of passport\nFormat: SURNAME NAME PATRONYMIC BIRTHDAY\n" +
                "Example Сизов Денис Александрович 19/07/1999\n");
        String data = in.nextLine();
        String NSP = ParserPassport.initials(data);
        String end = ParserPassport.gender(data);
        Integer age = ParserPassport.age(data);
        System.out.println(NSP);
        System.out.println(end);
        if (age == 0)
            System.out.println("incorrect format date");
        else
            System.out.println(age);
    }
}
