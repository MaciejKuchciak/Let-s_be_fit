package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.UserService;

@Controller
@RequestMapping("details")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;
    private final UserService userService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping("")
    public String userDetails(Model model) {
        User user = userService.getByLogin(SecurityUtils.login());
        User userId = userService.get(user.getId());
        model.addAttribute("userId",userId);
        UserDetails userDetails = userDetailsService.getUserDetailsByUserLogin(SecurityUtils.login());
        model.addAttribute("newUserDetails", new UserDetails());
        model.addAttribute("userDetails", userDetails);
        int numberOfUserDetails = userDetailsService.userDetailsQuantity(SecurityUtils.login());
        model.addAttribute("numberOfUserDetails",numberOfUserDetails);
        return "details";
    }

    @PostMapping("")
    public String addUserDetails(UserDetails userDetails){
        userDetailsService.add(userDetails);
        return "redirect:/dashboard";
    }

}
