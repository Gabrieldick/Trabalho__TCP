import java.util.Random;

import org.jfugue.player.Player;

public class identificaCaractere {
    //CONSTANTES
    private static final int numIntstrumentos = 127;
    private static final int numNotas = 7;
    private static final int maxBPM = 250;
    private static final int OitavaInicial = 5;
    private static final int maxOitavas = 9;
    private static final int minOitavas = 0;
    private static final int maxVolume = 127;
    private static final int minVolume = 0;
    private static final int bpmPadrao = 80;
    private static final int volumePadrao = 64;
    private static final int ID_Instrumento_Padrao = 0;
    private static final String telefone = "C5q B4i A4i B4i Rq C5q B4i A4i B4i Rq C5q B4i A4i B4i Rq C5q B4i A4i B4i Rq C5q ";
    //VARIAVEIS DE CONTROLE DA MUSICA
    private int OitavaAtual;
    private int BPM;
    private int ID_Instrumento;
    private String LastNote;
    private int volume;
    private boolean lastCharisNote;
    //VARIAVEIS PROVENIENTES DO TEXTO
    private char Caractere;
    private String texto;
    //ITERADOR DO TEXTO
    private int i;
    //VARIAVEIS QUE ALTERAM PROPRIEDADES DA MUSICA
    private int notaAleatoria;
    private String comandoInstrumento;
    private String comandoBPM;
    private String ComandoVolume;
    //VARIAVEL DA STRING DA MUSICA
    private String musica;  

    //CONSTRUTOR
    public identificaCaractere(String texto) {
        //INTEIROS
        i = 0;
        ID_Instrumento = ID_Instrumento_Padrao;
        notaAleatoria = 0;
        BPM = bpmPadrao;
        OitavaAtual = OitavaInicial;
        volume = volumePadrao;
        //BOOLEANAS
        lastCharisNote = false;
        //CHAR
        Caractere = '\0';
        //STRING
        comandoBPM = "";
        LastNote = "";
        comandoInstrumento = "";
        ComandoVolume = "";
        //INICIALIZAÇÃO DO TEXTO
        this.texto = texto;
        //INICIALIZAÇÃO DA MUSICA
        musica = "";
    }
    //FUNCAO QUE INICIALIZA OS PADROES DA MUSICA
    private String inicializaMusica(){
        String musica = "";
        musica = musica.concat(AlteraVolume(volumePadrao));
        musica = musica.concat(AlteraBPM(bpmPadrao));
        musica = musica.concat(AlteraInstrumento(ID_Instrumento_Padrao));
        return musica;
    }

