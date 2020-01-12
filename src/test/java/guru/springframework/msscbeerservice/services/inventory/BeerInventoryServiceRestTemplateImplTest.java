package guru.springframework.msscbeerservice.services.inventory;

import guru.springframework.msscbeerservice.services.inventory.model.BeerInventoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BeerInventoryServiceRestTemplateImplTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    BeerInventoryServiceRestTemplateImpl beerInventoryService;


    @Test
    void getOnhandInventory() {
        /*when(restTemplate.exchange(anyString(), HttpMethod.GET, null, any(ParameterizedTypeReference.class), any(Object.class)))


        restTemplate
                .exchange(beerInventoryServiceHost + INVENTORY_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BeerInventoryDto>>(){}, (Object) beerId);
        restTemplate
        beerInventoryService.getOnhandInventory(UUID.randomUUID());


        //todo evolve to use UPC
      //  Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);

        //System.out.println(qoh);
        */

    }
}