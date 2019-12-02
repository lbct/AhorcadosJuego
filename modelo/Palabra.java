package modelo;

public class Palabra
{
    private char[] valores;
    private boolean[] estadoAciertos;
    private int numeroDeFallos;

    public Palabra(String valor){
        valor = valor.trim().toUpperCase();
        valores = valor.toCharArray();
        estadoAciertos = new boolean[valores.length];
        numeroDeFallos = 0;
    }

    public void restaurarValores(){
        numeroDeFallos = 0;
        estadoAciertos = new boolean[valores.length];
    }

    public boolean acertarLetra(char letra){
        boolean acertado = false;
        for(int i=0;i<valores.length;i++){
            if(letra == valores[i] && !estadoAciertos[i]){
                acertado = true;
                estadoAciertos[i] = true;
            }
        }
        if(!acertado)
            numeroDeFallos++;
        return acertado;
    }

    public int getNumeroDeFallos(){
        return numeroDeFallos;
    }

    public boolean getEstadoLetra(int index){
        return estadoAciertos[index];
    }

    public int getLongitudPalabra(){
        return valores.length;
    }

    public String getPalabra(){
        String p = "";
        for(char c : valores)
            p += c;
        return p;
    }

    public char[] getValoresOcultos(){
        char[] nuevos = new char[valores.length];
        for(int i=0;i<valores.length;i++){
            if(estadoAciertos[i])
                nuevos[i] = valores[i];
            else
                nuevos[i] = '-';
        }
        return nuevos;
    }
}
