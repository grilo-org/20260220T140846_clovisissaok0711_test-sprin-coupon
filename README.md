# test-sprin-coupon
Teste técnico de Coupon Spring Boot

🎫 Coupon API
API REST para gerenciamento de cupons de desconto, desenvolvida com Spring Boot, focada em regras de negócio sólidas e containerização.

🚀 Funcionalidades
Cadastro de Cupom: Cria cupons com validação de regras de negócio (limpeza de caracteres especiais, tamanho de código e data de validade).
Soft Delete: Exclusão lógica de cupons, mantendo os dados no banco para auditoria.
Documentação: API documentada com Swagger UI.

🛠️ Tecnologias
Java 17
Spring Boot 3
Spring Data JPA
H2 Database (Em memória)
Docker & Docker Compose

🏗️ Como Rodar o Projeto
Pré-requisitos
Docker Desktop instalado e rodando.

Passos
Clone o repositório:

Bash
git clone https://github.com/SEU_USUARIO/coupon-app.git
cd coupon-app
Gere o build do projeto (JAR):

Bash
# No Windows (PowerShell)
.\mvnw clean package -DskipTests

# No Linux/Mac
./mvnw clean package -DskipTests
Suba a aplicação com Docker:

Bash
docker-compose up --build
Acesse a API:

Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console: http://localhost:8080/h2-console
