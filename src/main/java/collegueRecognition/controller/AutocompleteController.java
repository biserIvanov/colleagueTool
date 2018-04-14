package collegueRecognition.controller;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.AjaxResponseBody;
import collegueRecognition.entities.SearchCriteria;
import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AutocompleteController {

    @Autowired
    private UserRepository repository;


    @PostMapping("/autocomplete/username")
    public ResponseEntity<?> getUserName(
            @Valid @RequestBody SearchCriteria search, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<User> users = repository.findByUserNameStartsWith(search.getUsername());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);
    }
}
