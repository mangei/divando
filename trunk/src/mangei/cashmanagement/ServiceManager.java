package mangei.cashmanagement;

import mangei.cashmanagement.services.BuchungService;
import mangei.cashmanagement.services.BuchungServiceImpl;

/**
 *
 * @author manuel.geier
 */
public class ServiceManager {

    public static BuchungService getBuchungService() {
        return BuchungServiceImpl.getInstance();
    }
}
