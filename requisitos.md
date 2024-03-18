### Requisitos de Livro:

1. **Títulos Únicos:**
   - Não é permitido cadastrar livros com títulos duplicados.

2. **Exemplares Não Negativos:**
   - Não é permitido ter um número negativo de exemplares para um livro.

3. **Restrição de Aluguel:**
   - O número de aluguéis de um livro não pode exceder o número de exemplares disponíveis.

### Requisitos de Aluguel:

1. **Tempo Máximo de Aluguel:**
   - O tempo máximo de aluguel de um livro é de 10 dias.

2. **Renovação de Aluguel:**
   - Um usuário pode renovar seu aluguel até 3 vezes, com cada renovação aumentando o prazo de devolução em 5 dias.

3. **Multa por Atraso:**
   - Em caso de atraso na devolução de um livro, o usuário é sujeito a pagar uma multa.

### Requisitos de Usuário Admin:

1. **Privilégios de Admin:**
   - Apenas usuários com a role de admin podem:
     - Cadastrar novos livros.
     - Apagar livros do sistema.
     - Realizar a devolução de livros.
     - Realizar a renovação de aluguéis de livros.

### Requisitos de Usuário Estudante:

1. **Limite de Livros:**
   - Um estudante pode pegar no máximo 5 livros.

2. **Multa por Atraso:**
   - Em caso de atraso na devolução de um livro, será cobrada uma multa de 0,15 centavos por dia de atraso.


### Requisitos de Usuário Professor:

1. **Limite de Livros:**
   - Um professor pode pegar no máximo 10 livros.

