# Automation Selenium Grid Project

Este projeto utiliza o Selenium Grid para executar testes automatizados em paralelo e distribuídos. Ele foi configurado com as bibliotecas Selenium, TestNG, DataFaker, Allure, e Lombok, visando facilitar a criação de testes eficientes e organizados.

## Tecnologias Utilizadas

- **Selenium (v4.25.0)**: Ferramenta para automação de navegadores.
- **TestNG (v7.10.2)**: Framework para automação de testes com suporte a testes em paralelo e priorização.
- **Lombok (v1.18.34)**: Biblioteca que simplifica a criação de classes Java eliminando código boilerplate.
- **DataFaker (v2.4.0)**: Biblioteca para geração de dados aleatórios para os testes.
- **Allure TestNG**: Integração com Allure para gerar relatórios detalhados de testes.
- **Selenium Grid (v4.25.0)**: Ferramenta para distribuir a execução dos testes em diferentes máquinas e ambientes.

## Pré-requisitos

- JDK 11 ou superior
- Maven 3.6+ instalado
- Navegadores instalados (Chrome, Firefox, etc.)
- [Selenium Grid](https://www.selenium.dev/documentation/grid/getting_started/) configurado para execução distribuída

## Instalação e Configuração

1. Clone este repositório:

    ```bash
    git clone https://github.com/thalesxbrasileiro/automation-seleniumgrid.git
    ```

2. Navegue até a pasta do projeto:

    ```bash
    cd automation-seleniumgrid
    ```

3. Instale as dependências do Maven:

    ```bash
    mvn clean install
    ```

4. Configure o Selenium Grid como hub e inicie os nodes:

    ```bash
    java -jar selenium-server-<version>.jar hub
    ```

   Em outra máquina ou terminal para o node:

    ```bash
    java -jar selenium-server-<version>.jar node --url http://<hub-ip>:4444
    ```

## Configuração Standalone do Selenium Grid

Caso prefira simplificar a configuração do Selenium Grid, você pode optar pelo modo standalone, onde hub e node são executados juntos em uma única máquina.

1. Baixe o servidor do Selenium:

    ```bash
    curl -O https://selenium-release.storage.googleapis.com/<version>/selenium-server-standalone-<version>.jar
    ```

2. Execute o servidor Selenium no modo standalone:

    ```bash
    java -jar selenium-server-standalone-<version>.jar standalone
    ```

Essa configuração permite que você execute o Selenium Grid sem precisar configurar máquinas separadas para hub e node, facilitando o processo de automação localmente ou em pequenos ambientes de teste.

## Estrutura do Projeto

- **src/main/java**: Contém o código principal e as classes de utilidades para a automação.
- **src/test/java**: Contém as classes de testes automatizados utilizando TestNG.
- **resources**: Contém arquivos de configuração, como o `testng.xml` para definir o plano de execução dos testes.

## Executando os Testes

1. Para rodar os testes com TestNG:

    ```bash
    mvn test
    ```

2. Para rodar os testes e gerar o relatório Allure:

    ```bash
    mvn clean test allure:serve
    ```

## Relatórios de Testes

Os relatórios de teste são gerados automaticamente pelo **Allure**. Após a execução dos testes, você pode gerar e visualizar os relatórios usando:

```bash
mvn allure:serve
