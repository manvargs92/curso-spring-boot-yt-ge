package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes") // para unificar las rutas
public class CustomerRestController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo López", "gerardol", "Mexico123"),
            new Customer(456, "Alejandra García", "alegarcia", "contra123"),
            new Customer(789, "Laura Sánchez", "lausanch", "secreto6789"),
            new Customer(234, "Carlos Martínez", "carlitosm", "passw3456")
    ));

    //@GetMapping("/clientes")
    //@GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    //@GetMapping("/clientes/{username}")
    //@GetMapping("/{username}")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Customer getCliente(@PathVariable String username) {
        for(Customer customer : customers) {
            if (customer.getUserName().equalsIgnoreCase(username)) {
                return customer;
            }
        }

        return null; // pésima práctica
    }

    //@PostMapping("/clientes")
    //@PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    //@PutMapping("/clientes")
    //@PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public Customer putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());

                return c;
            }
        }

        return null; // pésima práctica
    }

    //@DeleteMapping("/clientes/{id}")
    //@DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Customer deleteCliente(@PathVariable int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);

                return customer;
            }
        }

        return null; // pésima práctica
    }

    //@PatchMapping("/clientes")
    //@PatchMapping
    @RequestMapping(method = RequestMethod.DELETE)
    public Customer patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }

                if (customer.getUserName() != null) {
                    c.setUserName(customer.getUserName());
                }

                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return c;
            }
        }

        return null; // pésima práctica
    }

}
