# Project Title

A concise, production-ready Spring Boot application built with Java and Maven. This README explains how to build, run, test and configure the project on Windows (IntelliJ IDEA recommended).

## Table of Contents

1. \[Overview\]
2. \[Features\]
3. \[Tech Stack\]
4. \[Prerequisites\]
5. \[Quick Start\]
6. \[Configuration\]
7. \[Build & Packaging\]
8. \[Running Tests\]
9. \[Project Structure\]
10. \[Common Commands (Windows)\]
11. \[Logging & Monitoring\]
12. \[Contributing\]
13. \[License\]

## Overview

This project is a Spring Boot service providing REST APIs and standard application concerns: configuration, logging, tests, and packaging. It uses Maven for build and dependency management and targets Java 17+ (adjust `pom.xml` as needed).

## Features

- Spring Boot REST API
- Configuration via `application.yml` / `application.properties`
- Unit and integration tests (JUnit \5)
- Maven build and Maven Wrapper support
- Clear project structure for maintainability

## Tech Stack

- Java
- Spring Boot
- Maven
- JUnit \5 (testing)
- (Optional) Docker

## Prerequisites

- Java 17+ JDK installed and `JAVA_HOME` set
- Maven (optional if you use Maven Wrapper)
- Windows 10/11 (commands shown below)
- IntelliJ IDEA 2025.3.1 recommended for development

## Quick Start

1. Clone repository:
```bash
git clone https://github.com/<your-org>/<your-repo>.git
cd <your-repo>