package guru.springframework.msscbeerservice.services.brewing;

import guru.sfg.brewery.model.events.BrewBeerEvent;
import guru.springframework.msscbeerservice.config.JmsConfig;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import guru.springframework.msscbeerservice.web.mappers.BeerMapper;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static guru.springframework.msscbeerservice.BeerTestConstants.beer1;
import static guru.springframework.msscbeerservice.BeerTestConstants.beer2;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrewingServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

    @Mock
    BeerRepository beerRepository;

    @Mock
    BeerInventoryService beerInventoryService;

    @Mock
    JmsTemplate jmsTemplate;

    @Spy
    BeerMapper beerMapper;

    @InjectMocks
    BrewingService service;

    @Test
    public void test() {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(20);
        UUID uuid1 = beer1().getId();
        UUID uuid2 = beer2().getId();

        List<Beer> beers = Arrays.asList(beer1(), beer2());
        when(beerRepository.findAll()).thenReturn(beers);
        when(beerInventoryService.getOnhandInventory(uuid1)).thenReturn(i1);
        when(beerInventoryService.getOnhandInventory(uuid2)).thenReturn(i2);

        service.checkForLowInventory();

        verify(jmsTemplate, times(2)).convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, any(BrewBeerEvent.class));

    }
}