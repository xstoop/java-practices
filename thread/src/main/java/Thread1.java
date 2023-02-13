/**
 * @author xstoop
 */
public class Thread1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main run ");

        Thread1 main = new Thread1();
        // 启动线程
//        main.run();
        // 等待某个线程结束运行
//        main.join();
        // 线程状态
//        main.state();
        // 线程状态
//        main.interrupted();
        // 守护线程
//        main.daemonThread();

        System.out.println("main end ");
    }

    /**
     * 启动线程
     */
    public void run() {
        // 1.lambda 形式
        Thread thread = new Thread(() -> {
            System.out.println("thread run");
            System.out.println("thread end");
        });
        // 启动线程
        thread.start();

        // 2.使用实现 Runnable 实现类初始化
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        // 3.匿名类方式实现 Runnable 接口
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread2 run");
                System.out.println("thread2 end");
            }
        };
        thread2.start();

        // 4.通过继承 thread 并实现 run 方法
        MyThread myThread = new MyThread();
        myThread.start();
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("thread MyRunnable run ");
            System.out.println("thread MyRunnable end ");
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread MyThread run");
            System.out.println("thread MyThread end");
        }
    }

    /**
     * join()    等待某个线程结束运行，才继续运行自身线程
     * join(100) 等待指定时间
     */
    public void join() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 run");
            System.out.println("thread1 end");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 run");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread2 end");
        });

        thread1.start();
        thread2.start();

        thread1.join(); // main 线程等待 thread1 执行完成 , 如果在等待过程中有其他线程对main线程调用interrupt(),会抛出 InterruptedException 异常
        thread2.join(10); // main 线程等待 thread2 执行 10 ms
    }

    /**
     * 线程状态
     */
    public void state() {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 run");
            System.out.println("thread1 end");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 run");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread2 end");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 run");
            System.out.println("thread3 end");
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("thread4 run");
            System.out.println("thread4 end");
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // 线程的状态
        // NEW 新建线程；
        // RUNNABLE 运行中的线程；
        // BLOCKED 运行中的线程，被某些操作阻塞而挂起；
        // WAITING 运行中的线程，因为某些操作在等待中；
        // TIMED_WAITING 运行中的线程 正在执行sleep方法正在计时等待；
        // TERMINATED 线程已终止运行；

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        System.out.println(thread3.getState());
        System.out.println(thread4.getState());
    }

    /**
     * 线程中断，中断其他线程
     */
    public void interrupted() {
        // 1. 通过调用线程的 interrupt() 方法打断线程，需要线程通过 isInterrupted() 判断打断的状态来响应打断
        // 调用 interrupt() 会让其他线程对该线程调用的 join() 以及该线程内的 sleep() 方法立刻抛出 InterruptedException 异常
        // 也就是线程内的join() 与 sleep() 都通过 isInterrupted() 判断了打断状态
        Thread thread = new Thread() {
            @Override
            public void run() {
                int n = 0;
                while (!isInterrupted()) {
                    n++;
                    System.out.println("hello " + n);
                }
                System.out.println("thread  isInterrupted! ");
            }
        };

        thread.start();
        // sleep 避免 thread 还没运行就被打断了。看不到运行效果
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("join InterruptedException");
        }

        // 2. 通过线程间共享变量来实现打断：共享变量要使用关键字 volatile 修饰。以确保每个线程读到的都是最新的值
        // 在java 的虚拟机中，变量是存放在主内存中的，线程获取变量时是从主内存中拷贝一份，修改变量时再将变量写回主内存。
        // 可能某个线程修改在写入前值已经被其他线程读取到了旧的值，使用 volatile 可确保总是获取主内存中最新的值，每次修改该变量，立刻写入主内存

        MyThread1 thread1 = new MyThread1();

        thread1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.running = false;
    }

    class MyThread1 extends Thread {

        public volatile boolean running = true;

        @Override
        public void run() {
            int n = 0;
            while (running) {
                n ++;
                System.out.println("MyThread1 running: n is " + n);
            }
            System.out.println("MyThread1 running is end " + n);
        }
    }

    /**
     * 守护线程
     */
    public void daemonThread() {
        // 当所有线程都运行结束时，JVM就会退出，进程结束
        // 但某些线程的目的就是一直运行，无限循环，比如某些需隔一段时间运行的任务，当有这种线程存在时，JVM就永远不会退出
        // 就可以使用守护线程来实现。当没有其他非守护线程运行时，JVM就会直接退出，守护线程也就直接被结束了
        // 守护线程不能持有任何需要关闭的资源，否则在JVM退出时资打开的资源没有关闭的机会

        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("daemonThread run ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        // thread 直接被关闭
    }
}
