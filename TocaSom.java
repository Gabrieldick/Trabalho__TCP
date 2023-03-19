import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;

public class TocaSom {
    
    public static void main(String[] args) throws FileNotFoundException{
        Leitura ler = new Leitura();
        Player player = new Player();
        
        ler.setFileName();
        ler.setDirectory();
        ler.setDados(ler.getDirectory(),ler.getFileName());
        System.out.println(ler.getDados());
        identificaCaractere ID = new identificaCaractere(ler.getDados());
        ID.setMusica(ID.geraStringMusica());
        System.out.println(ID.getMusica());
        Pattern music = new Pattern(ID.getMusica());
        ExportaMIDI(music);
        player.play(music);

        //identificaCaractere ID = new identificaCaractere("CDEF0aFF0aCDCD0aDD0aCGFE0aEE0aCDEF0aFF");
    	//identificaCaractere ID = new identificaCaractere("CD EFFF FFF");
    	//identificaCaractere ID = new identificaCaractere("CDEF0aFF0aCDCD0aDD!aCGFE0aEE0aCDEF0aFF");
    	//identificaCaractere ID = new identificaCaractere("CDEF0aFF0aCDCDpaDDOaCGFE0aEE0aCDEF0aFF");
    	//identificaCaractere ID = new identificaCaractere("CDEF0aFF0a?CDCD0aDD4aCGFE0aEE0aCDEF0aFF");
    	//identificaCaractere ID = new identificaCaractere("CDEF0aFF0aCDCD0aDD;aCGFE0aEE0aCDEF0aFF");
    	//identificaCaractere ID = new identificaCaractere("CDEF0aFF0aCDCD0aDD,aCGFE0aEE0aCDEF0aFF");

    }
    private static void ExportaMIDI(Pattern music){
        File arquivoMIDI = new File("output.mid");
        try {
            MidiFileManager.savePatternToMidi(music, arquivoMIDI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
