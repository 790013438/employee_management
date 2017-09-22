package snippets.jee.service.impl;

import java.util.HashMap;
import java.util.Map;

import snippets.jee.service.DeptService;
import snippets.jee.service.UserService;

public class ServiceFactory {

    private static Map<Class<?>, Object> map = new HashMap<>();

    static {
        map.put(UserService.class, new UserServiceImpl());
        map.put(DeptService.class, new DeptServiceImpl());
    }

    private ServiceFactory() {
        throw new AssertionError();
    }

    /**
     * 创建业务对象的工厂方法
     * @param type 业务对象的类型
     * @return 业务对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<?> type) {
        return (T) map.get(type);
    }
}
