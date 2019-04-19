# proj2pa-graphs
Second Algorithms Project's course project. Graphs

# Graph Debugger
## Como usar o projeto


## Funcionalidades do Projeto
O Graph Debugger foi feito para mostrar ao usuário todos provessos de travessia em grafos, facilitando desse modo o entendimento dessas ações e melhorando o aprendizado do usuário para o conteúdo. Ele possui as seguintes funções:

* Grafo:
	* Criar grafo: Permite ao usuário gerar um grafo a partir da inserção do número de vértices e das conexões entre eles. Para gerar a aresta é necessário o vértice de onde ele sai, o vértice destino e o peso dessa ligação.
	* Gerar grafo: Cria um grafo aleatório para o usuário, com limite de 100 vértices.
	<smal> Após o grafo ser gerado será aberta uma janela com uma imagem interativa do grafo.</smal>
* Travessias:
	* Busca por Largura (BFS): Realiza o BFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Busca em Profundidade (DFS): Realiza o DFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Dijkstra (SSSP): Realiza o algorítmo Dijkstra no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário o menor caminho possível entre esses dois pontos, explicitando o caminho tomado pela função e o peso 
	total dele.
	<smal> Em todos casos de travessia, a ações tomadas pela função são mostradas no terminal.</smal>


## Bugs e Problemas
* O grafo fica com problemas se o usuário não inserir peso na aresta durante a criação.

## Dados de versão
* Java JDK 12.0.1
* IntelliJ IDEA 2019.1.1 (Ultimate Edition)