import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class PrimeComparison {

    /* -------------------- 朴素试除法 -------------------- */

    // 最基础的 isPrime：只试到 sqrt(n)，跳过偶数，并用 6k±1 小优化
    static boolean isPrimeTrial(int x) {
        if (x < 2) return false;
        if (x == 2 || x == 3) return true;
        if ((x & 1) == 0 || x % 3 == 0) return false;
        int r = (int) Math.sqrt(x);
        // 只检查形如 6k±1 的数
        for (int i = 5; i <= r; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0) return false;
        }
        return true;
    }

    static List<Integer> listPrimesTrial(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n >= 2) primes.add(2);
        for (int x = 3; x <= n; x += 2) {
            if (isPrimeTrial(x)) primes.add(x);
        }
        return primes;
    }

    /* -------------------- 埃拉托斯特尼筛法（奇数优化） -------------------- */

    static List<Integer> sievePrimes(int n) {
        // 用 BitSet 节省内存与更快的位操作（false=可能是素数）
        BitSet composite = new BitSet(n + 1);
        List<Integer> primes = new ArrayList<>();
        if (n >= 2) primes.add(2);

        int limit = (int) Math.sqrt(n);
        // 只处理奇数 i
        for (int i = 3; i <= limit; i += 2) {
            if (!composite.get(i)) {
                // 从 i*i 开始标记，且只标记奇数位：步长 2*i
                long start = 1L * i * i; // 防止溢出
                for (long j = start; j <= n; j += (i << 1)) {
                    composite.set((int) j);
                }
            }
        }
        for (int i = 3; i <= n; i += 2) {
            if (!composite.get(i)) primes.add(i);
        }
        return primes;
    }

    /* -------------------- 打印：每行 5 个 -------------------- */

    static void printFivePerLine(List<Integer> primes) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int p : primes) {
            sb.append(String.format("%6d", p));
            cnt++;
            if (cnt == 5) {
                System.out.println(sb.toString());
                sb.setLength(0);
                cnt = 0;
            }
        }
        if (cnt != 0) System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        final int N = 20000;

        // 简单的 JIT 预热（可选）：避免第一次调用偏慢影响计时
        for (int i = 0; i < 3; i++) {
            listPrimesTrial(10000);
            sievePrimes(10000);
        }

        long t0 = System.nanoTime();
        List<Integer> primesTrial = listPrimesTrial(N);
        long t1 = System.nanoTime();

        long t2 = System.nanoTime();
        List<Integer> primesSieve = sievePrimes(N);
        long t3 = System.nanoTime();

        // 按题意，用筛法结果打印（避免双倍输出）
        printFivePerLine(primesSieve);

        System.out.printf("%nCount (trial) = %d, elapsed = %.3f ms%n",
                primesTrial.size(), (t1 - t0) / 1e6);
        System.out.printf("Count (sieve) = %d, elapsed = %.3f ms%n",
                primesSieve.size(), (t3 - t2) / 1e6);
    }
}
