import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InpuntStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

 public class Servidor{
     public static void main(String[] args) throws Exception{
    
        String clientePalavra;
        String sentencaCapturada;
        //cria 'socket' de comunicação com os clientes na porta 1430
        ServerSocket bemVindoSocket = new ServerSocket(1429);
        System.out.println("Servidor ouvindo a porta 1429");

        //Espera a mensagem de algum 'cliente' 
        while(true){
      //espera a conexão ed alfum 'Cliente'
        Socket conexaoSocket = bemVindoSocket.accept();
         //cria 'Streams' de entrada e saida com o 'cliente'
        BufferedReader cadeiaCliente = new BufferedReader(new InputStreamReader(conexaoSocket.getInputStream()));
        DataOutputStream servidorParaCliente = new DataOutputStream(conexaoSocket.getOutputStream());
        System.out.println("Cliente concectado: " + conexaoSocket.getInetAddress().getHostAddress());
         //Le uma linha do 'cliente'
        clientePalavra = cadeiaCliente.readLine();
        //Transforma a linha em minuscula
        sentencaCapturada = clientePalavra.toUpperCase + '\n';
        //envia linha maiuscula para o 'cliente'
        servidorParaCliente.whiteBytes(sentencaCapturada);
        System.out.println("informação processada e desenvolvida ao clinete: " + conexaoSocket.getInetAddress().getHostAddress());
       }
    }
 }

