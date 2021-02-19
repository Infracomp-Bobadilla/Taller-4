package co.edu.uniandes.infracom.taller4.quiz;
import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;

public interface ExerciseInterface<E extends Enum<E>> {
    // Metodo A
    void A(ExerciseThread thread);

    // Metodo B
    void B(ExerciseThread thread);

    // Metodo C
    void C(ExerciseThread thread);

    // Metodo D1
    void D1(ExerciseThread thread);
    
    // Metodo D2
    void D2(ExerciseThread thread);
    
    // Metodo E1
    void E1(ExerciseThread thread);
    
    // Metodo E2
    void E2(ExerciseThread thread);

    // Obtener los semaforos
    Semaforo[] getSemaphoresRef();
}
