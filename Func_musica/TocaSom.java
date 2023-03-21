package Func_musica;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;

public class TocaSom {

    private String texto;
    private identificaCaractere id = new identificaCaractere();
    private Player player = new Player();

    public TocaSom(){
        texto = "";
    }

    public void PlayMusic(){
        id.setTexto(texto);
        player.play(id.geraStringMusica());
    }

    public void SetText(String texto){
        this.texto = texto;
    }

    public void ExportaMIDI(String nome) throws IOException{
    	nome = getFileRawName(nome);
        id.setTexto(texto);
        Pattern music = new Pattern(id.geraStringMusica());
        FileOutputStream arquivoMIDI = new FileOutputStream(nome+"_output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
        arquivoMIDI.close();
    }
    private String getFileRawName(String nomeArquivo){
    	nomeArquivo = nomeArquivo.substring(0,nomeArquivo.indexOf("."));
        return nomeArquivo;
    }
}
