package Func_musica;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;

public class TocaSom {

    private String texto;
    private IdentificaCaractere id = new IdentificaCaractere();
    private Player player = new Player();

    public TocaSom(){
        texto = "";
    }

    public void PlayMusic(){
        player.play(id.geraStringMusica(texto));
    }

    public void SetText(String texto){
        this.texto = texto;
    }

    public void ExportaMIDI(String nome) throws IOException{
    	
        Pattern music = new Pattern(id.geraStringMusica(texto));
        FileOutputStream arquivoMIDI = new FileOutputStream(nome+"_output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
        arquivoMIDI.close();
    }
    
}
