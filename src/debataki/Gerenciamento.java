package debataki;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Gerenciamento {
    private  Perguntas perguntaAcessada;
     
 
    private ObjectOutputStream objetoEscrita;
    private ObjectInputStream objetoLeitura;
    private static String usuarioLogado="";
    public void abrirArquivoEscrita(String nomeArquivo){
            try{
                FileOutputStream arqleitura = new FileOutputStream(nomeArquivo);
                objetoEscrita = new ObjectOutputStream(arqleitura);
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao abrir arquivos!");
                System.err.println(e);
            }
        }
        public void abrirArquivoLeitura(String nomeArquivo){
            try{
                FileInputStream arqLeitura = new FileInputStream(nomeArquivo);
                objetoLeitura = new ObjectInputStream(arqLeitura);
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao abrir arquivos!");
            }
        }
        public void fecharArquivoEscrita(){
           try{
            if(objetoLeitura !=null) objetoLeitura.close();
           }catch (IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar arquivos!");
           }
        }
        public void fecharArquivoLeitura(){
           try{
            if(objetoEscrita !=null) objetoEscrita.close();
           }catch (IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar arquivos!");
           }
        }
        public boolean escreverArquivo(ArrayList objetos){
            try{
                for(int i=0;i<objetos.size();i++){
                    objetoEscrita.flush();
                    objetoEscrita.writeObject(objetos.get(i));
                }
                return true;
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao manipular arquivos!");
                return false;
            }
        }
        
        public ArrayList lerArquivo() throws IOException{
            ArrayList objetosLidos = new ArrayList();
            try{
                while(true){
                    objetosLidos.add(objetoLeitura.readObject());
                }
            }catch( EOFException f){
                return objetosLidos;
            }catch(IOException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(null,"Erro ao manipular arquivos!"+e);
            } return objetosLidos;
        }
        
    public static String getUsuarioLogado(){
        return usuarioLogado;
    }       
    public static void setUsuarioLogado(String nomeUsuario){
        usuarioLogado = nomeUsuario;
    }
       public Perguntas getPerguntaAcessada() {
        return perguntaAcessada;
    }

    public void setPerguntaAcessada(Perguntas perguntaAcessada) {
        this.perguntaAcessada = perguntaAcessada;
    }
}
