package com.sportyshoes.sportyshoes.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;

import com.sportyshoes.sportyshoes.db.DB;
import com.sportyshoes.sportyshoes.model.Shoe;
import com.sportyshoes.sportyshoes.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShoeController {
    DB db = DB.getInstance();

    public ShoeController() {
    }

    @GetMapping({"/shoes"})
    public ModelAndView fetchShoes(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("shoes.html");
        modelAndView.addObject("shoes", this.db.shoesList);
        return modelAndView;
    }

    @GetMapping({"/cart"})
    public ModelAndView cart(HttpSession session) {
        User user = (User)session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart.html");
        int total = 0;

        Shoe shoe;
        for(Iterator var5 = this.db.cartList.iterator(); var5.hasNext(); total += shoe.price) {
            shoe = (Shoe)var5.next();
        }

        modelAndView.addObject("total", total);
        modelAndView.addObject("user", user);
        modelAndView.addObject("shoes", this.db.cartList);
        return modelAndView;
    }

    @GetMapping({"/add-to-cart"})
    public ModelAndView addToCart(@RequestParam(name = "id") Integer shoeId, HttpSession session) {
        System.out.println("ID: " + shoeId);
        this.db.cartList.add((Shoe)this.db.shoes.get(shoeId));
        System.out.println(this.db.shoes.get(shoeId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success.html");
        modelAndView.addObject("message", "Shoe " + ((Shoe)this.db.shoes.get(shoeId)).name + " Added Successfully to Cart");
        return modelAndView;
    }

    @GetMapping({"/view-shoe"})
    public ModelAndView viewShoe(@RequestParam(name = "id") Integer shoeId, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Shoe shoe = (Shoe)this.db.shoes.get(shoeId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("shoe", shoe);
        modelAndView.setViewName("shoe.html");
        return modelAndView;
    }

    @PostMapping({"/add-shoe"})
    public LinkedHashMap<String, Object> addShoe(@RequestParam(name = "id") Integer id, @RequestParam(name = "image") String image, @RequestParam(name = "name") String name, @RequestParam(name = "category") String category, @RequestParam(name = "sizes") String sizes, @RequestParam(name = "price") Integer price, HttpSession session) {
        Shoe shoe = new Shoe(id, image, name, category, sizes, price);
        this.db.shoes.put(id, shoe);
        this.db.shoesList.add(shoe);
        LinkedHashMap<String, Object> response = new LinkedHashMap();
        response.put("code", 101);
        response.put("message", shoe.name + " Added Successfully.");
        response.put("shoe", shoe);
        return response;
    }

    @PutMapping({"/update-shoe"})
    public LinkedHashMap<String, Object> updateShoe(@RequestParam(name = "id") Integer id, @RequestParam(name = "image") String image, @RequestParam(name = "name") String name, @RequestParam(name = "category") String category, @RequestParam(name = "sizes") String sizes, @RequestParam(name = "price") Integer price, HttpSession session) {
        Shoe shoe = new Shoe(id, image, name, category, sizes, price);
        this.db.shoes.put(id, shoe);

        for(int idx = 0; idx < this.db.shoesList.size(); ++idx) {
            if (((Shoe)this.db.shoesList.get(idx)).id == id) {
                this.db.shoesList.set(idx, shoe);
                break;
            }
        }

        LinkedHashMap<String, Object> response = new LinkedHashMap();
        response.put("code", 101);
        response.put("message", shoe.name + " Updated Successfully.");
        response.put("shoe", shoe);
        return response;
    }

    @DeleteMapping({"/delete-shoe"})
    public LinkedHashMap<String, Object> deleteShoe(@RequestParam(name = "id") Integer id) {
        LinkedHashMap<String, Object> response = new LinkedHashMap();
        this.db.shoes.remove(id);

        for(int idx = 0; idx < this.db.usersList.size(); ++idx) {
            if (((Shoe)this.db.shoesList.get(idx)).id == id) {
                this.db.shoesList.remove(idx);
                break;
            }
        }

        response.put("code", 101);
        response.put("message", "Shoe with ID " + id + " Deleted Successfully.");
        return response;
    }

    @GetMapping({"/get-shoes"})
    public LinkedHashMap<String, Object> getShoes() {
        LinkedHashMap<String, Object> response = new LinkedHashMap();
        response.put("code", 101);
        response.put("message", this.db.shoesList.size() + " Shoes Fetched Successfully.");
        response.put("shoes", this.db.shoesList);
        return response;
    }
}
