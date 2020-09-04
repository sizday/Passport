import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class ParserPassport {

    public static boolean isDateValid(String date) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String initials(String input) {
        String[] words = input.split(" ");
        String NSP = words[1].substring(0,1) + "." + words[2].substring(0,1) + "." + words[0];
        return NSP;
    }

    public static String gender(String input) {
        String[] words = input.split(" ");
        String endStr = words[2].substring(words[2].length()-4);
        if ((endStr.equals("ович")) || (endStr.equals("евич")))
            return "М";
        else if ((endStr.equals("овна")) || (endStr.equals("евна")))
            return "Ж";
        else
            return "";
    }

    public static Integer age(String input) {
        String[] words = input.split(" ");
        String[] dates = words[3].split("/");
        int day = 0, month = 0, year = 0;
        boolean check = true;
        String str = dates[0] + "." + dates[1] + "." + dates[2];
        if (!isDateValid(str))
            check = false;
        GregorianCalendar birthDay;
        int years = 0;
        if (!check)
            System.out.println("error");
        else {
            day = Integer.parseInt(dates[0]);
            month = Integer.parseInt(dates[1]);
            year = Integer.parseInt(dates[2]);
            birthDay = new GregorianCalendar(year, month, day);
            GregorianCalendar checkDay = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 28);
            years = checkDay.get(GregorianCalendar.YEAR) - birthDay.get(GregorianCalendar.YEAR);
            int checkMonth = checkDay.get(GregorianCalendar.MONTH);
            int birthMonth = birthDay.get(GregorianCalendar.MONTH);
            if (checkMonth < birthMonth)
                years--;
            else if (checkMonth == birthMonth
                    && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthDay.get(GregorianCalendar.DAY_OF_MONTH))
                years--;
        }
        return years;
    }
}
