# Projekt

Quiz App

## O projekcie

Projekt prostej aplikacji QUIZ
g
## Główne cechy projektu

- wzorzec MVP
- obsługa REST API - Retrofit, Gson
- obsługa bazy danych - ormLite
- butterknife
- Glide
- Dagger2
- RxJava 

## Sposób działania

Obsługa API:
1. Odczyt lista quizów - podstawowe informacje o quizach
2. Dla kadego quizu z listy istnieje mozliwość dodatkowego skosumowania reszty pól zawierające dodatkowe szczegóły (QuizContent), na przykład: listę pytań, odpowiedzi, zakres, itp. 

Zapis do bazdy danych:
1. Zapis podstawowej listy quizów do bazy danych

## Sposób działania
Start programu. Aplikacja:
- odczytuje wewnętrzną bazę danych,
- pobiera listę quizów (bez szczegółów)
- porównuje wyniki - quizy, z nowszą datą utworzenia - zostają odświezone (zostaje tez zresetowany postep- zawartosc zostala zmieniona)
- przechodzi do aktywności wyświetlającej kategorię quizów 
(mozliwe jest równiez automatyczne sciągnięcie zawartości dla wszystkich quizow)
- po pobraniu podstaowych/wymaganych danych zostaje uruchomiona kolejna aktywność
- główny presenter przechowuje presentery odpowiednio dla: listy quizow, planszy z odpowiedziami, planszy podsumowania wyników
- po wybraniu danego quizu - uzytkwonik zostaje przeniesiony do gry w wybrany quiz
- wyniki są zapisywanie w czasie pauzy programu lub przy zestawieniu wyników


## Sposób działania
Na projekt był przeznaczony określony czas. 
Gdybym miał więcej czasu, poprawiłbym jeszcze kilka rzeczy tutaj. Mianowicie:
- manager bazy danych - ormLite - wcześniej korzystałem z sqlLite, nie miałem okazji korzytać wcześniej z ormLite.
Usprawniłbym helpera bazy danych z tasków asynchronicznych do RxJava/ zwracana dane jako Observable
- dodanie testów 
- poprawienie wyglądu, dodanie animacji

## Authors

* **Łukasz Wróblewski** - *Initial work* - [WroblewskiXYZ](https://github.com/WroblewskiXYZ)


