# Graph Debugger
## Como usar o projeto
O programa pode ser executada de dois modos, tanto pela execução pela IDEAJ quanto pelo arquivo .jar do mesmo.
* Executando a partir do .jar:
	* 1º: a partir do terminal, alcance a pasta 
	proj2pa_graphs_jar;
	```
	$cd classes/artifacts/proj2pa_graphs_jar/
	```
	* 2º: A seguir deve-se executar o seguinte comando:
	```
	$java -jar proj2pa-graphs.jar
	```
	* 3º: Nesse momento será aberta a janela inicial do programa onde será possível gerar o grafo e executar os algorítmos desejados.
	O Graph Debbuger estará pronto para ser usado!

* Executando a partir do IDEAJ
	* 1º: Importe o projeto na plataforma;
	* 2º: Verfique se as versões de compilador e JDK estão corretas;
	* 3º: Casos esteja aparecendo algum erro, verifique se o diretório **lib** está incluso nas bibliotecas;
	* 4º: Builde e execute o projeto. Nesse momento será aberta a janela inicial do programa onde será possível gerar o grafo e executar os algorítmos desejados.
	O Graph Debbuger estará pronto para ser usado!
    
    ![](https://i.imgur.com/M0orryK.png)



## Funcionalidades do Projeto
O Graph Debugger foi feito para mostrar ao usuário todos provessos de travessia em grafos, facilitando desse modo o entendimento dessas ações e melhorando o aprendizado do usuário para o conteúdo. Ele possui as seguintes funções:

* Grafo:
	* Criar grafo: Permite ao usuário gerar um grafo a partir da inserção do número de vértices e das conexões entre eles. Para gerar a aresta é necessário o vértice de onde ele sai, o vértice destino e o peso dessa ligação.
	* Gerar grafo: Cria um grafo aleatório para o usuário, com limite de 100 vértices.
    > Após o grafo ser gerado será aberta uma janela com uma imagem interativa do grafo.
    
    ![](https://i.imgur.com/9GCH2iq.png)
    

* Travessias:
    ![](https://i.imgur.com/ozN8BZO.png)
	* Busca por Largura (BFS): Realiza o BFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Busca em Profundidade (DFS): Realiza o DFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Dijkstra (SSSP): Realiza o algorítmo Dijkstra no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário o menor caminho possível entre esses dois pontos, explicitando o caminho tomado pela função e o peso total dele.

    ![](https://i.imgur.com/14AiwlC.png)

    > Em todos casos de travessia, a ações tomadas pela função são mostradas no terminal.
    ![](https://i.imgur.com/8SL4LqB.png)

## Dados de versão
* Ubunto 18.04.2
* Java JDK 11.0.2
	* Openjdk version "11.0.2" 2019-01-15
	* OpenJDK Runtime Environment (build 11.0.2+9-Ubuntu-3ubuntu118.04.3)
	* OpenJDK 64-Bit Server VM (build 11.0.2+9-Ubuntu-3ubuntu118.04.3, mixed mode, sharing)
	> Para adquirir a versão mais atual do Java use os comandos:
	> ```
	> $sudo apt-get install default-jdk
	> $sudo apt-get-install default-jre
	> ```
* Compilador: Javac
* IntelliJ IDEA 2019.1.1 (Ultimate Edition)