package io.oasp.gastronomy.restaurant.suppliermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.Suppliermanagement;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierEto;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Suppliermanagement}.
 */
@Path("/suppliermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SuppliermanagementRestService extends io.oasp.gastronomy.restaurant.general.common.api.RestService {

  /**
   * Delegates to {@link Suppliermanagement#findSupplier}.
   *
   * @param id the ID of the {@link SupplierEto}
   * @return the {@link SupplierEto}
   */
  @GET
  @Path("/supplier/{id}/")
  public SupplierEto getSupplier(@PathParam("id") long id);

  /**
   * Delegates to {@link Suppliermanagement#saveSupplier}.
   *
   * @param supplier the {@link SupplierEto} to be saved
   * @return the recently created {@link SupplierEto}
   */
  @POST
  @Path("/supplier/")
  public SupplierEto saveSupplier(SupplierEto supplier);

  /**
   * Delegates to {@link Suppliermanagement#deleteSupplier}.
   *
   * @param id ID of the {@link SupplierEto} to be deleted
   */
  @DELETE
  @Path("/supplier/{id}/")
  public void deleteSupplier(@PathParam("id") long id);

  /**
   * Delegates to {@link Suppliermanagement#findSupplierEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding suppliers.
   * @return the {@link PaginatedListTo list} of matching {@link SupplierEto}s.
   */
  @Path("/supplier/search")
  @POST
  public PaginatedListTo<SupplierEto> findSuppliersByPost(SupplierSearchCriteriaTo searchCriteriaTo);

}