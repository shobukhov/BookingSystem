# BookingSystem

Backend-приложение для бронирования переговорных комнат на Java и Spring Boot.

A room booking backend application built with Java and Spring Boot, featuring a layered architecture, REST API, CRUD operations, request validation, and global exception handling.

## Технологии

- Java 25
- Spring Boot 4.2.0
- Spring Web MVC
- Jakarta Validation
- Gradle
- JUnit 5

## Функциональность

- Полный CRUD для переговорных комнат.
- Проверка уникальности названий комнат.
- Централизованная обработка исключений через `@RestControllerAdvice`.
- Формирование ответов об ошибках с использованием `ProblemDetail.
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
| `PUT` | `/api/rooms/{id}` | Обновление комнаты |
| `DELETE` | `/api/rooms/{id}` | Удаление комнаты |

Пример создания или обновления комнаты:

```json
{
    "name": "B724",
    "capacity": 6
}
```

### HTTP-статусы

| Код | Описание |
| --- | --- |
| `200 OK` | Успешное получение или обновление комнаты |
| `201 Created` | Комната создана |
| `204 No Content` | Комната удалена |
| `400 Bad Request` | Некорректные входные данные |
| `404 Not Found` | Комната не найдена |
| `409 Conflict` | Комната с таким названием уже существует |

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