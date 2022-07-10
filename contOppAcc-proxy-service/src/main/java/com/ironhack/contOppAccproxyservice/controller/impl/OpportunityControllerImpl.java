package com.ironhack.contOppAccproxyservice.controller.impl;

import com.ironhack.contOppAccproxyservice.controller.interfaces.OpportunityController;
import com.ironhack.contOppAccproxyservice.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpportunityControllerImpl implements OpportunityController {
    @Autowired
    OpportunityRepository opportunityRepository;

    //@PostMapping("/opportunity")

}

/*public Opportunity convertToOpportunity(Contact contact) {
    try {
        if (contact!=null) {
            System.out.println("\n*** New Opportunity ***" +
                    "\nEnter Product type: (HYBRID, FLATBED, BOX)");
            Scanner myScanner = new Scanner(System.in);
            Product product = null;
            boolean active = true;
            while (active) {
                String product_type = myScanner.nextLine();
                switch (product_type.toLowerCase()) {
                    case "hybrid":
                        active = false;
                        product = Product.HYBRID;
                        break;
                    case "flatbed":
                        active = false;
                        product = Product.FLATBED;
                        break;
                    case "box":
                        active = false;
                        product = Product.BOX;
                        break;
                    default:
                        active = true;
                        System.out.println("Product must be HYBRID, FLATBED or BOX ");
                        break;
                }
            }
            System.out.println("Enter the product quantity: ");
            while (!myScanner.hasNextInt()) {
                System.out.println("Product quantity must be an integer.Try again.");
                myScanner.next();
            }
            Integer quantity = myScanner.nextInt();
            myScanner.nextLine();
            Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN, contact.getSalesRep());
            if (opportunity != null) {
                opportunityRepository.save(opportunity);
                System.out.println("Opportunity successfully created with ID " + opportunity.getId());
            }
            return opportunity;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return null;
}*/