package pe.hoonihoon.bootstrap.network.api;

import pe.hoonihoon.bootstrap.constants.CdnApiService;
import pe.hoonihoon.bootstrap.network.RetrofitManager;

/**
 * Created by 152317 on 2017-04-06.
 */

public class ApiServiceController {

    private static CdnApiService apiService;

    public static CdnApiService getCdnApiService() {
        if(apiService == null) {
            apiService = RetrofitManager.getInstance().getRetrofit().create(CdnApiService.class);
        }
        return apiService;
    }
}
