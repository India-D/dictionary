package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
// mapping =
public class InvoiceController {
    // @GetMapping("/hello")
    // public String hello() {
    // return "Hello world";
    // }
    //
    // @GetMapping("/greetings")
    // public ArrayList<String> greetings() {
    // ArrayList<String> greetings = new ArrayList<>();
    // greetings.add("Bonjour");
    // greetings.add("Hello");
    // return greetings;
    // }
    @GetMapping("/{id}")
    public Invoice invoice(@PathVariable("id") Long id) {// Long = null la
							 // facture n'a jms été
							 // sauvegardé non null
							 // permet de
							 // sauvegarder une
							 // donné, typage comme
							 // int
							 // sauvegaardé
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	ArrayList<Invoice> invoices = new ArrayList<>();
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice first = new Invoice("A01", date, 1005.36);
	invoices.add(first);
	Invoice second = new Invoice("A02", date, 1005.36);
	invoices.add(second);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id " + id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println("update invoice with id " + id);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Patched invoice with id " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Patched invoice with id " + id);
    }
}
