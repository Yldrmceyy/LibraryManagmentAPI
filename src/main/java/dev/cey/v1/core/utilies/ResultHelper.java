package dev.cey.v1.core.utilies;

import dev.cey.v1.core.result.Result;
import dev.cey.v1.core.result.ResultData;

public class ResultHelper {
    public static <T>ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED,"201", data);
    }

    public static <T>ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR,"400",data);
    }

    public static <T>ResultData<T> success(T data) {
        return new ResultData<>(false, Msg.OK,"200",data);
    }
    public static Result notFoundError(String msg) {
        return new Result(false, msg,"404");
    }
}
