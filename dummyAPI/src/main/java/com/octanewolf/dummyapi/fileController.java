package com.octanewolf.dummyapi;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class fileController {
    @ApiOperation("Create a text file")
    @PostMapping("/create")
    public ResponseEntity<String> createTextFile(
            @RequestBody String content,
            @RequestHeader("file-name") String fileName,
            @RequestHeader("directory") String directoryPath) {
        try {
            String filePath = directoryPath + fileName;
            Files.write(Paths.get(filePath), content.getBytes());
            return new ResponseEntity<>("File created successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error creating the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTextFile(
            @RequestHeader("file-name") String fileName,
            @RequestHeader("directory") String directoryPath) {
        try {
            String filePath = directoryPath + fileName;
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Files.delete(path);
                return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error deleting the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<String> readTextFile(
            @RequestHeader("file-name") String fileName,
            @RequestHeader("directory") String directoryPath) {
        try {
            String filePath = directoryPath + fileName;
            if (Files.exists(Paths.get(filePath))) {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                return new ResponseEntity<>(content, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error reading the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<String[]> listFilesInDirectory(
            @RequestHeader("directory") String directoryPath) {
        try {
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                String[] files = directory.list();
                return new ResponseEntity<>(files, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new String[] {"Directory not found"}, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new String[] {"Error listing files"}, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}