# Cat Facts Spring Boot Application

Welcome to the **Cat Facts Spring Boot Application**! 🐱🚀

This project demonstrates how to efficiently parse a JSON API response using **Spring Boot** and **Feign Client**. The application calls an external API to retrieve cat facts and processes the response into a clean, strongly-typed Java object. Perfect for learning how to integrate Feign Client into your Spring Boot applications!

---

## 📋 **Project Overview**

This project fetches random cat facts from the **MeowFacts API** and prints them out. It uses **Feign Client** to make API requests, and **Spring Boot** to manage the application. The response is parsed into a **DTO (Data Transfer Object)** class for cleaner and more maintainable code.

---

## ⚙️ **How to Set Up**

### Prerequisites

Make sure you have the following installed:

- Java 11 or newer
- Spring Boot
- Maven or Gradle
- An IDE like IntelliJ IDEA or Eclipse

---

### **Clone the Repository**

```bash
git clone https://github.com/YvesHakizimana/cat-facts-spring-boot.git
cd cat-facts-spring-boot
```

---

### **Set Up Dependencies**

Ensure that the project dependencies are set up in your `pom.xml` (Maven) or `build.gradle` (Gradle) files. The key dependencies are:

- **Spring Boot Starter Web**
- **Spring Cloud OpenFeign**

---

### **Run the Application**

To start the application, simply run:

```bash
mvn spring-boot:run
```

The application will start running on `http://localhost:8084`.

---

## 🛠️ **Endpoints**

### **GET /cat-facts**

This endpoint fetches random cat facts. You can specify how many facts to retrieve by adding a `count` query parameter (defaults to 3).

Example:

```
http://localhost:8080/cat-facts?count=3
```

### **Response Format:**

```json
{
  "data": [
    "Your cat recognizes your voice but just acts too cool to care (probably because they are).",
    "The world's richest cat is worth $13 million after his human passed away and left her fortune to him.",
    "A cat has ran for mayor of Mexico City in 2013."
  ]
}
```

---

## 💻 **Code Breakdown**

### 1. **DTO (Data Transfer Object) Class**

This class is responsible for mapping the API response:

```java
package com.rca.demofeign.dto;

import java.util.List;

public class CatFactResponse {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CatFactResponse{" +
                "data=" + data +
                '}';
    }
}
```

### 2. **Feign Client**

We use Feign to call the external API and map the response to the `CatFactResponse` DTO:

```java
package com.rca.demofeign;

import com.rca.demofeign.dto.CatFactResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CatFacts", url = "https://meowfacts.herokuapp.com/")
public interface DemoService {

    @GetMapping
    CatFactResponse getCatFacts(@RequestParam("count") int count);
}
```

### 3. **Service Layer**

The service layer fetches the cat facts and processes them:

```java
package com.rca.demofeign;

import com.rca.demofeign.dto.CatFactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatFactService {

    @Autowired
    private DemoService demoService;

    public void fetchCatFacts(int count) {
        CatFactResponse response = demoService.getCatFacts(count);

        if (response != null && response.getData() != null) {
            System.out.println("Cat Facts:");
            response.getData().forEach(System.out::println);
        } else {
            System.out.println("No data received from the API.");
        }
    }
}
```

---

## 🔄 **Debugging and Logging**

If you're having trouble with the response, enable **Feign Logging** in `application.properties` to view the raw API response:

```properties
logging.level.feign.Client=DEBUG
```

This will log the response and help you troubleshoot issues.

---

## 🧑‍💻 **Contributing**

Feel free to fork the project and create pull requests. If you find bugs or have any improvements in mind, please let me know by opening an issue!

---

## 📧 **Contact Information**

- **Author:** Yves Hakizimana
- **Email:** yvhakizimana123@gmail.com
- **GitHub:** [@YvesHakizimana](https://github.com/YvesHakizimana)

---

## 📜 **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Happy coding! 🎉