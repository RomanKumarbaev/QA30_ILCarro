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
        list.add(new Object[] {"wew@gmail.com","Ar12345$"});
        list.add(new Object[] {"wew@gmail.com","Ar12345$"});


        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> loginModel(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {new User().withEmail("wew@gmail.com").withPassword("Ar12345$")});
        list.add(new Object[] {new User().withEmail("wew@gmail.com").withPassword("Ar12345$")});
        return list.iterator();

    }
}
