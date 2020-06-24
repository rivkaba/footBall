package rivkaba.com;

import java.util.List;

public class Day {
    private List <Hour> hours;
    public Day(){}
    protected List <Hour> hour()
    {
        return hours;
    }
    protected void addHour(Hour h)
    {
        //להכניס לפי הסדר
        hours.add(h);
    }
    protected void deliteHour(Hour h)
    {
        Hour h1;
        // h1=hours(0);
         Hour h2;
       //  while (h1.getHour()<h.getHour())
            // h1.next;

    }



}
