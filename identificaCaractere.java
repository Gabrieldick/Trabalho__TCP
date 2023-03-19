public class identificaCaractere {
    //CONSTANTES DO TOCADOR
    private static final int InstrumentoAgogo = 114;
    private static final int InstrumentoHarpsichord = 7;
    private static final int InstrumentoTubularBells = 15;
    private static final int InstrumentoPanFlute = 76;
    private static final int InstrumentoChurchOrgan = 20;
    private static final String pausa = "R ";
    //VARIAVEIS DE CONTROLE DA MUSICA
    private String LastNote;
    private ControlaSom configSom = new ControlaSom();
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
        configSom.volumeToVolumePadrao();
        musica = musica.concat(configSom.VolumeToString());
        configSom.setInstrumentoPadrao();
        musica = musica.concat(configSom.InstrumentoToString());
        return musica;
    }

    public String geraStringMusica() {

        String musica = inicializaMusica();

        for (i = 0; i < texto.length(); i++) {
            // Salva Caractere Anterior
            Caractere = texto.toLowerCase().charAt(i);
            // Verifica se é um digito
            if(Character.isDigit(Caractere)){
            	int charNum = Character.getNumericValue(Caractere);
            	configSom.AlteraInstrumento(configSom.getID_Instrumento() + charNum);
            	musica = musica.concat(configSom.InstrumentoToString());
            }
            else{
                switch (Caractere) {
                    // NOTA LA
                    case 'a':
                        //VERIFICA SE É MAIUSCULA
                        if(texto.charAt(i) == 'A'){
                            LastNote = geraStringNota('A');
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (previousCharisNote(i)){
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
                            LastNote = geraStringNota('B');
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (previousCharisNote(i)){
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
                        LastNote = geraStringNota('C');
                        musica = musica.concat(LastNote);
                    }
                    else{
                        if (previousCharisNote(i)){
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
                            LastNote = geraStringNota('D');
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (previousCharisNote(i)){
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
                        LastNote = geraStringNota('E');
                        musica = musica.concat(LastNote);
                    }
                    else{
                        if (previousCharisNote(i)){
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
                            LastNote = geraStringNota('F');
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (previousCharisNote(i)){
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
                            LastNote = geraStringNota('G');
                            musica = musica.concat(LastNote);
                        }
                        else{
                            if (previousCharisNote(i)){
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
                        configSom.DobraVolume();
                        musica = musica.concat(configSom.VolumeToString());
                        break;
                    // TROCA O INSTRUMENTO PARA AGOGO
                    case '!':
                    	configSom.AlteraInstrumento(InstrumentoAgogo);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    // OUTRAS VOGAIS - TROCAM O INSTRUMENTO PARA HARPSICHORD
                    case 'i':
                    	configSom.AlteraInstrumento(InstrumentoHarpsichord);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    case 'o':
                    	configSom.AlteraInstrumento(InstrumentoHarpsichord);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    case 'u':
                    	configSom.AlteraInstrumento(InstrumentoHarpsichord);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    //GERA NOTA ALEATORIA
                    case '?':
                        configSom.AlteraOitava();
                        break;
                    //TROCA PARA INSTRUMENTO GERADO ALEATORIAMENTE
                    case '\n':
                    	configSom.AlteraInstrumento(InstrumentoTubularBells);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    //ATRIBUI VALOR ALEATORIO AO BPM
                    case ';':
                    	configSom.AlteraInstrumento(InstrumentoPanFlute);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    case ',':
                    	configSom.AlteraInstrumento(InstrumentoChurchOrgan);
                        musica = musica.concat(configSom.InstrumentoToString());
                        break;
                    default:
                        if (previousCharisNote(i)){
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
    
    private boolean previousCharisNote(int posAtual) {
    	//PEGA O ULTIMO CARACTERE DA MUSICA
    	int pos = posAtual-1;
    	if(pos<0) {
    		pos = 0;
    	}
        char last = texto.charAt(pos);
        if(last == 'A' || last == 'B' || last == 'C' || last == 'D' || last == 'E' || last == 'F' || last == 'G'){
            return true;
        }
        else{
            return false;
        }
    }


    //METODO QUE MONTA A STRING DA NOTA PARA SER CONCATENADA
    private String geraStringNota(char nota){
        String notaString = "";
        notaString = nota+Integer.toString(configSom.getOitavaAtual())+ " ";

        return notaString;
    }

    public void setMusica(String musica){
        this.musica = musica;
    }

    public String getMusica(){
        return this.musica;
    }
}