import java.io.File;
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

    public static void main(String[] args){
        TocaSom toca = new TocaSom();

        toca.SetText("CDEF0aFF0a?CDCD0aDD4aCGFE0aEE0aCDEF0aFF");
        toca.PlayMusic();
    }

    public void PlayMusic(){
        id.setTexto(texto);
        player.play(id.geraStringMusica());
    }

    public void SetText(String texto){
        this.texto = texto;
    }

    public void ExportaMIDI(String nome){
        Pattern music = new Pattern(id.geraStringMusica());
        File arquivoMIDI = new File(nome+"_output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
