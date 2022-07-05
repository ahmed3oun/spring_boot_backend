package com.spring.recrutement.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.recrutement.Service.SiteRadioService;
import com.spring.recrutement.model.Document;
import com.spring.recrutement.model.Gouvernement;
import com.spring.recrutement.model.SiteRadio;
import com.spring.recrutement.payload.DocumentRequest;
import com.spring.recrutement.repo.DocumentRepo;
import com.spring.recrutement.repo.GouvernementRepo;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentRepo documentRepo;
    @Autowired
    private SiteRadioService siteRadioService;
    @Autowired
    private GouvernementRepo gouvernementRepo;

    private static final String DOC_ROOT_PATH = "C:/documents";

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocuments() {

        List<Document> Documents = documentRepo.findAll();
        return new ResponseEntity<>(Documents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable("id") Long id) {
        Document Document = documentRepo.findById(id).get();
        return new ResponseEntity<>(Document, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Document> addDocument(@RequestBody DocumentRequest document) {

        final Gouvernement _gouvernement = gouvernementRepo
                .findByNom(document.getGouvernement_nom()).get();
        final SiteRadio _siteRadio = siteRadioService.findSiteRadioById(document.getSiteRadio_id());
        _siteRadio.getCellules().forEach(_cellule -> {
            if (_cellule != null) {
                _cellule.setSiteRadio(null);
            }
        });
        final Document _document = new Document(_gouvernement, _siteRadio,
                document.getTypeDoc(), null);

        Document newDocument = documentRepo.save(_document);
        return new ResponseEntity<>(newDocument, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidature(@PathVariable("id") Long id) {
        documentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Document> updateUser(@RequestBody DocumentRequest doc ,
                 @PathVariable("id") Long id) {

        Gouvernement gouvernement =  gouvernementRepo.findByNom(doc.getGouvernement_nom()).get();
        SiteRadio siteRadio = siteRadioService.findSiteRadioById(doc.getSiteRadio_id());
        Document currentDocument = documentRepo.getById(id) ;
        currentDocument.setgouvernement(gouvernement);
        currentDocument.setSiteRadio(siteRadio);
        currentDocument.setTypeDoc(doc.getTypeDoc());
        Document updatedDoc = documentRepo.save(currentDocument);
      
        return new ResponseEntity<>(updatedDoc, HttpStatus.OK);
    }

    @PutMapping(value = "/updateDoc")
    public ResponseEntity<?> updateDocumentFileUrl(@RequestParam("doc") MultipartFile file,
            @RequestParam("doc_id") String id) throws IllegalStateException, IOException {
        Path filePath = Paths
                .get(DOC_ROOT_PATH + "/" + id + "/" + LocalDate.now().toString() + file.getOriginalFilename())
                .toAbsolutePath().normalize();
        System.out.println("file path ****  " + filePath.toString());
        Path fileStoragePath = Paths.get(DOC_ROOT_PATH + "/" + id).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file", e);
        }
        Document _doc = documentRepo.findById(Long.parseLong(id)).get();
        _doc.setFileUrl(
                filePath != null ? "/" + id + "/" + LocalDate.now().toString() + file.getOriginalFilename() : null);

        documentRepo.save(_doc);

        return new ResponseEntity<>("document file  is updated", HttpStatus.OK);
    }
}
