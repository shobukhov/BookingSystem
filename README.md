# BookingSystem

Backend-приложение для бронирования переговорных комнат на Java и Spring Boot.

A room booking backend application built with Java and Spring Boot, featuring a layered architecture, REST API, dependency injection, and request validation.

## Технологии

- Java 25
- Spring Boot 4.2.0
- Spring Web MVC
- Jakarta Validation
- Gradle
- JUnit 5

## Функциональность

- Получение списка переговорных комнат.
- Получение комнаты по идентификатору.
- Создание новых комнат.
- Валидация входящих запросов.
- Хранение данных в памяти приложения.

## Архитектура

Приложение использует трёхслойную архитектуру (Three-Layer Architecture):

- **Controller** — обработка HTTP-запросов.
- **Service** — бизнес-логика.
- **Repository** — доступ к данным.

Внедрение зависимостей осуществляется через конструкторы (Constructor Injection).

## REST API

| Метод | Endpoint | Описание |
| --- | --- | --- |
| `GET` | `/api/rooms` | Получение всех комнат |
| `GET` | `/api/rooms/{id}` | Получение комнаты по ID |
| `POST` | `/api/rooms` | Создание комнаты |

Пример создания комнаты:

```json
{
    "name": "B724",
    "capacity": 6
}
```

Данные хранятся в памяти и сбрасываются при перезапуске приложения.

## Запуск

Требуется JDK 25.

```bash
./gradlew bootRun
```

Приложение доступно по адресу `http://localhost:8080`.

## Тестирование

```bash
./gradlew test
```

## Лицензия

[MIT License](LICENSE).