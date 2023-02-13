/**
 * @author xstoop
 */
public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        // 多线程变量同步
        // 两个线程一个加一个减相同次数，结果几乎每次都不为0，（运行次数要足够大），并且每次结果都不同
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();

        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();

        System.out.println(count);
        // 原因是加与减的都不是原子操作，都可分成三步：获取变量、修改变量、写回变量。由于线程的运行是操作系统调度的。
        // 加线程获取到变量值后，可能就执行到减线程的获取值。那么这时两个线程获取到的值都一样比如100，在完成一次加减的操作后，值可能被更新成101，也可能被更新成99
        // 解决方案使用锁，在获取变量值前必须要持有锁，更新完成后释放锁。

    }

    public static int count = 0;

}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Thread2.count ++;
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Thread2.count --;
        }
    }
}