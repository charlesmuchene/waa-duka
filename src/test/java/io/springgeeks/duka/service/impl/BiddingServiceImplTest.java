package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.BiddingService;
import io.springgeeks.duka.service.ProductService;
import io.springgeeks.duka.service.impl.utils.ProductBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class BiddingServiceImplTest {

    private ProductService productService = Mockito.mock(ProductService.class);

    private BiddingService biddingService;

    @BeforeEach
    public void setup() {
        biddingService = new BiddingServiceImpl(productService);
    }

    @Test
    public void lowerBidPriceReturnsNull() {
        Product product = new ProductBuilder().setPrice(100).build();

        Mockito.when(productService.productById(anyLong())).thenReturn(product);

        Product bidProduct = biddingService.placeBid(-1, 99);

        assertNull(bidProduct);

    }

    @Test
    public void lowerBidPriceReturnsValidProduct() {
        Product product = new ProductBuilder().setPrice(100).setId(-1).build();

        Mockito.when(productService.productById(anyLong())).thenReturn(product);

        Product bidProduct = biddingService.placeBid(-1, 200);

        assertNotNull(bidProduct);
        assertEquals(200, bidProduct.getPrice());
        assertEquals(product.getId(), bidProduct.getId());
    }
}