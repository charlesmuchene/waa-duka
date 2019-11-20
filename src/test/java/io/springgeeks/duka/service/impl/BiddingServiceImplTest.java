package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Bid;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.repository.BiddingRepository;
import io.springgeeks.duka.service.AuthenticationFacade;
import io.springgeeks.duka.service.BiddingService;
import io.springgeeks.duka.service.ProductService;
import io.springgeeks.duka.service.impl.utils.BidBuilder;
import io.springgeeks.duka.service.impl.utils.ProductBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;

public class BiddingServiceImplTest {

    private AuthenticationFacade authenticationFacade = mock(AuthenticationFacade.class);
    private BiddingRepository biddingRepository = mock(BiddingRepository.class);
    private ProductService productService = mock(ProductService.class);
    private BiddingService biddingService;

    @BeforeEach
    public void setup() {
        biddingService = new BiddingServiceImpl(productService, biddingRepository, authenticationFacade);
    }

    @Test
    public void lowerBidPriceReturnsNull() {
        Product product = new ProductBuilder().setPrice(100).build();
        Bid bid = new BidBuilder().from(product).setBid(99).build();

        Mockito.when(productService.productById(anyLong())).thenReturn(product);

        Product bidProduct = biddingService.placeBid(bid);

        assertNull(bidProduct);

    }

    @Test
    public void lowerBidPriceReturnsValidProduct() {
        Product product = new ProductBuilder().setPrice(100).setId(-1).build();
        Bid bid = new BidBuilder().from(product).setBid(200).build();

        Mockito.when(productService.productById(anyLong())).thenReturn(product);

        Product bidProduct = biddingService.placeBid(bid);

        assertNotNull(bidProduct);
        assertEquals(bid.getPrice(), bidProduct.getPrice());
        assertEquals(product.getId(), bidProduct.getId());
    }
}