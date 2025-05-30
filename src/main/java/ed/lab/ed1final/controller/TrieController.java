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
        try {
            CreateTrieRequest request;
            if (word == null || word.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            trieService.insertWord(word.toLowerCase());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{word}/count")
    public ResponseEntity<WordCountResponse> countWord(@PathVariable String word) {
        try {
            int count = trieService.countWordsEqualTo(word.toLowerCase());
            WordCountResponse response = new WordCountResponse(word, count);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/{prefix}/prefix")
    public ResponseEntity<PrefixCountResponse> countPrefix(@PathVariable String prefix) {
        try {
            int count = trieService.countWordsStartingWith(prefix.toLowerCase());
            PrefixCountResponse response = new PrefixCountResponse(prefix, count);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
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
