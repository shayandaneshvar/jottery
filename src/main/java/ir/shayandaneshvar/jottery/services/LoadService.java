package ir.shayandaneshvar.jottery.services;

import ir.shayandaneshvar.jottery.models.Customer;
import ir.shayandaneshvar.jottery.models.Gender;
import ir.shayandaneshvar.jottery.repositories.CustomerRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

@Getter
@Setter
@Service
@Profile("default")
@PropertySource("classpath:dev.properties")
public class LoadService {
    private CustomerRepository customerRepository;
    @Value("${load_from_csv}")
    private Boolean load_from_csv;
    @Value("${clear_data}")
    private Boolean clear_data;
    @Value("${csv_path}")
    private String csv_path;

    @PostConstruct
    @SneakyThrows
    public void init() {
        if (clear_data) {
            customerRepository.deleteAll();
        }
        if (load_from_csv) {
            System.out.println(csv_path);
            try (BufferedReader reader = new BufferedReader(new FileReader(csv_path))) {
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] data = row.split(",");
                    Customer customer = new Customer(Long.valueOf(data[1]),
                            data[2], data[3], Integer.valueOf(data[4]),
                            LocalDate.of(Integer.parseInt(data[5].split("/")[0]),
                                    Integer.parseInt(data[5].split("/")[1]) % 12 + 1,
                                    Integer.parseInt(data[5].split("/")[2]) % 28 + 1),
                            Gender.valueOf(data[6].toUpperCase()),
                            data[7]);
                    customer.setId(Long.valueOf(data[0]));
                    customerRepository.save(customer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public LoadService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}