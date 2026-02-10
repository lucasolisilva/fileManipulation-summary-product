# File Processing System (CSV) 📂

Projeto em **Java** desenvolvido para praticar a manipulação de arquivos e diretórios, leitura de dados formatados e geração de relatórios automatizados.

O sistema lê um arquivo de entrada contendo uma lista de produtos (nome, preço e quantidade), processa os dados calculando o subtotal de cada item e gera um novo arquivo CSV de saída em uma subpasta específica, demonstrando o controle completo do fluxo de entrada e saída (I/O).

## 🛠️ Tecnologias e Conceitos

- **Java NIO (Path/Files)**: Uso das APIs modernas para manipulação de caminhos e arquivos.
- **Leitura de Arquivos**: Processamento de linhas de texto e conversão para objetos Java.
- **Escrita de Arquivos**: Geração de arquivos CSV com opções de criação e anexação de dados.
- **Manipulação de Strings**: Uso de regex (`split`) para tratar campos separados por vírgula.
- **Tratamento de Erros**: Gestão de exceções de entrada/saída (`IOException`) e formatos inválidos.
- **Cálculo de Subtotais**: Lógica de negócio integrada ao modelo para processamento de valores.



## 🧠 Como Funciona

O usuário fornece o caminho de um arquivo de origem que contém dados de produtos. O programa lê cada linha, ignora formatos inválidos e converte os dados em objetos do tipo `Product`. Após a leitura, o sistema solicita um diretório de destino onde cria automaticamente uma subpasta chamada `out` e um arquivo `summary.csv`. Dentro deste arquivo, o programa grava o nome de cada produto junto com o valor total calculado (preço * quantidade), consolidando um resumo pronto para ser aberto em planilhas.