package model;

import java.time.LocalDateTime;


public abstract class BaseEntity<K extends Comparable<K>, V extends Identifiable<K>>
    implements Identifiable<K>, Comparable<V> {

    private K id;
    private LocalDateTime created;
    private LocalDateTime modified;





    // set modified when the account is modified;
    public BaseEntity() {
        created = LocalDateTime.now();
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?, ?> that = (BaseEntity<?, ?>) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public int compareTo(V other) {
        return id.compareTo(other.getId());
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

    @Override
    public K getId() {
        return this.id;
    }

    @Override
    public void setId(K id) {
        this.id = id;
    }
}

