import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

/**
 * @author xstoop
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.jedis();
    }

    public void jedis() {
        // try () {} 自动资源模式，使用完成后会自动释放 resource

        // 使用连接池
        try (JedisPool jedisPool = new JedisPool("localhost", 6379)) {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.set("jedis", "111131231");
                jedis.expire("jedis", 100);
                System.out.println(jedis.get("jedis"));
                System.out.println(jedis.ttl("jedis"));
            }
        }

        try (JedisPooled jedisPooled = new JedisPooled("localhost", 6379)) {
            System.out.println(jedisPooled.get("jedis"));
            System.out.println(jedisPooled.ttl("jedis"));
        }
    }
}
