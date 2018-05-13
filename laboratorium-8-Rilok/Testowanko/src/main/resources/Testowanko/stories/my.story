
Scenario: Dodawanie dwoch liczb

Given Wytwarzam nowy kalkulator
When dodam liczby 3i7
Then wynik wyniesie 10

Scenario: Odejmowanie dwoch liczb

Given Wytwarzam nowy kalkulator
When odejme liczby 12i3
Then wynik wyniesie 9

Scenario: Mnozenie dwoch liczb

Given Wytwarzam nowy kalkulator
When pomnoze liczby 15i3
Then wynik wyniesie 45

Scenario: Dzielenie dwoch liczb

Given Wytwarzam nowy kalkulator
When podziele liczby 15i4
Then wynik wyniesie 3.75

Scenario: Dodawanie dwoch dowolnych liczb

Given Wytwarzam nowy kalkulator
When dodam liczby <value1> i <value2>
Then wynik wyniesie <resultValue>

Examples:
|value1|value2|resultValue|
|5|3|8|

Scenario: Sprawdzanie czy mniejszy

Given Wytwarzam nowy kalkulator
When porownam czy 5 wiekszy od 2
Then jezeli wiekszy zwracam true

Scenario: Odejmowanie dwoch dowolnych liczb

Given Wytwarzam kolejny kalkulator
When odejmuje liczby <value1> i <value2>
Then wynik bedzie wynosil <resultValue>

Examples:
|value1|value2|resultValue|
|21|3|18|

Scenario: Odejmowanie dwoch dowolnych liczb

Given Wytwarzam nowy kalkulator
When odejmuje liczby <value1> i <value2>
Then wynik wyniesie <resultValue>

Examples:
|value1|value2|resultValue|
|10|3|7|