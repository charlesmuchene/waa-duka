package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Bid;
import io.springgeeks.duka.domain.Credentials;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.domain.User;
import io.springgeeks.duka.repository.BiddingRepository;
import io.springgeeks.duka.service.AuthenticationFacade;
import io.springgeeks.duka.service.BiddingService;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BiddingServiceImpl implements BiddingService {

    private final AuthenticationFacade authenticationFacade;
    private final BiddingRepository biddingRepository;
    private final ProductService productService;

    @Autowired
    public BiddingServiceImpl(ProductService productService, BiddingRepository biddingRepository,
                              AuthenticationFacade authenticationFacade) {
        this.productService = productService;
        this.biddingRepository = biddingRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public Product placeBid(Bid bid) {

        Product product = new Product();
        product.setPrice(14500);
        product.setId(bid.getProductId());

//      TODO Work with service: Product product = productService.productById(bid.getProductId());

        if (product == null) return null;

        if (product.getPrice() >= bid.getPrice()) return null;

        if (authenticationFacade.getAuthentication() != null) {
            User user = ((Credentials) authenticationFacade.getAuthentication().getPrincipal()).getUser();
            bid.setUserId(user.getId());
        }
        biddingRepository.save(bid);

        product.setPrice(bid.getPrice());
//      TODO Work with service: productService.save(product);

        return product;
    }

}
