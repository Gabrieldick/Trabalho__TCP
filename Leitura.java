import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jfugue.player.Player;



public class Leitura
{

    public static void main(String[] args) throws FileNotFoundException{
        
        String diretorio = Get_Directory();
        List<String> linhas = ReadFile(diretorio);
        Print_List(linhas);
    }

    private static void Print_List(List<String> palavras){
        for(int i = 0; i < palavras.size();i++){
            System.out.println(palavras.get(i));
        }
    }

    private static String Get_Directory(){
        String diretorio = System.getProperty("user.dir").concat("\\");
        Scanner ler_nome = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo\n");
        String nome_arquivo = ler_nome.nextLine();

        diretorio = diretorio.concat(nome_arquivo);

        return diretorio;
        
    }
    private static List<String> ReadFile(String diretorio) throws FileNotFoundException
    {
        File file = new File(diretorio);
        Scanner scan = new Scanner(file);
        List<String> palavras = new ArrayList<String>();

        while(scan.hasNextLine()){
            palavras.add(scan.nextLine());
        }

        return palavras;
    }
}  

class Controla_Som{
    private float volume;
    private float BPM;
    private int ID_Instrumento;
    private boolean mutado;


    public Controla_Som(){
        volume = 50;
        BPM = 20;
        ID_Instrumento = 0;
        mutado = false;
    }


}