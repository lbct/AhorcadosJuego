package modelo;

public class Juego
{
    private Palabra palabra;
    private int numeroDeIntentosMaximos;

    public Juego(Palabra palabra, int numeroDeIntentosMaximos){
        this.palabra = palabra;
        this.numeroDeIntentosMaximos = numeroDeIntentosMaximos;
    }

    public EstadoJuego getEstadoJuego(){
        if(palabra.getNumeroDeFallos() >= numeroDeIntentosMaximos)
            return EstadoJuego.PERDIDO;
        int sum = 0;
        for(int i=0;i<palabra.getLongitudPalabra();i++)
            sum += palabra.getEstadoLetra(i) ? 1 : 0;
        if(sum == palabra.getLongitudPalabra())
            return EstadoJuego.GANADO;
        return EstadoJuego.CONTINUA;
    }

    public boolean acertarLetra(char letra){
        return palabra.acertarLetra(letra);
    }

    public Palabra getPalabra(){
        return palabra;
    }

    public void volverAJugar(Palabra nueva){
        this.palabra = nueva;
        palabra.restaurarValores();
    }
}
