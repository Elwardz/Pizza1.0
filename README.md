# Sistema de Pizzaria

![Uploading Sistema de Pizzaria em Java com balcão de pizzaria, computador, pizzas, recheios extras, recibos e logotipo de pizzaria.png…]()

Este é um sistema de gerenciamento de pedidos de pizzaria, onde os usuários podem fazer pedidos de diferentes tipos de pizzas, adicionar recheios personalizados e visualizar seus pedidos. O sistema também permite gerar recibos para cada pedido feito.

## Funcionalidades

- **Fazer Pedido**: Os usuários podem escolher o tipo de pizza e adicionar recheios adicionais.
- **Ver Pedidos**: Lista todos os pedidos feitos pelo usuário, incluindo pizzas e recheios.
- **Repetir Pedido**: Permite ao usuário repetir pedidos anteriores com as mesmas opções.
- **Ver Pizzas**: Exibe uma lista dos tipos de pizzas disponíveis e seus preços.
- **Ver Recheios**: Exibe uma lista dos recheios disponíveis e seus preços.
- **Gerar Recibo**: Gera um recibo em formato `.txt` para cada pedido feito, contendo detalhes do pedido.

## Estrutura do Projeto

O projeto é estruturado em pacotes para melhor organização do código. As principais classes incluem:

- `application`: Contém a classe principal (`SistemaPizza`) que gerencia a interação com o usuário.
- `model`: Contém classes que representam a pizzaria, pizzas e recheios.
- `factory`: Define os recheios disponíveis e outros elementos relacionados.
- `iterator`: Implementa o padrão Iterator para percorrer os recheios das pizzas.
- `prototype`: Utiliza o padrão Prototype para clonar pizzas personalizadas.

## Tecnologias Utilizadas

- Java
- Padrões de Projeto (Factory, Iterator, Prototype)

## Como Executar o Projeto

1. Clone este repositório para sua máquina local.
2. Abra o projeto em sua IDE preferida (como IntelliJ IDEA ou Eclipse).
3. Compile o projeto.
4. Execute a classe `SistemaPizza`.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Para isso, por favor, siga as etapas abaixo:

1. Faça um fork deste repositório.
2. Crie uma branch para sua nova funcionalidade (`git checkout -b nova-funcionalidade`).
3. Faça suas alterações e adicione suas mudanças (`git commit -m 'Adicionando nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin nova-funcionalidade`).
5. Abra um pull request.

## Licença

Este projeto está sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

