package org.example;

import org.example.dto.QuotesDto;
import org.example.dto.QuotesListDto;
import org.example.feign.APICentralBankRussianFederation;
import org.example.utils.Helper;

import java.util.Date;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        Helper.validateCommandArg(args);
        String code = args[1].trim().split("=")[1];
        Date date = Helper.convertStringToDate(args[2].trim().split("=")[1]);

        APICentralBankRussianFederation apiCentralBankRussianFederation = new APICentralBankRussianFederation();
        QuotesListDto quotesListDto =
                apiCentralBankRussianFederation.getAllQuotesByDate(Helper.convertDateToString(date));
        QuotesDto quotesDto =
                quotesListDto.getQuotesDtos().stream().filter(e -> e.getCharCode().equals(code)).findFirst().orElseThrow(() -> new RuntimeException(String.format("I can't find quotes with code %s", code)));

        System.out.println(quotesDto.getValue());
    }
}
