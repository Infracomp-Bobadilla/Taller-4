package co.edu.uniandes.infracom.taller4.barrier;

import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;
import co.edu.uniandes.infracom.taller4.testhandler.TestHandler;

public class Barrier extends TestHandler<BarrierMethods> implements BarrierInterface<BarrierMethods> {
	
	// Semaforos
    private Semaforo[] semaphores;
    
    // .. Constructores
    
    public Barrier() {
        super();
        this.semaphores = new Semaforo[] {new Semaforo(0), new Semaforo(0)};
    }

    @Override
    public void A(BarrierThread thread) {
    	this.addEvents(BarrierMethods.A);
        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo A",
                thread.getThreadId()
        ));
    }

    @Override
    public void B(BarrierThread thread) {
    	this.addEvents(BarrierMethods.B);
        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo B",
                thread.getThreadId()
        ));
    }

    @Override
    public void C(BarrierThread thread) {
    	this.addEvents(BarrierMethods.C);
        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo C",
                thread.getThreadId()
        ));
        System.out.println("---- Resultado ----");
        System.out.println(super.toString());
    }

    @Override
    public Semaforo[] getSemaphoresRef() {
        return semaphores;
    }

    public static void main(String[] args) {
        Barrier barr = new Barrier();
        String[] threads = new String[] {"A", "B", "C"};
        for(int i = 0; i < threads.length; i++)
        	new BarrierThread(threads[i], barr).start();
    }
}
