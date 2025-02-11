/**
 * @author Rodrigo
 * @date 11 febrero, 2025
 */
public class HiloCamarero extends Thread {
    private  Vaso v;

    public HiloCamarero(Vaso vaso) {
        this.v = vaso;
    }
    public void run() {
        while (v.consultarVeces() <= 3) {
            if (!v.estaLLeno()){
                v.retardar();
                v.llenarVaso();
                System.out.println("Se ha llenado el vaso");
            }
            else  {System.out.println("No se puede llenar el vaso, cabezón");}
        }
    }
}
