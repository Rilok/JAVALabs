Scenario: Dodawanie dwoch dowolnych liczb

Given Wytwarzam nowy kalkulator
When dodam liczby <value1> i <value2>
Then wynik wyniesie <resultValue>

Examples:
|value1|value2|resultValue|
|5|3|8|

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