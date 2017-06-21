package io.oasp.gastronomy.restaurant.suppliermanagement.service.impl.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierEto;
import io.oasp.gastronomy.restaurant.suppliermanagement.service.api.rest.SuppliermanagementRestService;

@SpringApplicationConfiguration(classes = SpringBootApp.class)
public class SuppliermanagementRestServiceTest extends AbstractRestServiceTest {

  SuppliermanagementRestService service;

  @Before
  public void initialize() {

    this.service = getRestTestClientBuilder().build(SuppliermanagementRestService.class, "manager");
  }

  @Test
  public void testFindSupplier() {

    long id = 3;

    SupplierEto supplier = this.service.getSupplier(id);

    assertThat(supplier).isNotNull();
    assertThat(supplier.getName()).isEqualTo("Albafrost");

  }

  @After
  public void end() {

    this.service = null;
  }
}
