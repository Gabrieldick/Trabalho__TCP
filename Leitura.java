import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leitura
{   
    private static String dados;
    private static String diretorio;
    private static String nomeArquivo;

    public Leitura(){
        nomeArquivo = "";
        diretorio = "";
        dados = ""; 
    }

    private static String GetFile(String nomeArquivo){
        String diretorio = System.getProperty("user.dir").concat("\\");
        
        diretorio = diretorio.concat(nomeArquivo);

        return diretorio;
        
    }
    private static String ReadFile(String diretorio) throws FileNotFoundException
    {
        File file = new File(diretorio);
        try (Scanner scan = new Scanner(file)) {
            String palavras = "";

            while(scan.hasNextLine()){
                palavras = palavras.concat(scan.nextLine());
            }

            return palavras;
        }
    }

    public static void setFileName(){
        try (Scanner ler_nome = new Scanner(System.in)) {
            System.out.println("Digite o nome do arquivo\n");
            nomeArquivo = ler_nome.nextLine();
        }
    }
    public static void setDados(String diretorio) throws FileNotFoundException{
        dados = ReadFile(diretorio);
    }
    public static void setDirectory(){
        diretorio = GetFile(nomeArquivo);
    }
    public static String getFileName(){
        return nomeArquivo;
    }
    public static String getDados(){
        return dados;
    }
    public static String getDirectory(){
        return diretorio;
    }
}  
