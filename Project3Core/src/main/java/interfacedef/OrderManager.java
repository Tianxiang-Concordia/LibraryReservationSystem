package interfacedef;

import pojo.Order;

import java.util.ArrayList;

public interface OrderManager {

    public int createOrder(long pickupDate, int bookId, int userId);

    public boolean changeOrderStatus(int orderId, String status);

    public boolean changeOrderByUser(int orderId, int userId);

    public boolean changePickupDate(int orderId, long pickupDate);

    public boolean changePickupDateByUser(int orderId, long pickupDate, int userId);

    public ArrayList<Order> getMyOrder(int userId);

    public ArrayList<Order> getAllOrder();

    public boolean sendReadyEmail(int orderId);
}

