package ed.lab.ed1final.controller;

import ed.lab.ed1final.model.CreateTrieRequest;
import ed.lab.ed1final.model.PrefixCountResponse;
import ed.lab.ed1final.model.WordCountResponse;
import ed.lab.ed1final.service.TrieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trie")
public class TrieController {

    private final TrieService trieService;

    public TrieController(TrieService trieService) {
        this.trieService = trieService;
    }

    @PostMapping("/{word}")
    public ResponseEntity<Void> addWord(@PathVariable String word) {
        if (!word.matches("[a-z]+")) {
            return ResponseEntity.badRequest().build();
        }
        trieService.insertWord(word);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{word}/count")
    public ResponseEntity<WordCountResponse> countWord(@PathVariable String word) {
        if (!word.matches("[a-z]+")) {
            return ResponseEntity.badRequest().build();
        }
        int count = trieService.countWordsEqualTo(word);
        return ResponseEntity.ok(new WordCountResponse(word, count));
    }

    @GetMapping("/{prefix}/prefix")
    public ResponseEntity<PrefixCountResponse> countPrefix(@PathVariable String prefix) {
        if (!prefix.matches("[a-z]+")) {
            return ResponseEntity.badRequest().build();
        }
        int count = trieService.countWordsStartingWith(prefix);
        return ResponseEntity.ok(new PrefixCountResponse(prefix, count));
    }



    @DeleteMapping("/{word}")
    public ResponseEntity<Void> eraseWord(@PathVariable String word) {
        try {
            trieService.erase(word.toLowerCase());
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
