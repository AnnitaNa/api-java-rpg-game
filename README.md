# Getting Started

## Banco de dados
rode o docker com o comando abaixo para criar o banco postgress
```bash
docker compose up --build
```

## Aplicação
compile e faça todos os downloads necessários com o maven e inicie a aplicação.
Ela irá rodar na porta 9080

## Jogar
> Configurações do endpoint foram anexadas no arquivo **desafio.postman_collection.json**
>
>  importe a collection no postman e realize as request abaixo:


1. crie seus personagens
- Aqui você vai adicionar os persoganes pré confugurados a nossa base de dados
2. Jogar
- Para jogar, você deve escolher o nome de dois personagens e colocar no payload no seguinte formato:
```json
{
    "name1": "Knight",
    "name2": "Giant"
}
```

## Regras:

1. Personagens disponíveis:

| name      | life | attack | defense | agility | characterType | diceNr | diceFaces |
|-----------| ---- | ------ | ------- | ------- | ------------- | ------ | --------- |
| Warrior   | 20   | 7      | 5       | 6       | HERO          | 1      | 12        |
| Barbarian | 21   | 7      | 2       | 5       | HERO          | 2      | 8         |
| Knight    | 26   | 6      | 8       | 3       | HERO          | 2      | 6         |
| Orc       | 42   | 7      | 1       | 2       | MONSTER       | 3      | 4         |
| Giant     | 34   | 10     | 4       | 4       | MONSTER       | 2      | 6         |
| Werewolf  | 34   | 7      | 4       | 7       | MONSTER       | 2      | 4         |


2. O resto das regras podem ser analisadas no documento em anexo: desafio_java.pdf