package com.sportyshoes.sportyshoes.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.sportyshoes.sportyshoes.db.DB;
import com.sportyshoes.sportyshoes.model.Order;
import com.sportyshoes.sportyshoes.model.Shoe;
import com.sportyshoes.sportyshoes.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController {
    DB db = DB.getInstance();

    public OrderController() {
    }

    @GetMapping({"/place-order"})
    public ModelAndView placeOrder(HttpSession session) {
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.orderId = this.db.orderList.size() + 1;
        order.shoes = new ArrayList();
        order.shoes.addAll(this.db.cartList);
        order.productImage = ((Shoe)order.shoes.get(0)).image;
        int total = 0;

        Shoe shoe;
        for(Iterator var5 = this.db.cartList.iterator(); var5.hasNext(); total += shoe.price) {
            shoe = (Shoe)var5.next();
        }

        order.orderPrice = total;
        order.createdOn = new Date();
        order.userEmail = user.email;
        this.db.orders.put(order.orderId, order);
        this.db.orderList.add(order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success.html");
        modelAndView.addObject("message", "Order Placed Successfully with ID: " + order.orderId);
        this.db.cartList.clear();
        return modelAndView;
    }

    @GetMapping({"/orders"})
    public ModelAndView fetchOrders(HttpSession session) {
        User user = (User)session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders.html");
        modelAndView.addObject("user", user);
        List<Order> orders = new ArrayList();
        Iterator var5 = this.db.orderList.iterator();

        while(var5.hasNext()) {
            Order order = (Order)var5.next();
            if (order.userEmail.equals(user.email)) {
                orders.add(order);
            }
        }

        modelAndView.addObject("total", orders.size());
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping({"/get-orders"})
    public LinkedHashMap<String, Object> getSOrders() {
        LinkedHashMap<String, Object> response = new LinkedHashMap();
        response.put("code", 101);
        response.put("message", this.db.orderList.size() + " Orders Fetched Successfully.");
        response.put("shoes", this.db.orderList);
        return response;
    }
}
