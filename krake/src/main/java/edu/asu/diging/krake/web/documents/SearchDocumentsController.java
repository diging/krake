package edu.asu.diging.krake.web.documents;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchDocumentsController {

    @RequestMapping(value="/auth/documents/add", method = RequestMethod.GET)
    public String showSearch(Model model) {
        model.addAttribute("searchDocumentBean", new SearchDocumentBean());
        return "auth/documents/add";
    }
}
