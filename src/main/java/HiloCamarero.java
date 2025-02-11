/**
 * @author Rodrigo
 * @date 11 febrero, 2025
 */
public class HiloCamarero extends Thread {
    private Vaso v;

    public HiloCamarero(Vaso vaso) {
        this.v = vaso;
    }

    public void run() {
        while (v.consultarVeces() < 3) {
            synchronized (v) {
                while (v.estaLLeno()) {
                    try {
                        System.out.println("No puedes llenar el vaso todavía");
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                v.llenarVaso();
                System.out.println("Se ha llenado el vaso");
                v.notifyAll();
            }
        }
    }
}