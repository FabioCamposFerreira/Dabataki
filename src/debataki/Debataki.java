package debataki;
import debataki.InterfaceGrafica.Login;
import java.io.IOException;
import java.util.ArrayList;
public class Debataki {
    
    public static Gerenciamento r = new Gerenciamento();
    public static void main(String[] args) throws IOException {
      
        new Login().setVisible(true);
  //criarArquivos();
      
      //testeu();
    }
   public static void testeu() throws IOException{
    //  Gerenciamento r = new Gerenciamento();
        System.err.println("OK");
    r.abrirArquivoLeitura("Usuarios.dki");
    System.err.println("OK");
    ArrayList <Usuarios> teste = new ArrayList();
    teste =  r.lerArquivo();
    System.err.println("OK");
    for(int i=0; i<teste.size();i++){ System.err.println(teste.get(i).getNome());
    System.err.println(teste.get(i).getSenha());
    }
        System.err.println("OK");
    r.fecharArquivoLeitura();
    System.err.println("OK");
    
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void criarArquivos(){
       
    // Processo de criação primaria dos arquivos binario
        Usuarios usuario = new Usuarios("alsdhfaklsdjfh", "asdflkçjh", 0, 0, "asdklja" );
        Respostas resposta = new Respostas("", 0, "");
        Perguntas pergunta = new Perguntas("", 0, "");
        
        ArrayList<Usuarios> u = new ArrayList();
        ArrayList<Respostas> r1 = new ArrayList();
        ArrayList<Perguntas> p = new ArrayList();
        
        u.add(usuario);
        r1.add(resposta);
        p.add(pergunta);
        Gerenciamento arquivo = new Gerenciamento();
        arquivo = r; 
        arquivo.abrirArquivoEscrita("Usuarios.dki");
        arquivo.escreverArquivo(u);
        arquivo.fecharArquivoEscrita();
        arquivo.abrirArquivoEscrita("Perguntas.dki");
        arquivo.escreverArquivo(p);
        arquivo.fecharArquivoEscrita();
        arquivo.abrirArquivoEscrita("Respostas.dki");
        arquivo.escreverArquivo(r1);
        arquivo.fecharArquivoEscrita();
    }
    }
    

