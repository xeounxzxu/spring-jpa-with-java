package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Auth;
import io.gonzo.jpa.app.repository.AuthRepository;
import io.gonzo.jpa.app.web.dto.IOnlyAuthName;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthResource {

    public final AuthRepository repository;

    @GetMapping("")
    public List<Auth> showAuthList() {
        return repository.findAll();
    }

    @GetMapping("/{authName}")
    public Collection<IOnlyAuthName> showAuthList(@PathVariable String authName) {
        return repository.findByAuthName(authName, IOnlyAuthName.class);
    }

    @GetMapping("/exc")
    public void showExc(){
        throw new NullPointerException();
    }

}