# Dynamic SQL Assistant with LangChain4j and Spring Boot

This project demonstrates a **dynamic database querying assistant** using **LangChain4j** and **Spring Boot**.  
The assistant uses a **large language model (LLM)** to generate SQL queries based on natural-language questions and executes them safely on a MySQL database.  

Unlike traditional tool-based assistants, this implementation dynamically fetches the database schema at runtime, allowing support for multiple tables without hardcoding.

---

## Table of Contents

- [Features](#features)  
- [Architecture](#architecture)  
- [Tech Stack](#tech-stack)  
- [Setup](#setup)  
- [Configuration](#configuration)  
- [Usage](#usage)  
- [Example Queries](#example-queries)  
- [Safety Considerations](#safety-considerations)  
- [Future Enhancements](#future-enhancements)  

---

## Features

- LLM-powered assistant that generates **SQL SELECT queries dynamically**.  
- **Dynamic schema introspection** — automatically detects tables and columns.  
- Safe query execution using Spring’s **JdbcTemplate**.  
- REST API endpoint for user interaction.  
- Supports multi-table queries in a flexible and maintainable way.  
- Can return results as **structured JSON** for easier LLM reasoning.  

---

- **User**: Sends natural-language questions via HTTP POST.  
- **REST API**: `/chat` endpoint receives requests.  
- **ChatService**: Injects live database schema into prompt.  
- **LangChain4j Assistant**: Generates SQL queries dynamically.  
- **DatabaseQueryTool**: Executes safe SQL queries (SELECT-only) on MySQL.  
- **MySQL**: Stores your application data.  

---

## Tech Stack

- **Java 17+ / Spring Boot 3+**  
- **LangChain4j** (Google Gemini or OpenAI chat model)  
- **Spring JDBC / JdbcTemplate**  
- **MySQL** (or any JDBC-compatible database)  
- **Jackson** for JSON serialization  

---

## Setup

1. Clone the repository:(https://github.com/Shubham3111999/Langchain-SpringBoot-MySql-Prompt_Interaction.git)
2. Change the application.yml file as per your configuration
3. I have used Gemini in this project. Change the Model if you want (.pom as well as LangChainConfig.java file need to be changed)
4. Add some products to the "products" table created
5. Now, heat the post API with your questions
   <img width="1331" height="310" alt="image" src="https://github.com/user-attachments/assets/6cdf68f5-bc09-4af4-a440-9efe6b3362ef" />
   <img width="1298" height="392" alt="image" src="https://github.com/user-attachments/assets/cb2a1daa-f97c-4594-bfb6-219ca765eb41" />

