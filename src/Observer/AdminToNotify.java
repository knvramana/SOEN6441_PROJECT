package Observer;
/*
This class is for notifying the Admin whenever a new booking is made by the passenger.

This ToNotify method takes Flight  number and passenger ID as input, adds them into a list to notify.

The AfterNotify method returns the list of passenger IDs and removes them from ToNotify.
 */
import java.util.ArrayList;
import java.util.List;

public class AdminToNotify {
    private final List<List<Integer>> link1=new ArrayList<>();

    public void ToNotify(Integer flight_number,Integer passenger_id)
    {
        final List<Integer> link2=new ArrayList<>(2);
        link2.add(flight_number);
        link2.add(passenger_id);
        link1.add(link2);
    }
    public List<List<Integer>> AfterNotify()
    {
        List<List<Integer>> link2=new ArrayList<>(link1);
        link1.removeAll(link1);
        return  link2;
    }
}





