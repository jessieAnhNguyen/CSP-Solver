package Variables;

public class JobShopVar extends Variable{

    // variables needed are task name and starting time
    public String taskName;
    public int duration;

    public JobShopVar(String taskName, int duration) {
        this.taskName = taskName;
        this.duration = duration;
    }
}

