import org.jfugue.player.Player;

public class identificaCaractere {
    //CONSTANTES
    private static final int numIntstrumentos = 127;
    private static final int OitavaInicial = 5;
    private static final int maxOitavas = 9;
    private static final int maxVolume = 127;
    private static final int minVolume = 0;
    private static final int volumePadrao = 40;
    private static final int ID_Instrumento_Padrao = 0;
    //CONSTANTES DO TOCADOR
    private static final int InstrumentoAgogo = 114;
    private static final int InstrumentoHarpsichord = 7;
    private static final int InstrumentoTubularBells = 15;
    private static final int InstrumentoPanFlute = 76;
    private static final int InstrumentoChurchOrgan = 20;
    private static final String pausa = "R ";
    //VARIAVEIS DE CONTROLE DA MUSICA
    private int OitavaAtual;
    private int ID_Instrumento;
    private String LastNote;
    private int volume;
    //VARIAVEIS PROVENIENTES DO TEXTO
    private char Caractere;
    private String texto;
    //ITERADOR DO TEXTO
    private int i;
    //VARIAVEL DA STRING DA MUSICA
    private String musica;  

    //CONSTRUTOR
    public identificaCaractere(String texto) {
        //INTEIROS
        i = 0;
        ID_Instrumento = ID_Instrumento_Padrao;
        OitavaAtual = OitavaInicial;
        volume = volumePadrao;
        //CHAR
        Caractere = '\0';
        //STRING
        LastNote = "";
        //INICIALIZAÇÃO DO TEXTO
        this.texto = texto;
        //INICIALIZAÇÃO DA MUSICA
        musica = "";
    }
    //FUNCAO QUE INICIALIZA OS PADROES DA MUSICA
    private String inicializaMusica(){
        String musica = "";
        musica = musica.concat(AlteraVolume(volumePadrao));
        musica = musica.concat(AlteraInstrumento(ID_Instrumento_Padrao));
        return musica;
    }

    public static void main(String[] args){
        identificaCaractere ID = new identificaCaractere("");
        Player player = new Player();

        ID.musica = ID.geraStringMusica(ID.texto);
        System.out.println(ID.musica);

        player.play(ID.musica);

    }

