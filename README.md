# Projekt

Quiz App

## O projekcie

Projekt prostej aplikacji QUIZ

## Główne cechy projektu

- wzorzec MVP
- obsługa REST API - Retrofit, Gson
- obsługa bazy danych - ormLite
- ButterKnife
- Glide
- Dagger2
- RxJava 

## Sposób działania

Obsługa API:
1. Odczyt lista quizów - podstawowe informacje o quizach
2. Dla każdego quizu z listy istnieje możliwość dodatkowego skonsumowania reszty pól zawierające dodatkowe szczegóły (QuizContent), na przykład: listę pytań, odpowiedzi, zakres, itp. Możliwość pobrania zawartości wszystkich quizów przy starcie programu lub przy kliknięciu (aktualna opcja).
Zapis do bazy danych:
1. Zapis listy quizów do bazy danych (przy starcie programu, przy podsumowaniu wyniku quizu i przy pauzie programu)

## Sposób działania
Start programu. Aplikacja:
- odczytuje wewnętrzną bazę danych,
- pobiera listę quizów (bez szczegółów)
- porównuje wyniki - quizy, z nowszą datą utworzenia - zostają odświeżone (zostaje tez zresetowany postęp- zawartość została zmieniona)
- przechodzi do aktywności wyświetlającej kategorię quizów 
(możliwe jest również automatyczne ściągnięcie zawartości dla wszystkich quizów)
- po pobraniu podstawowych/wymaganych danych zostaje uruchomiona kolejna aktywność
- główny prezenter przechowuje prezentery odpowiednio dla: listy quizów, planszy z odpowiedziami, planszy podsumowania wyników
- po wybraniu danego quizu - użytkownik zostaje przeniesiony do gry w wybrany quiz
- wyniki są zapisywanie w czasie pauzy programu lub przy zestawieniu wyników
- dodano wykrywanie uszkodzonej zawartości quizu oraz brak możliwości pobrania zawartości

## Podsumowanie
Na projekt był przeznaczony określony czas. 
Gdybym miał więcej czasu, poprawiłbym jeszcze kilka rzeczy tutaj. Mianowicie:
- dodanie wyboru kategorii na liście quizów
- manager bazy danych - ormLite - wcześniej korzystałem z sqlLite, nie miałem okazji korzystać wcześniej z ormLite.
Usprawniłbym helpera bazy danych z tasków asynchronicznych do RxJava/ zwracana dane jako Observable
- dodanie testów 
- poprawienie wyglądu, dodanie animacji

## Authors

* **Łukasz Wróblewski** - *Initial work* - [WroblewskiXYZ](https://github.com/WroblewskiXYZ)
