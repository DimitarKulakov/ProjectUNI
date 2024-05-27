import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym instance;
    private TrainingPlan currentPlan;

    private Gym() {
    }

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public void setTrainingPlan(TrainingPlan plan) {
        this.currentPlan = plan;
        notifyAllTrainees();
    }

    public TrainingPlan getTrainingPlan() {
        return currentPlan;
    }

    // Observer pattern methods
    private List<Trainee> trainees = new ArrayList<>();

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
    }

    public void notifyAllTrainees() {
        for (Trainee trainee : trainees) {
            trainee.update();
        }
    }
}