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
            String text = in.next();
            char first = text.charAt(0);

            if(first >= 97)
            {
                first = (char) (first - 32);
                int len = text.length();
                if(len > 1)
                {
                    out.print(first + text.substring(1, len));
                }
                else{
                    out.print(first);
                }

                return;
            }

            out.print(text);
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

        public float nextFloat()
        {
            return Float.parseFloat(next());
        }

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

    }
}
