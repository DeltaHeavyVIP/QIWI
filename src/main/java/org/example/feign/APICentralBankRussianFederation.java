package org.example.feign;

import org.example.dto.QuotesListDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

public class APICentralBankRussianFederation {
    private final RestTemplate restTemplate;
    public static String GET_ALL_QUOTES_BY_DATE_URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";

    public APICentralBankRussianFederation() {
        this.restTemplate = new RestTemplate();
    }

    public QuotesListDto getAllQuotesByDate(String date) {
        return Objects.requireNonNull(restTemplate.getForObject(GET_ALL_QUOTES_BY_DATE_URL + date,
                QuotesListDto.class));
    }


    //GET_ALL_QUOTES_BY_DATE_URL + date.getDay() +
    //                        "/" + date.getMonth() + "/" + date.getYear()
}
