package Func_musica;
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

    private static String GetFile(String nomeArquivo, String diretorio){
       
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

    public void setFileName(){
        try (Scanner ler_nome = new Scanner(System.in)) {
            System.out.println("Digite o nome do arquivo\n");
            nomeArquivo = ler_nome.nextLine();
        }
    }
    public void setDados(String diretorio, String nomeArquivo) throws FileNotFoundException{
        String path = GetFile(nomeArquivo, diretorio);
        dados = ReadFile(path);
    }
    public void setDirectory(){
        diretorio = System.getProperty("user.dir").concat("\\");
    }
    public String getFileName(){
        return nomeArquivo;
    }
    public String getFileRawName(){
    	nomeArquivo = nomeArquivo.substring(0,nomeArquivo.indexOf("."));
        return nomeArquivo;
    }
    public String getDados(){
        return dados;
    }
    public String getDirectory(){
        return diretorio;
    }
}  