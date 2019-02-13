package com.xk.book.datastructures.chapter3.no_3_4;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * ArrayList的实现（不考虑并发处理，考虑数组越界）
 * Created by xuekai on 2017/4/20.
 */

public class MyArrayList<T> implements Iterable<T> {

    private final int DEFAULT_CAPACITY = 10;

    private int size;

    private T[] items= (T[]) new Object[10];

    public MyArrayList() {
        clear();
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public void set(T value, int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items[index] = value;
    }

    public void clear() {
        size = 0;
        ensurecapacity(DEFAULT_CAPACITY);
    }

    /**
     * 设置数组的长度
     *
     * @param length
     */
    private void ensurecapacity(int length) {
        if (length < size) {
            return;
        }
        T[] oldItems = items;
        items = (T[]) new Object[length];
        for (int i = 0; i < oldItems.length; i++) {
            items[i] = oldItems[i];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void trimToSize() {
        ensurecapacity(size);
    }

    public void add(T item) {
        add(item, size());
    }

    public void add(T item, int index) {
        if (items.length == size) {//已经存满了,扩大数组
            ensurecapacity(size * 2 + 1);
        }
        for (int i = size; i > index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        size++;
    }

    public T remove(int index) {
        T item = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<T> {
        private int index=-1;

        @Override
        public boolean hasNext() {
            return index < size-1;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            return items[index];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(index);
            index--;
        }
    }
}
