package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginDto() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[] {"wew@gmail.com","Ar12345$"});
        list.add(new Object[] {"shr2285@gmail.com","Df12345$"});
        list.add(new Object[] {"shr2287@gmail.com","Df12345$"});

        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> loginModel(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {new User().withEmail("wew@gmail.com").withPassword("Ar12345$")});
        list.add(new Object[] {new User().withEmail("shr2287@gmail.com").withPassword("Df12345$")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationPositiveModel(){

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {new User().withName("Lis").withLastname("Show").withEmail("shr" + i + "@gmail.com").withPassword("Df12345$")});
        list.add(new Object[] {new User().withName("Vova").withLastname("Zalo").withEmail("gfd" + i + "@gmail.com").withPassword("Df12345$")});
        list.add(new Object[] {new User().withName("David").withLastname("SJas").withEmail("trw" + i + "@gmail.com").withPassword("Df12345$")});
        list.add(new Object[] {new User().withName("Luna").withLastname("Poid").withEmail("pqo" + i + "@gmail.com").withPassword("Df12345$")});
        list.add(new Object[] {new User().withName("Lina").withLastname("Luda").withEmail("qag" + i + "@gmail.com").withPassword("Df12345$")});
        list.add(new Object[] {new User().withName("Zevs").withLastname("Ult").withEmail("zzxc" + i + "@gmail.com").withPassword("Df12345$")});

        return list.iterator();
    }
}
