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

    public void PlayMusic(){
        id.setTexto(texto);
        Pattern music = new Pattern(id.geraStringMusica());
        player.play(music);
    }

    public void SetText(String texto){
        this.texto = texto;
    }

    public static void ExportaMIDI(Pattern music){
        File arquivoMIDI = new File("output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
