# 🏠 Sistema de Controle de Casa Inteligente

Um sistema robusto baseado em Java para gerenciamento de dispositivos eletrônicos como TVs e Ares-Condicionados. Construído com recursos e padrões de projeto Java modernos.

## 📋 Índice
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Tecnologias](#-tecnologias)
- [Começando](#-começando)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Executando Testes](#-executando-testes)
- [Padrões de Projeto](#-padrões-de-projeto)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)

## ✨ Funcionalidades

### Controle de Dispositivos
- 📺 Gerenciamento de TV
    - Ligar/Desligar
    - Mudança de canal
    - Ajuste de volume
    - Monitoramento de status

- ❄️ Gerenciamento de Ar-Condicionado
    - Ligar/Desligar
    - Ajuste de temperatura
    - Mudança de modo (AUTO/COOL/DRY/HEAT)
    - Monitoramento de status

### Funcionalidades do Sistema
- Gerenciamento centralizado de dispositivos
- Tratamento de erros e validação
- Interface interativa via console
- Persistência do estado dos dispositivos (em memória)

## 🏗️ Arquitetura

O projeto segue uma abordagem de arquitetura limpa com clara separação de responsabilidades:

```
src/
├── command/        # Padrão Command para as ações do menu interativo
├── menu/           # Gerenciamento do layout do menu
├── model/          # Modelos de domínio
├── service/        # Camada de serviço para operações de negócio e lógica de negócio
├── controller/     # Fluxo de controle da aplicação
├── view/           # Interface do usuário
├── exceptions/     # Exceções personalizadas
└── util/           # Classes utilitárias
```

### Padrões de Projeto Utilizados
- Padrão Command (Interações do menu)
- MVC (Arquitetura geral)

## 🔧 Tecnologias

- Java 21
- JUnit 5 para testes
- Mockito para simulações
- AssertJ
- Maven para gerenciamento de dependências

## 🚀 Começando

### Pré-requisitos
- Java 21
- Maven 3.11+

### Instalação

1. Clone o repositório
```bash
git clone https://github.com/seunome/sistema-casa-inteligente.git
```

1. Construa e Execute o projeto
```bash
mvn clean compile exec:java
```

## 📁 Estrutura do Projeto

```
sistema-casa-inteligente/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├──command
│   │       │   ├── impl (implementações Command)
│   │       │   └── MenuCommand.java
│   │       ├── controller/
│   │       │   ├── DeviceController.java
│   │       │   └── HomeController.java
│   │       ├── exception/
│   │       │   ├── DeviceNotFoundException.java
│   │       │   └── DeviceOperationException.java
│   │       ├── menu/
│   │       │   └── MenuManager.java
│   │       ├── model/
│   │       │   ├── Air.java
│   │       │   ├── Device.java
│   │       │   ├── Home.java
│   │       │   ├── Mode.java
│   │       │   └── TV.java
│   │       ├── service/
│   │       │   ├── impl (implementações Service)
│   │       │   ├── AirService.java
│   │       │   ├── DeviceService.java
│   │       │   ├── HomeService.java
│   │       │   └── TVService.java
│   │       ├── util/
│   │       │   ├── Util
│   │       └── view/
│   │           └── ConsoleView.java
│   └── test/
│       └── java/
│           └── service/
├── pom.xml
└── README.md
```

## 🧪 Executando Testes

Execute todos os testes:
```bash
mvn test
```

## 💡 Padrões de Projeto

### Padrão Command
Usado para operações do menu:
```java
public interface MenuCommand {
    void executar();
    String getDescricao();
}
```

### Padrão MVC
```java
// Model
public sealed abstract class Device permits TV, Air { /*...*/ }

// View
public class ConsoleView { /*...*/ }

// Control
public class HomeController { /*...*/ }
```

## 🔍 Exemplos de Código

### Adicionando um Novo Dispositivo

```java
import br.com.g4f.model.Home;
import br.com.g4f.service.HomeService;
import br.com.g4f.service.impl.HomeServiceImpl;


HomeService homeService ...;
TV tv = new TV("Samsung", "Smart TV");
homeService.addDevice(tv);

```

### Usando o Sistema de Menu
```java
MenuManager menu = new MenuManager(view);
menu.addCommand(1, new TurnOnOffCommand(tv, servicoTV));
menu.addCommand(2, new ChangeChannelCommand(tv, servicoTV));
menu.displayMenu("Controles da TV");
```

Construído com ❤️ por [Seu Nome]
