# fragile-calculator

A simple calculator application built in Java.

## About

`fragile-calculator` is a Java application that provides basic arithmetic functionality. The project includes an HTML file used solely to render the in-app help menu.

## Tech Stack

- **Java** — application logic and UI
- **HTML** — help menu only

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Building the JAR

The application must be packaged as a JAR file to run. From the project root:

```bash
javac -d out src/*.java
jar cfm fragile-calculator.jar MANIFEST.MF -C out .
```

> Make sure your `MANIFEST.MF` specifies the correct `Main-Class` entry point.

### Running the Application

Once built, run the JAR directly:

```bash
java -jar fragile-calculator.jar
```

## Contributing

Pull requests and issue reports are welcome.

## License

This project is unlicensed.
