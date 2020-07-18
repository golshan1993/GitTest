package maktab.hw4.q1;

import static java.lang.Integer.SIZE;

public class DataStructure { // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
        public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
            System.out.println();
    }

           void print(DataStructureIterator iterator){
               System.out.print(iterator.next()+" ");

           }




            interface DataStructureIterator extends java.util.Iterator<Integer> {

            } // Inner class implements the DataStructureIterator interface, // which extends the Iterator<Integer> interface
            private class EvenIterator implements DataStructureIterator {
                // Start stepping through the array from the beginning
                private int nextIndex = 0;

                public boolean hasNext() {
                    // Check if the current element is the last in the array
                    return (nextIndex <= SIZE - 1);
                }

                public Integer next() {
                    // Record a value of an even index of the array
                    Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
                    // Get the next even element
                    nextIndex += 2;
                    return retValue;
                }

            }



                    public static void main(String s[]) {
                        // Fill the array with integer values and print out only // values of even indices DataStructure
                        DataStructure ds = new DataStructure();
                        ds.printEven();
                        DataStructureIterator iterator = ds.new EvenIterator();
                        while(iterator.hasNext())
                        ds.print(iterator);
                        iterator = ds.new EvenIterator();
                        System.out.println();
                        DataStructureIterator iterator1 = new DataStructureIterator(){
                            private int nextIndex = -1;
                            public boolean hasNext() {
                                // Check if the current element is the last in the array
                                return (nextIndex <= SIZE - 1);
                            }

                            public Integer next() {
                                nextIndex += 2;
                                Integer retValue = (Integer)nextIndex;
                                return retValue;
                            }

                        };
                        while (iterator1.hasNext()){
                            ds.print(iterator1);

                        }

                    }
            }
