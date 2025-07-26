
# 🛒 Sistema de Pedidos com Padrões de Projeto

Sistema desenvolvido em Java como exercício prático da disciplina **APOO - Análise e Projeto Orientado a Objetos**, sob orientação do **Professor Delano Hélio**. O sistema simula uma loja virtual com funcionalidades de cadastro, pedidos, cálculo de frete, envio de notificações e apresentação via terminal, utilizando **padrões de projeto** para modularidade e coesão.

---

## 🎯 Objetivo

Criar um sistema com as seguintes funcionalidades:

- Cadastro de clientes e produtos  
- Criação de pedidos com múltiplos itens  
- Cálculo de frete com estratégias configuráveis  
- Envio simulado de notificações por E-mail, SMS ou WhatsApp  
- Interface em linha de comando (terminal) para o usuário  

---

## 🧱 Tecnologias Utilizadas

- **Java 21 (OpenJDK 21.0.5)**  
- Paradigma: **Programação Orientada a Objetos**  
- Interface: **Terminal (CLI)**  
- Padrões aplicados: **Builder, Strategy, Factory, Singleton, Template Method, Arquitetura de Camadas**  

---

## 🗂️ Estrutura de Pacotes

```
src/
├── apresentacao/                → Camada de interface (console)
│   ├── ClienteApresentacao.java
│   ├── ProdutoApresentacao.java
│   ├── PedidoApresentacao.java
│   └── ConsoleUI.java           → Menu principal e navegação
│
├── modelo/                      → Entidades do sistema
│   ├── Cliente.java
│   ├── Produto.java
│   ├── Pedido.java
│   └── ItemPedido.java
│
├── servico/                     → Regras de negócio e padrões de projeto
│   ├── ClienteServico.java
│   ├── ProdutoServico.java
│
│   ├── FreteCalculadoraStrategy.java     → Interface Strategy
│   ├── FreteCalculadoraPeso.java         → Frete por peso
│   ├── FreteCalculadoraDistancia.java    → Frete por distância
│   └── FreteFactory.java                 → Fábrica de frete
│
│   ├── NotificadorStrategy.java          → Interface Strategy
│   ├── NotificadorEmail.java             → Notificação por e-mail
│   ├── NotificadorSMS.java               → Notificação por SMS
│   ├── NotificadorWhatsApp.java          → Notificação por WhatsApp
│   └── NotificadorFactory.java           → Fábrica de notificadores
│
├── relatorio/                   → Classes de montagem de relatório
│   ├── RelatorioBase.java             
│   ├── RelatorioJSON.java                
│   ├── RelatorioTexto.java              
|
└── repositorio/                 → Persistência
    ├── ClienteRepositorio.java  
    ├── PedidoRepositorio.java     
    ├── ProdutoRepositorio.java   
    └── Repositorio.java  
```

---

## ✅ Funcionalidades

### 👤 Cliente
- Cadastro com: nome, CPF, e-mail, telefone  
- Validações básicas aplicadas  
- Apresentado via `ClienteApresentacao`

### 📦 Produto
- Cadastro com: nome, preço e peso  
- Acessado e controlado por `ProdutoServico`  
- Exibido na camada `ProdutoApresentacao`

### 🛒 Pedido
- Contém múltiplos itens (`ItemPedido`)  
- Associado a um cliente  
- Calcula o valor total e o frete  
- Apresentado e manipulado via `PedidoApresentacao`  

---

## 🚚 Cálculo de Frete – Strategy + Factory

### Interface: `FreteCalculadoraStrategy`
```java
double calcularFrete(Pedido pedido);
```

### Implementações:
- `FreteCalculadoraPeso`: R$5,00 por quilo  
- `FreteCalculadoraDistancia`: R$0,50 por quilômetro  

### Fábrica: `FreteFactory`
Seleciona a estratégia com base na escolha do usuário.

---

## 📲 Notificações – Strategy + Factory

### Interface: `NotificadorStrategy`
```java
void notificar(Cliente cliente);
```

### Implementações:
- `NotificadorEmail`  
- `NotificadorSMS`  
- `NotificadorWhatsApp`  

### Fábrica: `NotificadorFactory`
Instancia o notificador apropriado conforme a seleção do usuário no terminal.

---

## 🧠 Padrões de Projeto Aplicados

| Padrão        | Aplicação                                    |
|---------------|----------------------------------------------|
| **Builder**  | Pedido (`Pedido`) |
| **Strategy**  | Frete (`FreteCalculadoraStrategy`), Notificações (`NotificadorStrategy`) |
| **Factory**   | `FreteFactory`, `NotificadorFactory`         |
| **Singleton** | `ConsoleUI` (ponto central da interface)     |
| **Template Method**  | Relatório (`RelatorioBase`) |
| **Arquitetura de Camadas (simples)** | Separação entre `modelo`, `servico` e `apresentacao` |



---

## ▶️ Execução

### Compilação
```bash
javac src/**/*.java
```

### Execução
```bash
java apresentacao.ConsoleUI
```

### Fluxo principal:
1. Menu interativo pelo terminal  
2. Cadastro de clientes e produtos  
3. Criação de pedidos: escolha cliente, produtos, quantidades  
4. Seleção do tipo de frete  
5. Escolha do tipo de notificação  
6. Confirmação e simulação de envio de notificação  

---

## 🔚 Conclusão

Este projeto busca a aplicação prática de **padrões de projeto fundamentais** em um sistema de pedidos simples, organizado de forma clara e separando responsabilidades. Ele serve como forma de exposição a e aprendizado de:

- Estratégias de extensão e manutenção de código  
- Reutilização de lógica com fábricas e interfaces  
- Estruturação de código orientado a objetos

##👥 Autores

- [Lucas](https://github.com/LucasLins13/)
- [Luiz](https://github.com/luizcodedthat/)