    public String geraStringMusica(String texto) {

        String musica = inicializaMusica();

        for (i = 0; i < texto.length(); i++) {
            // Salva Caractere Anterior
            Caractere = texto.toLowerCase().charAt(i);
            // Verifica se é um digito
            if(Character.isDigit(Caractere)){
                ID_Instrumento = VerificaInstrumento(ID_Instrumento + Character.getNumericValue(Caractere));
                musica = musica.concat(AlteraInstrumento(ID_Instrumento));
            }
            else{
                switch (Caractere) {
                    // NOTA LA
                    case 'a':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'A'){
                            LastNote = geraStringNota('A', OitavaAtual);
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (lastCharisNote(musica)){
                                musica = musica.concat(LastNote);   
                            }
                            else{
                                musica = musica.concat(pausa);
                            }
                        }
                        break;
                    // NOTA SI
                    case 'b':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'B'){
                            LastNote = geraStringNota('B', OitavaAtual);
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (lastCharisNote(musica)){
                                musica = musica.concat(LastNote); 
                            }
                            else{
                                musica = musica.concat(pausa);
                            }
                        }
                        break;
                    // NOTA DO
                    case 'c':
                    //VERIFICA SE É MAIUSCULA
                    if(texto.charAt(i) == 'C'){
                        LastNote = geraStringNota('C', OitavaAtual);
                        musica = musica.concat(LastNote);
                    }
                    else{
                        if (lastCharisNote(musica)){
                            musica = musica.concat(LastNote);   
                        }
                        else{
                            musica = musica.concat(pausa);
                        }
                    }
                    break;
                    // NOTA RE
                    case 'd':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'D'){
                            LastNote = geraStringNota('D', OitavaAtual);
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (lastCharisNote(musica)){
                                musica = musica.concat(LastNote);   
                            }
                            else{
                                musica = musica.concat(pausa);
                            }
                        }
                        break;
                    // NOTA MI
                    case 'e':
                    //VERIFICA SE É MAIUSCULA
                    if(texto.charAt(i) == 'E'){
                        LastNote = geraStringNota('E', OitavaAtual);
                        musica = musica.concat(LastNote);
                    }
                    else{
                        if (lastCharisNote(musica)){
                            musica = musica.concat(LastNote);  
                        }
                        else{
                            musica = musica.concat(pausa);
                        }
                    }
                    break;
                    // NOTA FA
                    case 'f':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'F'){
                            LastNote = geraStringNota('F', OitavaAtual);
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (lastCharisNote(musica)){
                                musica = musica.concat(LastNote);  
                            }
                            else{
                                musica = musica.concat(pausa);
                            }
                        }
                        break;
                    // NOTA SOL
                    case 'g':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'G'){
                            LastNote = geraStringNota('G', OitavaAtual);
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (lastCharisNote(musica)){
                                //REPETE ULITMA NOTA
                                musica = musica.concat(LastNote);   
                            }
                            else{
                                //EFETUA PAUSA
                                musica = musica.concat(pausa);
                            }
                        }
                        break;
                    // DOBRA O VOLUME
                    case ' ':
                        volume = DobraVolume(volume);
                        musica = musica.concat(AlteraVolume(volume));
                        break;
                    // TROCA O INSTRUMENTO PARA AGOGO
                    case '!':
                        ID_Instrumento = InstrumentoAgogo;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    // OUTRAS VOGAIS - TROCAM O INSTRUMENTO PARA HARPSICHORD
                    case 'i':
                        ID_Instrumento = InstrumentoHarpsichord;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    case 'o':
                        ID_Instrumento = InstrumentoHarpsichord;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    case 'u':
                        ID_Instrumento = InstrumentoHarpsichord;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    //GERA NOTA ALEATORIA
                    case '?':
                        OitavaAtual = AlteraOitava(OitavaAtual);
                        break;
                    //TROCA PARA INSTRUMENTO GERADO ALEATORIAMENTE
                    case '\n':
                        ID_Instrumento = InstrumentoTubularBells;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    //ATRIBUI VALOR ALEATORIO AO BPM
                    case ';':
                        ID_Instrumento = InstrumentoPanFlute;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    case ',':
                        ID_Instrumento = InstrumentoChurchOrgan;
                        musica = musica.concat(AlteraInstrumento(ID_Instrumento));
                        break;
                    default:
                        if (lastCharisNote(musica)){
                            //REPETE ULITMA NOTA
                            musica = musica.concat(LastNote);   
                        }
                        else{
                            //EFETUA PAUSA
                            musica = musica.concat(pausa);
                        }
                        break;
                }
            }
        }
        return musica;
    }

    //METOTO QUE ALTERA AS OITAVAS
    private int AlteraOitava(int OitavaAtual){
        if((OitavaAtual+1) > maxOitavas){
            OitavaAtual = OitavaInicial;
        }
        else{
            OitavaAtual++;
        }
        return OitavaAtual;
    }

    private boolean lastCharisNote(String musica){
        //PEGA O ULTIMO CARACTERE DA MUSICA
        char last = musica.charAt(musica.length() - 3);
        if(last == 'A' || last == 'B' || last == 'C' || last == 'D' || last == 'E' || last == 'F' || last == 'G'){
            return true;
        }
        else{
            return false;
        }
    }

    //METODO PARA VERIFICAR O VOLUME
    private int DobraVolume(int volume){
        volume *= 2;
        //VERFICA SE CHEGOU NO MAXIMO OU NO MINIMO
        if(volume > maxVolume){
            volume = volumePadrao;
        }
        else if(volume < minVolume){
            volume = volumePadrao;
        }
        return volume;
    }

    //METODO PARA ALTERAR O VOLUME
    private String AlteraVolume(int volume){
        String newVolume = ":CON(7, " + Integer.toString(volume) + ") ";
        return newVolume;
    }

    private int VerificaInstrumento(int ID_Instrumento){
        if(ID_Instrumento > numIntstrumentos){
            ID_Instrumento = ID_Instrumento_Padrao;
        }
        return ID_Instrumento;
    }
    //METODO QUE ALTERA O INSTRUMENTO
    private String AlteraInstrumento(int ID_Instrumento){
        //MONTA STRING PARA CONCATENAR
        String novoInstrumento ="I"+Integer.toString(ID_Instrumento)+ " ";
        return novoInstrumento;
    }

    //METODO QUE MONTA A STRING DA NOTA PARA SER CONCATENADA
    private String geraStringNota(char nota,int OitavaAtual){
        String notaString = "";
        notaString = nota+Integer.toString(OitavaAtual)+ " ";

        return notaString;
    }
}