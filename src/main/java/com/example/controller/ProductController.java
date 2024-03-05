package com.example.controller;

import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.example.rest.controller.ProductsApi;
import org.example.rest.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDto> getProduct(Long id) {
        return ResponseEntity.of(productService.findProduct(id));
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }


    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
//        Thread.sleep(20000);
        return ResponseEntity.ok(productService.getProducts());
    }

    @Override
    public ResponseEntity<ProductDto> modifyProduct(Long id, ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @Override
    public ResponseEntity<ProductDto> modifyProductPartially(Long id, ProductDto productDto) {
        return ResponseEntity.ok(productService.patchProduct(id,productDto));
    }
//    @GetMapping("")
//    public ResponseEntity<List <CarDTO>> getCars(){
//        return ResponseEntity.ok(service.getAll());
//    }
//
//    @PostMapping("")
//    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO car) throws MessagingException, IOException {
//        CarDTO savedCar = service.create(car);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCar.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(savedCar);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> removeCar(@PathVariable int id){
//        try {
//            service.deleteCar(id);
//            return ResponseEntity.accepted().build();
//        }catch (RuntimeException | MessagingException | IOException e){
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//    @PostMapping("/photo")
//    public ResponseEntity<CarDTO> uploadPhoto(@RequestParam("photo") MultipartFile photo, @RequestParam String model, @RequestParam String producer, @RequestParam int power) throws IOException {
//
//        String originalFilename  = photo.getOriginalFilename();
//
//        File fileForPhotos = new File(System.getProperty("user.home") + File.separator + "images" + File.separator + photo.getOriginalFilename());
//
//        photo.transferTo(fileForPhotos);
//
//        return ResponseEntity.ok(uploadPhotoService.download(originalFilename ,model,producer,power));
//    }
}
