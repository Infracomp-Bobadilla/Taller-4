package co.edu.uniandes.infracom.taller4.exercise3;
import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;
import co.edu.uniandes.infracom.taller4.testhandler.TestHandler;

public class Exercise extends TestHandler<ExerciseMethods> implements ExerciseInterface<ExerciseMethods> {

    //Semáforos
    private Semaforo[] sems;

    public Exercise() {
        super();
        this.sems = new Semaforo[] {new Semaforo(0), new Semaforo(0), new Semaforo(0)};
    }


    @Override
    public void A(ExerciseThread thread) {
        //TODO Completar metodo A
        this.addEvents(ExerciseMethods.A);

        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo A",
                thread.getThreadId()
        ));
    }

    @Override
    public void B(ExerciseThread thread) {
        //TODO Completar metodo B
        this.addEvents(ExerciseMethods.B);

        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo B",
                thread.getThreadId()
        ));
    }

    @Override
    public void C(ExerciseThread thread) {
        //TODO Completar metodo C
        this.addEvents(ExerciseMethods.C);

        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo C",
                thread.getThreadId()
        ));

        //Se supone que es el último
        System.out.println("---- Resultado ----");
        System.out.println(super.toString());
    }

    @Override
    public void D(ExerciseThread thread) {
        //TODO Completar metodo D
        this.addEvents(ExerciseMethods.D);

        System.out.println(String.format(
                "Thread ID: %s " + "Ejecutando el metodo D",
                thread.getThreadId()
        ));
    }

    @Override
    public Semaforo[] getSemaphoresRef() {
        //TODO Instanciar y retonar la referencia a los semaforos
        return sems;
    }

    public static void main(String[] args) {
        //TODO Instanciar todo el proceso

        Exercise exc = new Exercise();
        String[] threads = new String[] {"B", "D", "A", "C"};
        for (int i = 0; i < threads.length; i++) {
            new ExerciseThread(threads[i], exc).start();
        }



    }
}
