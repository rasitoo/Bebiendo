/**
 * @author Rodrigo
 * @date 11 febrero, 2025
 */
public class HiloCliente extends Thread {
    private Vaso v;

    public HiloCliente(Vaso vaso) {
        this.v = vaso;
    }

    public void run() {
        while (v.consultarVeces() <= 3) {
            if (v.estaLLeno()) {
                v.retardar();
                v.vaciarVaso();
                v.incrementarVeces();
                System.out.println("El cliente se ha bebido el vaso");
            } else
                System.out.println("El cliente no puede beber, su vaso está vacío, y eres un cabezón");
        }
        System.out.println("El cliente ya ha bebido 3 veces");
    }
}
