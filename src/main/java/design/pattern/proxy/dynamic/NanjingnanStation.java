package design.pattern.proxy.dynamic;

import design.pattern.proxy.dynamic.model.StationPort;
import design.pattern.proxy.dynamic.model.TravelPorts;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author: Q-WHai
 * @Date: Created in 10:49 2019/04/10
 */
public class NanjingnanStation implements IStation {

    private Logger logger = Logger.getLogger(NanjingnanStation.class);

    private Map<TravelPorts, Integer> _ticketSurplus = new HashMap<TravelPorts, Integer>() {
        {
            put(new TravelPorts("南京", "上海虹桥"), 10);
            put(new TravelPorts("南京南", "上海虹桥"), 60);
            put(new TravelPorts("武汉", "长沙"), 23);
        }
    };

    private DecimalFormat df = new DecimalFormat("######0.00");
    @Override
    public double ticketPrice(StationPort from, StationPort to) {

        double price = ticketMap.get(new TravelPorts(from.getName(), to.getName()));
        logger.info(String.format("从 %s 到 %s 的票价为：%s", from, to, df.format(price)));

        return price;
    }

    @Override
    public int ticketSurplus(StationPort from, StationPort to) {
        return _ticketSurplus.get(new TravelPorts(from.getName(), to.getName()));
    }

    @Override
    public void amendTicketSurplus(StationPort from, StationPort to) {
        _ticketSurplus.replace(new TravelPorts(from.getName(), to.getName()), 0);
    }

    @Override
    public boolean booking(StationPort from, StationPort to) {
        _ticketSurplus.replace(new TravelPorts(from.getName(), to.getName()), _ticketSurplus.get(new TravelPorts(from.getName(), to.getName())) - 1);
        logger.info(String.format("南京南站正在出票，从 %s 到 %s，余票：%d", from, to, ticketSurplus(from, to)));

        return true;
    }
}
