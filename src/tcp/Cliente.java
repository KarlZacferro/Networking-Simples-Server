import java.io.BufferedReader;jkç.
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente{
    public static void main(String args[] throws Exception) {
        
        String palavra;
        String palavraModificada;
        //cria 'stream' do teclado (objeto cadeiaUsuario do tipo BufferedReader vincula ao teclado pelo 'System.in')
        BufferedReader cadeiaUsuario = new BufferedReader(new  InputStreamReader(System.in));
        //cria os 'stream' do teclado(encadeados) de entrada e saida com servidor
        
        try(//cria o socket de acesso ao server 'hostname' na porta '1429'
            Socket clienteSocket = new Socket("localhost",1429)){
            //cria os 'streams' de  entrada e saida com o 'servidor'    
            DataOutputStream clienteParaServidor = new DataOutputStream(clienteSocket.getOutputStream());
            BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(clienteSocket.InputStreamReader()));
            
            System.out.println("Digite uma frase em minusculo: ");
            //le uma linha do teclado e coloca a 'palavra'    
            palavra = cadeiaUsuario.readLine();
            //envia linha para o 'server'
            clienteParaServidor.whiteBytes(palavra + '\n');
            //Le uma linha do 'server'    
            palavraModificada = cadeiaServidor.readLine();
            //apresenta a linha do servidor no video   
            System.out.println("Recebi do servidor: " + palavraModificada);
            //fecha o cliente        
            clienteSocket.close();
            }
        
    }
}