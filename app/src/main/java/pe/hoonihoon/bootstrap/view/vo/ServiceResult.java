package pe.hoonihoon.bootstrap.view.vo;

import java.util.List;

/**
 * Created by 152317 on 2017-04-06.
 */

public class ServiceResult<T> extends Result {
    private T object;

    public T getResult() {
        return object;
    }

}
