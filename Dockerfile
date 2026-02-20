# Usa uma imagem Java 17 leve
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado pelo Maven para dentro do container
# IMPORTANTE: Certifique-se de ter rodado 'mvn clean package' antes
COPY target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]