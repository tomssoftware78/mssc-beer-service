package guru.springframework.msscbeerservice;

import guru.sfg.brewery.model.BeerStyleEnum;
import guru.springframework.msscbeerservice.domain.Beer;

import java.util.UUID;

public class BeerTestConstants {

    public static Beer beer1() {
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Baskwadder Blond")
                .beerStyle(BeerStyleEnum.PALE_ALE.toString())
                .minOnHand(100)
                .build();
    }

    public static Beer beer2() {
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Baskwadder Triple")
                .beerStyle(BeerStyleEnum.ALE.toString())
                .minOnHand(100)
                .build();
    }
}
