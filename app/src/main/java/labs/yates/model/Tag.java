package labs.yates.model;

/**
 * A pair-like record that holds tags.
 *
 * @param key
 * @param value
 * @param <K>
 * @param <V>
 */
public record Tag<K, V>(K key, V value) {}
