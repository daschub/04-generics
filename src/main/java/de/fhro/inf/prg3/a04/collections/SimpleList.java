package de.fhro.inf.prg3.a04.collections;

public interface SimpleList<T> extends Iterable<T> {
    void add(T item);

    /**
     * @return current size of the list
     */
    int size();

    /**
     * Generate a new list using the given filter instance.
     *
     * @param filter SimpleFilter instance to determine which elements should be included
     * @return a new, filtered list
     */
    default SimpleList<T> filter(SimpleFilter<T> filter) {
        SimpleList<T> result = new SimpleListImpl<>();
        for (T o : this) {
            if (filter.include(o)) {
                result.add(o);
            }
        }
        return result;
    }

    ;
}
