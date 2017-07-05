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
            int len = text.length();
            char firstChar = text.charAt(0);
            if(len > 1)
            {
                boolean isUpperCase = true;
                for(int i = 1; i < len; i++)
                {
                    char ch = text.charAt(i);
                    if(!Character.isUpperCase(ch))
                    {
                        isUpperCase = false;
                        break;
                    }
                }
                if(isUpperCase)
                {
                    boolean isFirstCharUpperCase = Character.isUpperCase(firstChar);
                    if(isFirstCharUpperCase)
                    {
                        out.print(text.toLowerCase());
                    }
                    else
                    {
                        out.print(Character.toUpperCase(firstChar) + text.substring(1).toLowerCase());
                    }
                }
                else
                {
                    out.print(text);
                }
            }
            else
            {
                if(Character.isUpperCase(firstChar))
                {
                    out.print(Character.toLowerCase(firstChar));
                }
                else
                {
                    out.print(Character.toUpperCase(firstChar));
                }
            }
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
