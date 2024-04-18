package com.mypractice.dataStructure;

public class CircularBuffer {
    /** Size of the buffer */
    private final int size;

    /** The buffer */
    private final int[] buffer;

    /** Index of the next data to be read from the buffer */
    private int readIndex;

    /** Index of the next data written in the buffer */
    private int writeIndex;

    private int removeIndex;

    public CircularBuffer(final int size) {
        this.size = size;
        buffer = new int[size];
    }

    /**
     * Tests whether a new byte can be read from the buffer.
     *
     * @return Whether a new byte can be read from the buffer.
     */
//    public boolean available() {
//        return readIndex != writeIndex;
//    }

    /**
     * Copies a previous interval in the buffer to the current position.
     *
     * @param distance the distance from the current write position
     * @param length   the number of bytes to copy
     */
    public void copy(final int distance, final int length) {
        final int pos1 = writeIndex - distance;
        final int pos2 = pos1 + length;
        for (int i = pos1; i < pos2; i++) {
            buffer[writeIndex] = buffer[(i + size) % size];
            writeIndex = (writeIndex + 1) % size;
        }
    }

    /**
     * Reads a byte from the buffer.
     *
     * @return a byte from the buffer.
     */
    public int get() {
//        if (available()) {
            final int value = buffer[readIndex];
            readIndex = (readIndex + 1) % size;
            return value;
//        }
//        return -1;
    }

    /**
     * Puts a byte to the buffer.
     *
     * @param value the value to put.
     */
    public void put(final int value) {
        buffer[writeIndex] = (int) value;

        if ((writeIndex + 1) >= size) {
            removeIndex = (removeIndex + 1) % size;
            readIndex = (readIndex + 1) % size;
        }
        writeIndex = (writeIndex + 1) % size;

    }

    public void remove() {
        buffer[removeIndex] = 0;
        removeIndex = (removeIndex + 1) % size;
    }



    public void print() {
        StringBuilder ret = new StringBuilder();
        for (int b : buffer) {
            ret.append(b).append(", ");
        }
        System.out.println(ret);
    }
}
