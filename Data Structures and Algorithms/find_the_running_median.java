import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    List<Double>result=new ArrayList<>();

    for(int b:a)

    {

        result.add(getMedianAndAddNumber(maxHeap,minHeap,b));

    }

    return result;

    }    

public static double getMedianAndAddNumber(PriorityQueue<Integer>maxHeap,PriorityQueue<Integer>minHeap,int num){

        double med=0.0;

        if(maxHeap.size()==minHeap.size())

        {

            if(minHeap.size()==0||minHeap.peek()<num){

                minHeap.add(num);

                maxHeap.add(minHeap.remove());

            }

            else{

                maxHeap.add(num);

            }

            med=maxHeap.peek()*1.0;

        }

        else{

            if(minHeap.size()==0||maxHeap.peek()>num){

                maxHeap.add(num);

                minHeap.add(maxHeap.remove());

            }

            else{

                minHeap.add(num);

            }

            med=maxHeap.peek()/2.0+minHeap.peek()/2.0;

        }

        return med;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
