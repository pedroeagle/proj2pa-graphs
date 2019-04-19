# Graph Debugger
## Como utilizar o programa
O programa pode ser executado de dois modos, tanto pela execução pela [IDEA](https://www.jetbrains.com/idea/) quanto pelo arquivo executável.
* Executando a partir do .jar:
	Pré-requisitos:
	- Ter o Java JRE instalado, no mínimo, na versão 8. Para instalar no Ubuntu:
	```
	sudo apt-get install default-jre
	```
	Passo a passo:
	* 1º: Faça [aqui](https://github.com/pedroeagle/proj2pa-graphs/raw/master/JAR/proj2pa-graphs.jar) o download do proj2pa-graphs.jar
	* 2º: Executando:
		- No Linux e MacOS:
		Encontre o diretório onde foi baixado o executável e dê o seguinte comando:
		```
		java -jar proj2pa-graphs.jar
		```
		- No Windows:
		Clique duas vezes sobre o executável. Será aberto o programa.
	O Graph Debbuger estará pronto para ser usado!

* Executando a partir do Intelij Idea:
	* 1º: Importe o projeto na plataforma;
	* 2º: Verfique se as versões de compilador e JDK estão corretas;
	* 3º: Casos esteja aparecendo algum erro, verifique se o diretório **lib** está incluso nas bibliotecas;
	* 4º: Builde e execute o projeto. Nesse momento será aberta a janela inicial do programa onde será possível gerar o grafo e executar os algorítmos desejados.
	O Graph Debbuger estará pronto para ser usado!
    
    ![](https://i.imgur.com/M0orryK.png)



## Funcionalidades do Projeto
O Graph Debugger foi feito para mostrar ao usuário alguns processos de travessia em grafos, facilitando desse modo o entendimento dessas ações e melhorando o aprendizado do usuário para o conteúdo. Ele possui as seguintes funções:

* Grafo:
	* Criar grafo: Permite ao usuário gerar um grafo a partir da inserção do número de vértices e das conexões entre eles. Para gerar a aresta é necessário o vértice de onde ele sai, o vértice destino e o peso dessa ligação.
	* Gerar grafo: Cria um grafo com número de vertíces, conexões e pesos aleatórios, com limite de 100 vértices.
    > Após criado ou gerado um grafo, será mostrada uma imagem interativa da representação gráfica de um grafo. É possível alterar o zoom da imagem por meio do scroll do mouse. Estarão também disponíveis alguns algorítmos de travessia.
    
    ![](https://i.imgur.com/9GCH2iq.png)

* Travessias: <br>
    	![](https://i.imgur.com/ozN8BZO.png)
	* Busca por Largura (BFS): Realiza o BFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Busca em Profundidade (DFS): Realiza o DFS no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário se a travessia foi possível ou não e, nos casos possíveis, mostra o caminho percorrido e qual o peso total dele.
	* Dijkstra (SSSP): Realiza o algorítmo Dijkstra no grafo gerado a partir de um vértice inicial e um vértice destino e retorna para o usuário o menor caminho possível entre esses dois pontos, explicitando o caminho tomado pela função e o peso total dele. 

    ![](https://i.imgur.com/14AiwlC.png)

    > Em todos casos de travessia, as ações tomadas pelo algorítmo são mostrados no terminal. O caminho encontrado pelo algorítmo é mostrado em uma tela de resultado.
    ![](https://i.imgur.com/8SL4LqB.png)

## Dados de versão
* Ubuntu 18.04.2
* Java JDK 11.0.2
	* Openjdk version "11.0.2" 2019-01-15
	* OpenJDK Runtime Environment (build 11.0.2+9-Ubuntu-3ubuntu118.04.3)
	* OpenJDK 64-Bit Server VM (build 11.0.2+9-Ubuntu-3ubuntu118.04.3, mixed mode, sharing)
* Compilador: Javac
* IntelliJ IDEA 2019.1.1 (Ultimate Edition)