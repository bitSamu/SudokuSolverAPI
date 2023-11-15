package com.github.bitsamu.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bitsamu.solver.SudokuSolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

// http://localhost:8080/api/processArray?board=%5B%5B%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%228%22%2C%220%22%2C%225%22%2C%220%22%5D%2C%5B%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%2C%229%22%2C%226%22%2C%220%22%5D%2C%5B%220%22%2C%220%22%2C%226%22%2C%220%22%2C%225%22%2C%220%22%2C%220%22%2C%224%22%2C%220%22%5D%2C%5B%228%22%2C%227%22%2C%220%22%2C%221%22%2C%222%22%2C%220%22%2C%220%22%2C%220%22%2C%220%22%5D%2C%5B%220%22%2C%223%22%2C%220%22%2C%220%22%2C%220%22%2C%227%22%2C%220%22%2C%220%22%2C%229%22%5D%2C%5B%220%22%2C%220%22%2C%220%22%2C%229%22%2C%226%22%2C%223%22%2C%220%22%2C%220%22%2C%228%22%5D%2C%5B%220%22%2C%224%22%2C%220%22%2C%225%22%2C%223%22%2C%220%22%2C%227%22%2C%228%22%2C%220%22%5D%2C%5B%227%22%2C%220%22%2C%228%22%2C%220%22%2C%221%22%2C%220%22%2C%223%22%2C%220%22%2C%220%22%5D%2C%5B%220%22%2C%225%22%2C%220%22%2C%220%22%2C%228%22%2C%220%22%2C%224%22%2C%220%22%2C%222%22%5D%5D
@RestController
@RequestMapping("/api")
public class SudokuController {
    private SudokuSolver solver = new SudokuSolver();

    @GetMapping("/getSolvedBoard")
    public ResponseEntity<Integer[][]> getSolvedBoard(@RequestParam String board) {
        // Decode the URL-encoded JSON string
        String decodedBoard = URLDecoder.decode(board, StandardCharsets.UTF_8);

        // Deserialize the JSON string into a 2D array
        ObjectMapper objectMapper = new ObjectMapper();
        Integer[][] inputArray;
        try {
            inputArray = objectMapper.readValue(decodedBoard, Integer[][].class);
        } catch (JsonProcessingException e) {
            // Handle exception
            return ResponseEntity.badRequest().build();
        }

        // Your logic to process the 2D array goes here
        Integer[][] processedArray = processSudokuBoard(inputArray);

        // For testing, returning the processed array
        return ResponseEntity.ok(processedArray);
    }

    private Integer[][] processSudokuBoard(Integer[][] inputArray) {
        solver.solveBoard(inputArray);
        System.out.println("Hallo");
        return solver.getSolvedBoard();
    }
}
