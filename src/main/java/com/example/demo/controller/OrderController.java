package com.example.demo.controller;


import com.example.demo.dto.request.UpdateOrderRequestDTO;
import com.example.demo.dto.responce.UpdateOrderResponseDTO;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/name/{name}")
    public String getByName(@PathVariable String name, Model model) {
        model.addAttribute("order", orderService.findByName(name));
        return "order/details-by-name";
    }

    @GetMapping("/address/{deliveryAddress}")
    public String getByDeliveryAddress(@PathVariable String deliveryAddress, Model model) {
        model.addAttribute("orders", orderService.countByDeliveryAddress(deliveryAddress));
        return "order/details-by-address";
    }

    @GetMapping("/price-address/{price}/{address}")
    public String getPriceWithDeliveryAddress(@PathVariable double price,
                                              @PathVariable(name = "address") String deliveryAddress,
                                              Model model) {
        model.addAttribute("order", orderService.findOrderByDeliveryAddressOrPrice(deliveryAddress, price));
        return "order/details-by-order";
    }


    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.findAll());

        return "order/all";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("orders", new Order());
        return "order/add-order";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        orderService.deleteById(id);

        return "redirect:/orders/all";
    }
    @PostMapping("delete/code/{uniqueCode}")
    public String deleteOrderByUniqueCode(@PathVariable String uniqueCode){
        orderService.deleteOrderByUniqueCode(uniqueCode);

        return "redirect:/orders/all";
    }


    @GetMapping("/{id}/edit-form")
    public String editPage(@PathVariable Long id, Model model){

        UpdateOrderResponseDTO order = orderService.findForUpdate(id);

        model.addAttribute("order", order);

        return "order/edit-form";
    }


    @PostMapping("/edit")
    public String edit( @ModelAttribute UpdateOrderRequestDTO dto){

        orderService.update(dto);

        return "redirect:/orders/all";
    }


    @GetMapping("{id}/edit-name-and-price")
    public  String editPage2(@PathVariable Long id, Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order", order);

        return "order/edit-name-and-price";
    }

    @PostMapping("/edit2")
    public  String edit2(@ModelAttribute Order order){
        orderService.updateNameAndPrice(order);
        return "redirect:/orders/all";

    }
   
}
