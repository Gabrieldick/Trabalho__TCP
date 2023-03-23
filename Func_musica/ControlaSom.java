package Func_musica;
public class ControlaSom {
    private static final int numIntstrumentos = 127;
    private static final int maxVolume = 127;
    private static final int volumePadrao = 31;
    private static final int ID_Instrumento_Padrao = 0;
    private static final int OitavaInicial = 5;
    private static final int maxOitavas = 9;
    
    private int ID_Instrumento;
    private int volume;
    private int oitavaAtual;
    
    public ControlaSom() {
        ID_Instrumento = ID_Instrumento_Padrao;
        volume = volumePadrao;
        oitavaAtual = OitavaInicial;
    }
    public int getVolume() {
		return volume;
	}
    public void setVolume(int volume) {
		this.volume = volume;
	}
    //METODO PARA VERIFICAR O VOLUME
    public void DobraVolume(){
        volume *= 2;
        //VERFICA SE CHEGOU NO MAXIMO OU NO MINIMO
        if(volume > maxVolume){
            volume = volumePadrao;
        }
    }
    
  //METODO PARA RETORNAR STRING COM VOLUME
    public String VolumeToString(){
        String newVolume = ":CON(7, " + Integer.toString(volume) + ") ";
        return newVolume;
    }
    
  //METODO PARA RETORNAR STRING COM VOLUME
    public void VolumeToVolumePadrao(){
    	volume = volumePadrao;
    }
    
    public void VerificaInstrumento(){
        if(ID_Instrumento > numIntstrumentos){
            ID_Instrumento = ID_Instrumento_Padrao;
        }
    }
    
    public void AlteraInstrumento(int ID_Instrumento){
        this.ID_Instrumento = ID_Instrumento;
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
    }
    
    public int getOitavaAtual() {
    	return oitavaAtual;
    }
    
  //MÉTODO QUE ALTERA AS OITAVAS
    public void IncrementaOitava(){
        if((oitavaAtual+1) > maxOitavas){
            oitavaAtual = OitavaInicial;
        }
        else{
            oitavaAtual++;
        }
    }   
    public void OitavaToPadrao(){
        oitavaAtual = OitavaInicial;
    }
}