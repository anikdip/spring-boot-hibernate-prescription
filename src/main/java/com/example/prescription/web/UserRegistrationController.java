package com.example.prescription.web;

import javax.validation.Valid;

import com.example.prescription.model.User;
import com.example.prescription.service.UserService;
import com.example.prescription.web.dto.UserRegistrationDto;
import com.example.prescription.web.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @ModelAttribute("userEdit")
    public UserUpdateDto userEditDto() {
        return new UserUpdateDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        try {
            User existing = userService.findByEmail(userDto.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "There is already an account registered with that email");
            }

            if (result.hasErrors()) {
                return "registration";
            }

            userService.save(userDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/userList?success";
    }

    @GetMapping("/editUserInfo/{id}")
    public String userEditForm(@PathVariable("id") long id, Model model){
        try {
            User user = userService.findById(id);

            model.addAttribute("userEdit", user);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "userEdit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("userEdit") @Valid UserUpdateDto userDto,
                             BindingResult result) {
        if (result.hasErrors()) {
//            userDto.setId(id);
            return "userEdit";
        }
        userService.save(userDto, id);

        return "redirect:/userList?updateSuccess";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/userList?delete";
    }

}
