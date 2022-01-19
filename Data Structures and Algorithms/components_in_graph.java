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
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here
     
        int[] parents=new int[30002];

    int[] size= new int[30002];

    int m=0;

    for(List<Integer>li:gb)

    {

        m=Math.max(li.get(0),m);

        m=Math.max(li.get(1),m);

        parents[li.get(0)]=li.get(0);

        parents[li.get(1)]=li.get(1);

        size[li.get(0)]=1;

        size[li.get(1)]=1;

    }

    for(List<Integer>li:gb){

        union(li.get(0),li.get(1),parents,size);

    }   int min=30002;

    int max=0;

    for(int i=1;i<m;i++){

        int k=find(i,parents);

        if(size[k]<2)

        continue;

        min=Math.min(size[k],min);

        max=Math.max(size[k],max);

    }  List<Integer>res=new ArrayList();

    res.add(min);

    res.add(max);

    return res;

    }

    public static void union(int a,int b,int[]parents,int[]size){

        int x=find(a,parents);

        int y=find(b,parents);

        if(x!=y){

            if(size[x]>size[y]){

                parents[y]=x;

                size[x]+=size[y];

            }else{

                parents[x]=y;

                size[y]+=size[x];

            }

        }

    }

    public static int find(int a,int[]parents){

        while(a!=parents[a]){

            a=parents[a];

        }

        return a;
          
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.componentsInGraph(gb);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
