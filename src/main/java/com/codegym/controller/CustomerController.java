package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

// đầu tiên @Controller rồi kiểm tra xem cấu hình đã thành công chưa
@Controller
@RequestMapping ("/customer")
public class CustomerController {

    // bình thường tạo new đối tượng, nhưng ở Spring lấy đối tượng mới thông qua bên AppConfiguration
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int)(Math.random()*1000));
        customerService.create(customer);
        redirect.addFlashAttribute("message", "Create Customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/change")
    public String change(Customer customer, RedirectAttributes redirect){
        customerService.edit(customer.getId(), customer);
        redirect.addFlashAttribute("message", "Change Customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/remove")
    public String remove(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("message", "Remove Customer sussessful!");
        return ("redirect:/customer");
    }




}
