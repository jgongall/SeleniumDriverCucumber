# Java Cucumber Selenium Example

Proyecto Maven de ejemplo con:
- Java 17
- Cucumber JVM
- Selenium WebDriver
- WebDriverManager

## Estructura
- `pom.xml`: configuración de Maven y dependencias.
- `src/test/resources/features`: feature de Cucumber.
- `src/test/java/com/example/steps`: definiciones de pasos.
- `src/test/java/com/example/runner`: ejecutor de pruebas con JUnit Platform.

## Ejecutar
1. Asegúrate de tener Java 17 instalado.
2. Instala Maven si no está disponible.
3. Desde el directorio raíz del proyecto, ejecuta:

```bash
mvn test
```

> `WebDriverManager` descargará el controlador de Chrome automáticamente.
> Es necesario tener Chrome instalado para ejecutar el test.
