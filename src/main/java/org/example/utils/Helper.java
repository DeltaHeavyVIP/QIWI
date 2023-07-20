package org.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static void validateCommandArg(String[] args) {
        //TODO replace const
        if (args.length != 3) throw new RuntimeException("Invalid command Exception. Example: " +
                "currency_rates --code=XXX --date=YYYY-MM-DD");
        if (args[0].isEmpty() || !args[0].equals("currency_rates")) throw new RuntimeException("Invalid command " +
                "Exception. Unknown command.");

        String[] codeArgument = args[1].trim().split("=");
        if (codeArgument.length != 2 || !codeArgument[0].trim().equals("--code") || codeArgument[1].isEmpty())
            throw new RuntimeException("Invalid argument. Use --code argument");

        String[] dateArgument = args[2].trim().split("=");
        if (dateArgument.length != 2 || !dateArgument[0].trim().equals("--date") || dateArgument[1].isEmpty())
            throw new RuntimeException("Invalid argument. Use --date argument");
    }

    public static Date convertStringToDate(String stringDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid value argument --date");
        }
        return date;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dmyFormat.format(date);
    }

}
