# Automação de teste

Automação de testes é o uso de software para controlar a execução de testes de software através da aplicação de estratégias e ferramentas, comparando os resultados esperados com os resultados reais. Seus objetivos são a redução do envolvimento humano em atividades manuais, de tempo demandado.
A importância da automação de testes está diretamente relacionada à qualidade do produto final. Assim, ao pensar em automatizar, é preciso estudar a sua viabilidade: com a automação conseguiremos obter ganho de tempo? Conseguimos reduzir os custos e manter a qualidade?
Se a resposta for sim, outros fatores precisam ser analisados: a maturidade do time de processo do teste; grau de reutilização dos testes automatizados; conhecimento sobre o comportamento que é esperado do sistema a ser testado; e, ainda, o tempo disponível para a automação.


# Validações na API

###### Validar o status de retorno;
###### Validar o header que está sendo retornado;
###### Validar o body do response, que nada mais é que uma nova estrutura de dados;
###### Validar o comportamento da API quando o serviço está fora;
###### Validar se enviado um JSON/XML com a estrutura incorreta, qual será o comportamento da API;
###### Validar se enviado dados inválidos qual será o comportamento;
###### Validar se a API não retorna nada;
###### Validar o retorno é o esperado com base nas condições definidas para cada tipo de dado enviado;

**Nem sempre a API tem como retorno uma nova estrutura de dados, nesse caso é imprescindível validar no sistema o resultado esperado.**