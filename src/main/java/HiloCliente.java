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
            synchronized (v) {
                while (!v.estaLLeno()) {
                    try {
                        System.out.println("No puedes beber, el vaso está vacío");
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                v.retardar();
                v.vaciarVaso();
                v.incrementarVeces();
                System.out.println("El cliente se ha bebido el vaso");
                v.notifyAll();
            }
        }
        System.out.println("El cliente ya ha bebido 3 veces");
    }
}