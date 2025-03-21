﻿# Decola Tech 2025
Criação de API RESTful para o bootcamp da Decola Tech 2025


## Diagrama de Classes
```mermaid
classDiagram
    class Usuario {
        +String name
        +Conta account
        +Feature[] features
        +Transacao ultimaTransacao
    }

    class Conta {
        +double saldo
        +double totalGasto
    }

    class Feature {
        +String icon
        +String descricao
    }

    class UltimaTransacao {
        +String data
        +String descricao
        +String formaPagamento
        +double total
    }

    Usuario "1" *-- "1" Conta
    Usuario "1" *-- "N" Feature : contém
    Usuario "1" *-- "1" UltimaTransacao : tem uma
```
