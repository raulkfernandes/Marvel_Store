# MarvelStore

Documento com explicações sobre o desenvolvimento do projeto:

A ideia geral para o fluxo do projeto foi criar três telas que serviriam para o fluxo da aplicação
  
    -- A primeira tela principal com a lista de Comics que seria uma representação da lista de itens disponíveis para compra na loja.
    
    -- Uma tela de detalhamento com informações da Comic escolhida e opção para compra
    
    -- Uma tela de carrinho de compras para o usuário finalizar a compra, colocar cupom para desconto e remover itens


Na primeira tela foi criado uma ListView a ser preenchida com os Comics e um Botão para acesso ao carrinho de compras

    -- O acesso ao detalhamento da Comic é feito via clique nos itens da lista principal
    
    -- A lista é preechida com as Comics da requisição WebService ou com uma versão local para testes, caso a requisição falhe
    
    -- O acesso ao carrinho e feio via botão indicado na tela
    
Na tela de detalhamento, um objeto Comic é passado via interação da primeira tela e a tela é preenchida a partir dessa referência

    -- Os campos de texto são preenchidos pela referência do objeto Comic recebia via Intent
    
    -- A quantidade de itens adicionados ao carrinho é modificada a partir de botões de incremento e decremento
    
    -- O botão Add to Cart permite adicionar os itens escolhidos e voltar para a loja
    
    -- O botão Continue Shopping permite retornar à loja principal sem efetuar adições no carrinho
    
Na tela de carrinho de compras foi criada uma ListView com os itens adicionados ao carrinho, o usuário pode remover ou finalizar a compra

    -- Os itens podem ser removidos do carrinho via clique no botão referente ao próprio item
    
    -- O espaço para Cupom de Desconto pede um texto para checagem
        -- O cupom comum definido para testes foi o string: "IRONMAN"
        -- O cupom raro definido para testes foi o string: "BLACKWIDOW"
        
    -- A área de edição de texto pede um texto com Caps ativado automaticamente
    
    -- O botão Apply ao lado checa o cupom e dá um feedback ao usuário, se o cupom for aceito a área de edição fica desativada até a finalização da compra com preço total sendo calculado de forma proporcional
    
    -- O campo de texto para o preo total da compra pode ser modificado com a remoção de itens do carrinho ou aplicação de cupom de descontos válidos
    
    -- O botão de Checkout finaliza a compra e limpa a lista do carrinho, além de resetar a área para desconto para uma nvoa compra
    
    -- O botão Continue Shopping permite a volta à loja para adquirir mais Comics
    
 
 OBS1: Decidi fazer o carrinho de compras ser representado por uma instância estática seguindo o padrão Singleton, para poder acessar de todas as telas e manter as informações no carrinho apenas durante o fluxo ativo da aplicação.
 
 OBS2: Pensei na opção de utilizar armazenamento persistente via banco de dados para manter os itens do carrinho ou mesmo para manter uma versão de itens após a primeira requisição, mas acabei fazendo sem para tentar rodar as requisições corretamente no tempo que tinha.
 
 OBS3: Utilizei a Retrofit API para auxiliar nas requisições e tentei filtrar as informações necessárias para rodar uma versão aceitável da aplicação.
 
 OBS4: Tive problemas para conseguir acessar a imagem que representa a capa dos quadrinhos na requisição, portanto as imagens usadas estão disponíveis localmente com Comics obtidas via requisição ou Comics iniciadas localmente.
