public class Session extends Admin {
    private String date;
    private String time;
    private int slotLimit;

    public Session(String name, String email, String phone, String username, String password, String date, String time, int slotLimit) {
        super(name, email, phone, username, password);
        this.date = date;
        this.time = time;
        this.slotLimit = slotLimit;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getSlotLimit() {
        return slotLimit;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSlotLimit(int slotLimit) {
        this.slotLimit = slotLimit;
    }

    public void book() {

    }

    public void cancel() {

    }
}
