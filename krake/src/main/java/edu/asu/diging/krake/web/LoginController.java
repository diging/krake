package edu.asu.diging.krake.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.krake.users.IUserManager;
import edu.asu.diging.krake.users.User;

@Controller
public class LoginController {
 
    @Autowired
    private IUserManager userManager;
    
    @RequestMapping(value = "/")
    public String login(Principal principal, Model model) {

        String username = null;
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
            if (token.getPrincipal() instanceof User) {
                username = ((User) token.getPrincipal()).getUsername();
            } else if (token.getPrincipal() instanceof UserDetails) {
                username = ((UserDetails) token.getPrincipal()).getUsername();
            }
        }

        
        return "login";
    }
    
    @RequestMapping("/403")
    public String accessForbidden() {
        return "403";
    }

}
