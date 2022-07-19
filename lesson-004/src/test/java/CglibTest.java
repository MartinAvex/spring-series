import com.xavier.TestService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {


    @Test
    public void test_01() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Call Method :" + method.getName());
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });
        TestService testService = (TestService) enhancer.create();
        String method_01 = testService.method_01();
        String method_02 = testService.method_02();

        System.out.println(method_01);
        System.out.println(method_02);
    }

    @Test
    public void test_02() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestService.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "METHOD";
            }
        });
        TestService testService = (TestService) enhancer.create();
        String method_01 = testService.method_01();
        String method_02 = testService.method_02();

        System.out.println(method_01);
        System.out.println(method_02);
    }

    @Test
    public void switch_01() {

    }

    public int switchMethod(String str) {
        switch (str) {
            case "1":
                System.out.println(str);
            case "1":
                return 2;
        }
    }


}
