package doubts;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {/*
        PriorityQueue<Integer>  pq=new PriorityQueue<>();
        pq.add(1);
        pq.add(10);
        pq.add(2);
        pq.add(5); pq.add(3); pq.add(7);*/

        PriorityQueue<Data>  pq=new PriorityQueue<>(new DataComparator());
        pq.add(new Data(1,"Rakesh"));
        pq.add(new Data(10,"SHaram"));
        pq.add(new Data(2,"Saniya"));
        pq.add(new Data(5,"Srisha"));pq.add(new Data(7,"Depsy"));
        pq.add(new Data(3,"sama"));

        printPq(pq);
    }

    private static  void printPq(PriorityQueue<Data> pq) {
        while(!pq.isEmpty()){
            System.out.print(pq.peek().getRollNumber()+"->");
            pq.remove();
        }
    }
}

class Data{
    Integer rollNumber;
    String name;

    public Data(Integer rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DataComparator implements Comparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        return o1.getRollNumber()-o2.getRollNumber();
    }
}
