
# **Demo API**

This is a Spring Boot application for managing orders. It demonstrates a clean and modular structure for building REST APIs with clear separation of concerns.

---

## **Project Structure**

The project follows the typical Spring Boot structure:

```
src
├── main
│   ├── java
│   │   └── com.example.demo
│   │       ├── controller
│   │       │   └── OrderController.java
│   │       ├── dto
│   │       │   └── OrderDto.java
│   │       ├── mapper
│   │       │   └── OrderMapper.java
│   │       ├── model
│   │       │   └── Order.java
│   │       ├── repository
│   │       │   └── OrderRepository.java
│   │       ├── service
│   │       │   └── OrderService.java
│   │       └── DemoApplication.java
├── test
│   ├── java
│   │   └── com.example.demo
│   │       ├── controller
│   │       │   └── OrderControllerTest.java
│   │       ├── repository
│   │       │   └── OrderRepositoryTest.java
│   │       ├── service
│   │       │   └── OrderServiceTest.java
│   │       └── AllTestsSuite.java
```

---

## **Responsibilities of Each Class**

### **1. `DemoApplication`**
- The main entry point of the Spring Boot application.
- Annotated with `@SpringBootApplication` to enable auto-configuration, component scanning, and Spring Boot features.
- **Responsibility**: Starts the application.

---

### **2. `controller` Package**
#### `OrderController`
- Handles incoming HTTP requests related to orders.
- Exposes REST API endpoints (e.g., `GET /api/orders`, `POST /api/orders`).
- Relies on the `OrderService` for business logic.
- Annotated with `@RestController` and uses `@RequestMapping`.

**Key Responsibilities**:
- Handle HTTP methods like GET, POST, DELETE, etc.
- Validate request payloads and handle exceptions.
- Return appropriate HTTP responses.

---

### **3. `dto` Package**
#### `OrderDto`
- A **Data Transfer Object** used to transfer order-related data between the client and the server.
- Includes only the fields exposed to the API (e.g., `customerName`, `customerEmail`, `products`, `orderDate`).

**Key Responsibilities**:
- Encapsulate the structure of the request and response payloads.
- Provide validation rules if necessary (e.g., `@NotNull`, `@Size`).

---

### **4. `mapper` Package**
#### `OrderMapper`
- Converts between the `Order` model and the `OrderDto`.
- Ensures the API is decoupled from the internal business logic and database structure.

**Key Responsibilities**:
- Convert `Order` objects to `OrderDto` for responses.
- Convert `OrderDto` objects to `Order` for incoming requests.

Example:
```java
public OrderDto toDto(Order order);
public Order toModel(OrderDto orderDto);
```

---

### **5. `model` Package**
#### `Order`
- Represents the **core business entity** for an order.
- Includes fields such as `id`, `customerName`, `customerEmail`, `products`, and `orderDate`.
- May be annotated with `@Entity` if using a database.

**Key Responsibilities**:
- Define the structure of the order entity.
- Serve as the foundation for business logic.

---

### **6. `repository` Package**
#### `OrderRepository`
- Acts as a data access layer.
- Simulates database operations using an in-memory list.

**Key Responsibilities**:
- Provide methods for CRUD operations:
  - `findAll()`
  - `findById(Long id)`
  - `save(Order order)`
  - `deleteById(Long id)`

---

### **7. `service` Package**
#### `OrderService`
- Encapsulates the **business logic** for managing orders.
- Relies on `OrderRepository` for data persistence.

**Key Responsibilities**:
- Process orders, validate business rules, and coordinate between the controller and repository layers.
- Example methods:
  - `getAllOrders()`
  - `getOrderById(Long id)`
  - `createOrder(Order order)`
  - `deleteOrder(Long id)`

---

## **Testing Structure**

### **1. `OrderControllerTest`**
- Tests the controller layer using `MockMvc`.
- Verifies the HTTP endpoints return the correct responses.

### **2. `OrderServiceTest`**
- Tests the service layer logic.
- Uses Mockito to mock the `OrderRepository`.

### **3. `OrderRepositoryTest`**
- Tests the repository layer.
- Ensures CRUD methods behave as expected.

### **4. `AllTestsSuite`**
- A test suite that groups all tests into a single entry point.

---

## **How to Run the Project**

### **Start the Application**
1. **Using Gradle**:
   ```bash
   ./gradlew bootRun
   ```
2. **Using an IDE**:
   - Locate the `DemoApplication` class.
   - Right-click and select **Run**.

3. **Using JAR File**:
   - Build the project:
     ```bash
     ./gradlew build
     ```
   - Run the JAR:
     ```bash
     java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
     ```

---

## **How to Test the Project**

1. **Run All Tests**:
   ```bash
   ./gradlew test
   ```
2. **Test a Single Test Class**:
   ```bash
   ./gradlew test --tests "com.example.demo.controller.OrderControllerTest"
   ```

---

## **API Endpoints**

| HTTP Method | Endpoint        | Description                     |
|-------------|-----------------|---------------------------------|
| GET         | `/api/orders`   | Get all orders                 |
| GET         | `/api/orders/{id}` | Get an order by ID             |
| POST        | `/api/orders`   | Create a new order             |
| DELETE      | `/api/orders/{id}` | Delete an order by ID          |

---

## **Tools & Frameworks**
- **Spring Boot**: Application framework.
- **Gradle**: Build tool.
- **JUnit 5**: Testing framework.
- **Mockito**: For mocking dependencies in unit tests.

---

## **Future Enhancements**
- Add a persistence layer using a database like MySQL or PostgreSQL.
- Introduce authentication and authorization using Spring Security.
- Add pagination for retrieving orders.

---
