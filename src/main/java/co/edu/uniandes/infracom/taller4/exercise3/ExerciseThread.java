package co.edu.uniandes.infracom.taller4.exercise3;
import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;

public class ExerciseThread extends Thread {
    private String id;
    private Exercise ref;
    private Semaforo[] sems;

    // Constructor
    public ExerciseThread(String pId, Exercise pRef) {
        this.id = pId;
        this.ref = pRef;
        this.sems = this.ref.getSemaphoresRef();
    }

    // Devolver el ID asignado
    String getThreadId() {
        return id;
    }

    @Override
    public void run() {
        // TODO Implementar el proceso
        if (this.id.equals("B")){
            this.ref.B(this);
            this.sems[0].v();
            //this.sems[1].v();
        } else if (this.id.equals("D")){
            //this.sems[1].p();
            this.sems[0].p();
            this.ref.D(this);
            this.sems[0].v();
            this.sems[1].v();
            this.sems[2].v();
        } else if (this.id.equals("A")){
            this.sems[2].p();
            this.sems[2].v();
            this.sems[0].p();
            this.ref.A(this);
        } else {
            this.sems[2].p();
            this.sems[2].v();
            this.sems[1].p();
            this.ref.C(this);
        }

    }
}