    public static void main(String[] args){
        identificaCaractere ID = new identificaCaractere("??+???+?r-??r+?r+?r+?r-?r-?r-?r-?;?\n???\n???bpm+?bpm+?????????????");
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
            switch (Caractere) {
                // NOTA LA
                case 'a':
                    LastNote = geraStringNota('A', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // NOTA SI
                case 'b':
                    //VERIFICA SE É UMA NOTA OU ALTERAÇÃO DE BPM
                    if(VerficaBPM(texto,i))
                    {
                        //ALTERA O VALOR DO CONTADOR PARA ATUALIZAR
                        i = i+3;
                        lastCharisNote = false;
                        //AUMENTA O BPM EM 80 UNIDADES
                        BPM += 80;
                        //ALTERA O BPM
                        comandoBPM = AlteraBPM(BPM);
                        musica = musica.concat(comandoBPM);
                    }
                    else{
                        LastNote = geraStringNota('B', OitavaAtual);
                        musica = musica.concat(LastNote);
                        lastCharisNote = true;
                    }
                    break;
                // NOTA DO
                case 'c':
                    LastNote = geraStringNota('C', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // NOTA RE
                case 'd':
                    LastNote = geraStringNota('D', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // NOTA MI
                case 'e':
                    LastNote = geraStringNota('E', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // NOTA FA
                case 'f':
                    LastNote = geraStringNota('F', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // NOTA SOL
                case 'g':
                    LastNote = geraStringNota('G', OitavaAtual);
                    musica = musica.concat(LastNote);
                    lastCharisNote = true;
                    break;
                // PAUSA OU SILENCIO
                case ' ':
                    musica = musica.concat("R ");
                    lastCharisNote = false;
                    break;
                // DOBRAR O VOLUME
                case '+':
                    volume = volume * 2;
                    ComandoVolume = AlteraVolume(volume);
                    musica = musica.concat(ComandoVolume);
                    lastCharisNote = false;
                    break;
                // VOLTA VOLUME PADRAO
                case '-':
                    ComandoVolume = AlteraVolume(volumePadrao);
                    musica = musica.concat(ComandoVolume);
                    lastCharisNote = false;
                    break;
                // OUTRAS VOGAIS
                case 'i':
                    //SE FOR NOTA, REPETE A ULTIMA
                    if (lastCharisNote) {
                        musica = musica.concat(LastNote);
                        lastCharisNote = true;
                    } 
                    //SE NAO FOR NOTA, TOCA TELEFONE TOCANDO
                    else {
                        musica = musica.concat(telefone);
                        lastCharisNote = false;
                    }
                    break;
                case 'o':
                    //SE FOR NOTA, REPETE A ULTIMA
                    if (lastCharisNote) {
                        musica = musica.concat(LastNote);
                        lastCharisNote = true;
                    } 
                    //SE NAO FOR NOTA, TOCA TELEFONE TOCANDO
                    else {
                        musica = musica.concat(telefone);
                        lastCharisNote = false;
                    }
                    break;
                case 'u':
                    //SE FOR NOTA, REPETE A ULTIMA
                    if (lastCharisNote) {
                        musica = musica.concat(LastNote);
                        lastCharisNote = true;
                    } 
                    //SE NAO FOR NOTA, TOCA TELEFONE TOCANDO
                    else {
                        musica = musica.concat(telefone);
                        lastCharisNote = false;
                    }
                    break;
                // VERIFICA SE O CARACTERE É R PARA MEXER NAS OITAVAS
                case 'r':
                    //SE FOR +, SOBE UMA OITAVA
                    if(texto.toLowerCase().charAt(i+1) == '+'){
                        OitavaAtual = AlteraOitava('+', OitavaAtual);
                        //ATUALIZA O VALOR DO CONTADOR
                        i++;
                    }
                    //SE FOR -, REDUZ UMA OITAVA
                    else if(texto.toLowerCase().charAt(i+1) == '-'){
                        OitavaAtual = AlteraOitava('-', OitavaAtual);
                        //ATUALIZA O VALOR DO CONTADOR
                        i++;
                    }
                    lastCharisNote = false;
                    break;
                //GERA NOTA ALEATORIA
                case '?':
                    notaAleatoria = GeraNumeroAleatorio(numNotas);
                    //GERA A SINTAXE DA NOTA COM BASE NA NOTA ALEATORIA GERADA
                    LastNote = geraStringNota(geraNotaAleatoria(notaAleatoria), OitavaAtual);
                    lastCharisNote = true;
                    musica = musica.concat(LastNote);
                    break;
                //TROCA PARA INSTRUMENTO GERADO ALEATORIAMENTE
                case '\n':
                    //GERA INSTRUMENTO ALEATORIO
                    ID_Instrumento = GeraNumeroAleatorio(numIntstrumentos);
                    //CHAMA FUNCAO QUE MONTA STRING PARA ALTERAR INSTRUMENTO
                    comandoInstrumento = AlteraInstrumento(ID_Instrumento);
                    musica = musica.concat(comandoInstrumento);
                    lastCharisNote = false;
                    break;
                //ATRIBUI VALOR ALEATORIO AO BPM
                case ';':
                    lastCharisNote = false;
                    //GERA NUMERO ALEATORIO PARA O BPM
                    BPM = GeraNumeroAleatorio(maxBPM);
                    //GERA STRING PARA ALTERAR O BPM
                    comandoBPM = AlteraBPM(BPM);
                    musica = musica.concat(comandoBPM);
                    break;
                default:
                    break;
            }
        }
        return musica;
    }

    private int GeraNumeroAleatorio(int Max){
        Random random = new Random();
        //GERA NUMERO ALEATORIO DE 0 A Max
        int numeroAleatorio = random.nextInt(Max);

        return numeroAleatorio;
    }

    //METODO PARA ALTERAR O BPM
    private String AlteraBPM(int BPM){
        String newBPM = "";

        newBPM = "T"+ Integer.toString(BPM)+ " ";
        return newBPM;  
    }

    //METOTO QUE ALTERA AS OITAVAS
    private int AlteraOitava(char sinal,int OitavaAtual){
        //VERIFICA O SINAL PARA SUBIR OU DESCER UMA OITAVA
        if(sinal == '+'){
            if (OitavaAtual >= maxOitavas) {
                OitavaAtual = maxOitavas;
            } 
            else {
                OitavaAtual++;
            }
        }
        else if(sinal == '-'){
            if (OitavaAtual <= minOitavas) {
                OitavaAtual = minOitavas;
            } else {
                OitavaAtual--;
            }
        }
        return OitavaAtual;
    }
    //METODO QUE VERIFICA SE A LETRA B FAZ PARTE DA STRING BPM+
    private boolean VerficaBPM(String texto,int i){
        boolean BPM = false;
        //VERIFICA SE CHEGOU NO FINAL DA STRING
        if(i+3 < texto.length()){
            if(texto.substring(i,i+4).toLowerCase().equals("bpm+")){
                BPM = true;
            }
            else{
                BPM = false;
            }
        }
        else{
            BPM = false;
        }
        return BPM;
    }
    //METODO PARA ALTERAR O VOLUME
    private String AlteraVolume(int volume){
        //VERFICA SE CHEGOU NO MAXIMO OU NO MINIMO
        if(volume >= maxVolume){
            volume = maxVolume;
        }
        else if(volume <= minVolume){
            volume = minVolume;
        }
        String newVolume = ":CON(7, " + Integer.toString(volume) + ") ";
        return newVolume;
    }

    //METODO QUE ALTERA O INSTRUMENTO DE FORMA ALEATORIA
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

    //METODO QUE RETORNA NOTA ALEATORIA
    private char geraNotaAleatoria(int notaAleatoria){
        String Notas = "ABCDEFG";
        //RETORNA O CHAR PERTENCENTE AO NUMERO ALEATORIO
        return Notas.charAt(notaAleatoria);
    }
}

