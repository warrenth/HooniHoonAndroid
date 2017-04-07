package pe.hoonihoon.bootstrap.view.vo;

/**
 * Created by 152317 on 2017-04-06.
 */

public class ServiceResult<T> extends Result {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
