public class ControlaSom {
    private static final int numIntstrumentos = 127;
    private static final int maxVolume = 127;
    private static final int minVolume = 0;
    private static final int volumePadrao = 30;
    private static final int ID_Instrumento_Padrao = 0;
    private static final int OitavaInicial = 5;
    private static final int maxOitavas = 9;
    
    private int ID_Instrumento;
    private int volume;
    private int OitavaAtual;
    
    public ControlaSom() {
        ID_Instrumento = ID_Instrumento_Padrao;
        volume = volumePadrao;
        OitavaAtual = OitavaInicial;
    }

    //METODO PARA VERIFICAR O VOLUME
    public void DobraVolume(){
        volume *= 2;
        //VERFICA SE CHEGOU NO MAXIMO OU NO MINIMO
        if(volume > maxVolume){
            volume = volumePadrao;
        }
        else if(volume < minVolume){
            volume = volumePadrao;
        }
        return;
    }
    
  //METODO PARA RETORNAR STRING COM VOLUME
    public String VolumeToString(){
        String newVolume = ":CON(7, " + Integer.toString(volume) + ") ";
        return newVolume;
    }
    
  //METODO PARA RETORNAR STRING COM VOLUME
    public void VolumeToVolumePadrao(){
    	volume = volumePadrao;
        return;
    }
    
    private boolean VerificaInstrumento(int ID_Instrumento){
        if(ID_Instrumento <= numIntstrumentos){
            return true;
        }
        else {
        	return false;
        }
    }
    
    public void AlteraInstrumento(int ID_Instrumento){
    	if (VerificaInstrumento(ID_Instrumento)) {
    		this.ID_Instrumento = ID_Instrumento;
    	}
    	else {
            this.ID_Instrumento = ID_Instrumento_Padrao;
    	}
    }
    
    public int getID_Instrumento() {
    	return this.ID_Instrumento;
    }
    
    public String InstrumentoToString(){
        //MONTA STRING PARA CONCATENAR
        String novoInstrumento ="I"+Integer.toString(ID_Instrumento)+ " ";
        return novoInstrumento;
    }
    
    public void setInstrumentoPadrao(){
        //MONTA STRING PARA CONCATENAR
        ID_Instrumento = ID_Instrumento_Padrao;
        return;
    }
    
    public int getOitavaAtual() {
    	return OitavaAtual;
    }
    
  //METODO QUE ALTERA AS OITAVAS
    public void AlteraOitava(){
        if((OitavaAtual+1) > maxOitavas){
            OitavaAtual = OitavaInicial;
        }
        else{
            OitavaAtual++;
        }
    }
    
    public void OitavaToPadrao(){
        OitavaAtual = OitavaInicial;
    }
}