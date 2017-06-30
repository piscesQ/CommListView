package retrofit2_source.adapter.rxjava;

import retrofit2_source.Response;

/** @deprecated Use {@link retrofit2_source.HttpException}. */
@Deprecated
public final class HttpException extends retrofit2_source.HttpException {
  public HttpException(Response<?> response) {
    super(response);
  }
}
