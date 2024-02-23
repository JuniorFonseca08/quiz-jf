
# Q U I Z - JF

O Quiz JF é uma aplicação web que permite aos usuários participar de salas de quiz temáticas, responder a perguntas e competir por pontuações.

O Quiz foi um projeto para conclusão da MJV School JAVA.

Agradeço a MJV pela oportunidade e ao Samuca do [Curso de Tecnologia](https://www.youtube.com/@cursodetecnologia) por ter compartilhado seu conhecimento.




## Instalação

Instale as dependências do projeto usando um gerenciador de pacotes, como o Maven:

```bash
  mvn clean install
```
    
Configure o banco de dados de acordo com as instruções fornecidas no arquivo 

```
application.properties
```


## Instruções para Jogar o Quiz

Bem-vindo ao Quiz! Siga as instruções abaixo para começar a jogar usando o Swagger.

![App Screenshot](https://cdn.discordapp.com/attachments/1141805278896070686/1210676575654248518/image.png?ex=65eb6d6c&is=65d8f86c&hm=b2625611002f7a203e420a3c20f1576bd66d9100eb9ffc23d312f57820a2bb6d&)
![App Screenshot](https://cdn.discordapp.com/attachments/1141805278896070686/1210676654305841252/image.png?ex=65eb6d7f&is=65d8f87f&hm=871c937a8ca3bfe78e4a1c8ac0b7428726997afd3b01e7bb1f75aea974409a0e&)

### Passo 1: Carga de Dados

Faça a carga de dados para as questões e alternativas utilizando o endpoint `POST /question/save`. 

Exemplo de carga de dados:
```json
{
    "query": "Qual é o nome do protagonista da série de jogos 'God of War'?",
    "theme": "Jogos",
    "alternatives": [
        {
            "alternative": "Kratos",
            "correct": true
        },
        {
            "alternative": "Zeus",
            "correct": false
        },
        {
            "alternative": "Ares",
            "correct": false
        },
        {
            "alternative": "Hades",
            "correct": false
        }
    ]
}
```

### Passo 2: Criar um Usuário
Crie um usuário utilizando o endpoint `POST /player/save.`

Exemplo de criação de usuário:

```json
{
  "nickName": "string",
  "fullName": "string",
  "age": 0,
  "email": "string",
  "password": "string",
  "playerScore": 0
}
```

### Passo 3: Criar uma Sala

Crie uma sala utilizando o endpoint `POST /new-room`.

Utilize: tema das questões e o nickName do player.

### Passo 4: Criar um Gameplay

Crie um gameplay utilizando o endpoint `POST /create-gameplay`

Utilize: ID da sala (room).


### Passo 5: Responder às Perguntas
Para responder às perguntas, utilize os seguintes endpoints:

Obtenha a próxima pergunta e respostas utilizando:

 `GET /gameplay/{id}/next-question`

Responda à pergunta utilizando o ID do gameplay e o ID da alternativa correta em:

`POST /{gameplayId}/player-response`



**Divirta-se jogando o Quiz! 🎉🎮**



## Screenshots

### Diagrama de Entidades

![ER Diagrama](https://cdn.discordapp.com/attachments/1141805278896070686/1210677936122892369/image.png?ex=65eb6eb1&is=65d8f9b1&hm=14e0866daac2e91d518f279779c031742c2a3dcd7d1bd6c090aede959f4914aa&)

### GameplayQuestions 
Tabela que controla a partida, verifica acertos, gera pontuação.


![GameplayQuestions](https://cdn.discordapp.com/attachments/1141805278896070686/1210681535263416350/image.png?ex=65eb720b&is=65d8fd0b&hm=ca7991dd3d9390c976abfa02b41a712198a795aadbcf0b82777d3531ef396f65&)
## Roadmap

1. **Melhorar a Segurança das Senhas no Banco de Dados:**
 - Implementar a criptografia das senhas dos usuários antes de armazená-las no banco de dados. Utilizar algoritmos de hashing seguros como bcrypt para garantir a segurança das informações.

2. **Implementar Verificação de Gameplay Ativa:**
- Criar um método para verificar se uma gameplay está ativa, verificando se todas as perguntas foram respondidas.

3. **Restrição de Criação de Salas com o Mesmo Tema:**
- Implementar uma validação para não permitir que um jogador crie outra sala com o mesmo tema se já houver uma sala ativa com o mesmo tema.

4. **Método para Exibir o Ranking:**
- Desenvolver um método para exibir o ranking dos jogadores com base em suas pontuações, possibilitando aos usuários visualizar sua posição em relação aos demais jogadores.

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/junior-fonseca08/)


