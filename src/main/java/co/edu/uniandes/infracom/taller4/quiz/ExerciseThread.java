package co.edu.uniandes.infracom.taller4.quiz;
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

		// .. A
		if(this.id.equals("A")) {
			this.sems[4].p();
			this.ref.A(this);
			this.sems[7].v();
		}

		// .. B
		if(this.id.equals("B")) {
			this.ref.B(this);
			this.sems[0].v();
			this.sems[1].v();
			this.sems[2].v();
		}

		// .. C
		if(this.id.equals("C")) {
			this.sems[5].p();
			this.ref.C(this);
			this.sems[6].v();
		}

		// .. D
		if(this.id.equals("D")) {
			this.sems[2].p();
			this.sems[2].v();
			this.sems[1].p();
			this.ref.D1(this);
			this.sems[4].v();		
			//----------------
			this.sems[8].p();
			this.sems[7].p();
			this.sems[6].p();
			this.ref.D2(this);
			this.sems[9].v();
		}

		// .. E
		if(this.id.equals("E")) {
			this.sems[2].p();
			this.sems[2].v();
			this.sems[0].p();
			this.ref.E1(this);
			this.sems[5].v();			
			this.sems[8].v();
			//----------------
			this.sems[9].p();
			this.ref.E2(this);
		}

	}
}
