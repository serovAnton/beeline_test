Тестовое задание для Билайн.

Для сборки артефакта выполнить команду "mvn package" из консоли в директории проекта
При сборке запускаются тесты, для корректных и некорректных входных данных.
Образ для докера собирается скриптом Dockerfile, лежащим в корне проекта.
После сборки из IDE приложение запускается на 8080 порту.

Приложение можно протестировать постманом, отправляя запрос типа
"http://localhost:8080/transferMoney?amount=1000&accountFrom=11111116&accountTo=11111111"
Данные тестовой базы можно посмотреть в src/main/java/com/example/beeline/LoadDatabase.java

Данный стек был выбран по причине недостатка времени :)