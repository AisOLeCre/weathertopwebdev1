import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job{
    public void doJob() {
//        To stop play and cmd crashing
        if (Station.count() == 0) {
            Fixtures.loadModels("data.yml");
        }
    }
}
