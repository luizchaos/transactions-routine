# Rotina de transações

Cada portador de cartão (cliente) possui uma conta com seus dados.
A cada operação realizada pelo cliente uma transação é criada e associada à sua
respectiva conta.
Cada transação possui um tipo (compra a vista, compra parcelada, saque ou pagamento),
um valor e uma data de criação.
Transações de tipo compra e saque são registradas com valor negativo, enquanto
transações de pagamento são registradas com valor positivo.

## Estrutura de dados

*Accounts*

|  accountId |documentNumber | 
|---|---|
| 1  |  12345678900 |

*OperationsTypes*

|  operationTypeId |description | 
|---|---|
| 1  |  COMPRA A VISTA |
| 2  |  COMPRA PARCELADA |
| 3  |  SAQUE |
| 4  |  PAGAMENTO |

*Transactions*

|  Transaction_ID |Account_ID | OperationType_ID | Amount | EventDate |
|---|---|---|---|---|
| 1  |  1 | 1 | -50.0 | 2020-01-01T10:32:07.7199222 |
| 2  |  1 | 1 | -23.5 | 2020-01-01T10:48:12.2135875 |
| 3  |  1 | 1 | -18.7 | 2020-01-02T19:01:23.1458543 |
| 4  |  1 | 4 | 60.0 | 2020-01-05T09:34:18.5893223 |

## Endpoints

### Criação de uma conta

POST /accounts 

Request Body:
```
{
    "document_number": "12345678900"
}
```
### Consulta de informações de uma conta 

GET /accounts/:accountId 

Response Body:
```
{
    "account_id": "1",
    "document_number": "12345678900"
}
```

### Criação de uma transação

POST /transactions 

Request Body:
```
{
    "account_id": "1",
    "operation_type_id": "4",
    "amount": "123.45"
}
```

## Como executar 

Para execução é necessario a instalação do docker e docker-compose

apos a instalação do docker e docker-compose

é rodar o seguinte comando:

`docker-compose up`

ou 

`docker-compose up -d` 

para detached.

apos isso ira iniciar o aplicativo na porta 8080 e um servidor mysql na porta 3306.