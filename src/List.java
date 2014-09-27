public interface List<T> {
    public void add(T element);

    /** removes the first occurrence of element */
    public void remove(T element);

    /** removes the ith occurrence of element. If there's no ith
    occurrence, nothing happens. */
    public void remove(T element, int ith);

    /** returns the length of this list */
    public int length();

    /** gets the ith element of this list */
    public T get(int ith);
}
