package rdx.gateway.challenge.util;

public interface Converter<T,R> {
    R convertTo(T value);
}
