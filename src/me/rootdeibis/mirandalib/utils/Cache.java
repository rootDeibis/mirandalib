package me.rootdeibis.mirandalib.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cache<T> {


    private Set<T> caches = new HashSet<T>();

    public Cache() {}

    public void add(T cache) {
        this.caches.add(cache);
    }

    public void addAll(Collection<T> values) {
        this.caches.addAll(values);
    }

    public Set<T> all() {
        return this.caches;
    }

    public Set<T> all(Predicate<T> filter) {
        return this.caches.stream().filter(filter).collect(Collectors.toSet());
    }

    public T find(Predicate<T> predication) {
        return this.caches.stream().filter(predication).findFirst().orElse(null);


    }

    public boolean has(Predicate<T> predication) {
        return this.find(predication) != null;
    }

    public void remove(Predicate<T> predication) {
        this.caches.removeIf(predication);
    }


}
