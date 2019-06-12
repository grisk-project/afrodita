package online.grisk.afrodita.controller;

import java.security.Principal;

import online.grisk.afrodita.controller.utils.ControllerUtils;
import online.grisk.afrodita.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login", method = GET)
    public String loginPage(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @RequestMapping(value = {"/", "/dashboard"}, method = GET)
    public String dashboardPage(HttpSession session, Model model, Principal principal) {
        try {
            model.addAttribute("title", "Dashboard");

            User user = ControllerUtils.getUserFromPrincipal(principal);
            session.setAttribute("user", userService.findByUsername(user.getUsername()));

            model.addAttribute("userInfo", ControllerUtils.toString(user));
        } catch (NullPointerException e) {
            System.out.println("The necessary permissions for this module have not been assigned");
        }
        return "dashboard";
    }

    @RequestMapping(value = {"/configuration"}, method = GET)
    public String configurationPage(Model model, Principal principal) {
        try {
            model.addAttribute("title", "Configuration");

            User user = ControllerUtils.getUserFromPrincipal(principal);

            model.addAttribute("userInfo", ControllerUtils.toString(user));
        } catch (NullPointerException e) {
            System.out.println("The necessary permissions for this module have not been assigned");
        }
        return "configuration";
    }

    @RequestMapping(value = {"/tree-business"}, method = GET)
    public String treeBusinessPage(Model model, Principal principal) {
        try {
            model.addAttribute("title", "Tree Business");
            User user = ControllerUtils.getUserFromPrincipal(principal);
            model.addAttribute("userInfo", ControllerUtils.toString(user));
        } catch (NullPointerException e) {
            System.out.println("The necessary permissions for this module have not been assigned");
        }
        return "tree-business";
    }

    @RequestMapping(value = {"/reports"}, method = GET)
    public String reportsPage(Model model, Principal principal) {
        try {
            model.addAttribute("title", "Reports");
            User user = ControllerUtils.getUserFromPrincipal(principal);
            model.addAttribute("userInfo", ControllerUtils.toString(user));
        } catch (NullPointerException e) {
            System.out.println("The necessary permissions for this module have not been assigned");
        }
        return "reports";
    }

    @RequestMapping(value = {"/403"}, method = GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User user = (User) ((Authentication) principal).getPrincipal();
            model.addAttribute("userInfo", ControllerUtils.toString(user));
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "403Page";
    }

}
