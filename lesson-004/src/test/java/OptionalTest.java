import com.xavier.entity.Address;
import com.xavier.entity.Man;
import com.xavier.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void optional() {
        Person person = null;
        String province = Optional.ofNullable(person).map(Person::getAddress).map(Address::getProvince).orElse(null);
        System.out.println(province);
    }

    @Test
    public void list() {
        ArrayList<Object> people = new ArrayList<>();
        Address address = Address.builder().id(1L).area("WuHan").province("HuBei").build();
        Person person = Person.builder().name("person").address(address).build();
        Man man = new Man("Xavier", address, "man");
        people.add(man);
        people.add(person);
        people.forEach(System.out::println);

        Object person1 = people.get(0);
        Object person2 = people.get(1);

        System.out.println(person1);
        System.out.println(person2);

        if (person1 instanceof Man) {
            System.out.println(person1);
        }

        Object o = new Object();
        System.out.println(o);

    }

}
