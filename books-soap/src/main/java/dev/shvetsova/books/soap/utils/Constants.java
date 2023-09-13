package dev.shvetsova.books.soap.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DD_MM_YYYY);
    public static final String TARGET_NAMESPACE = "https://spring.io/guides/gs-producing-web-service";
}