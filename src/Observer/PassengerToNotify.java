package Observer;
/*
This class is for notifying the Passenger whenever a flight is modified by the admin.

This addPassengerToNotify method takes Flight  number and passenger ID as input, adds them into a list to notify.

The removePassengerToNotify method returns the list of passenger IDs and removes them from ToNotify.
 */
import java.util.*;

public class PassengerToNotify{
   private final List<List<Integer>> link1=new ArrayList<>();

    public void addPassengerToNotify(Integer flight_number,Integer passenger_id)
    {
        final List<Integer> link2=new ArrayList<>(2);
        link2.add(flight_number);
        link2.add(passenger_id);
        link1.add(link2);
    }

    public int removePassengerToNotify(int flight_number,int passenger_id)
    {
        for (int i=0;i<link1.size();i++)
        {
            if( link1.get(i).get(0) == flight_number && link1.get(i).get(1) == passenger_id )
            {
                link1.remove(i);
                return 1;
            }
        }
        return  0;
    }
}
