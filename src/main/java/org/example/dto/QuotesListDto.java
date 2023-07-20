package org.example.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValCurs", namespace = "http://tempuri.org/")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuotesListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Valute")
    private List<QuotesDto> quotesDtos;

    public QuotesListDto() {
    }

    public QuotesListDto(List<QuotesDto> quotesDtos) {
        this.quotesDtos = quotesDtos;
    }

    public void setQuotesDtos(List<QuotesDto> quotesDtos) {
        this.quotesDtos = quotesDtos;
    }

    public List<QuotesDto> getQuotesDtos() {
        return quotesDtos;
    }
}