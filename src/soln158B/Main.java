import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve( in , out);
        out.close();
    }

    static class Task
    {
        public void solve(InputReader in , PrintWriter out)
        {
            int len = in .nextInt();
            int[] arr = new int[len];
            HashMap < Integer, Integer > occurrences = new HashMap < Integer, Integer > ();
            for (int i = 0; i < len; i++)
            {
                arr[i] = in .nextInt();
                int val = 1;
                if (occurrences.containsKey(arr[i]))
                {
                    val = occurrences.get(arr[i]);
                    val++;
                }
                occurrences.put(arr[i], val);
            }
            Arrays.sort(arr);
            int taxiCount = 0;
            for (int i = len - 1; i >= 0; i--)
            {
                int value = arr[i];
                int keyValue = occurrences.get(value);

                if (keyValue == 0)
                {
                    continue;
                }
                taxiCount++;
                occurrences.put(value, --keyValue);
                if (value != 4)
                {
                    int sum = value;
                    int tempSum = sum;
                    while (sum != 4 && (4 - tempSum) > 0)
                    {
                        int index = binarySearch(arr, 0, len-1, (4 - tempSum), occurrences);
                        if (index == -1)
                        {
                            tempSum++;
                            continue;
                        }
                        sum += arr[index];
                        tempSum = sum;
                    }
                }
            }
            out.print(taxiCount);
        }

        public static int binarySearch(int[] arr, int low, int high, int element, HashMap < Integer, Integer > occurrences) {
            if (low <= high)
            {
                int mid = (low + high) / 2;
                if (arr[mid] == element)
                {
                    int keyValue = occurrences.get(element);
                    if (keyValue != 0)
                    {
                        occurrences.put(element, --keyValue);
                        return mid;
                    }
                    else
                    {
                        return -1;
                    }
                }
                else if (arr[mid] > element)
                {
                    return binarySearch(arr, low, mid - 1, element, occurrences);
                }
                return binarySearch(arr, mid + 1, high, element, occurrences);
            }
            return -1;
        }

    }

    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream)
        {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next()
        {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = reader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
}
