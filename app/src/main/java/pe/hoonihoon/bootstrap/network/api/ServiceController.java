package pe.hoonihoon.bootstrap.network.api;

import pe.hoonihoon.bootstrap.constants.CdnApiService;
import pe.hoonihoon.bootstrap.constants.SampleApiService;
import pe.hoonihoon.bootstrap.network.RetrofitManager;

/**
 * Created by 152317 on 2017-04-06.
 */

public class ServiceController {

    private static CdnApiService cdnApiService;
    private static SampleApiService sampleApiService;

    public static CdnApiService getCdnApiService() {
        if(cdnApiService == null) {
            cdnApiService = RetrofitManager.getInstance().getRetrofit().create(CdnApiService.class);
        }
        return cdnApiService;
    }

    public static SampleApiService getSampleApiService() {
        if(sampleApiService == null) {
            sampleApiService = RetrofitManager.getInstance().getRetrofit().create(SampleApiService.class);
        }
        return sampleApiService;
    }
}
