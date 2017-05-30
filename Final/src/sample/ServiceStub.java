package sample;

/**
 * Created by Lucy on 5/29/17.
 */
public class ServiceStub implements Service {
    @Override
    public String isActive() {
        return "Is Active";
    }
}
