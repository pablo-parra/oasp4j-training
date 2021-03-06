package io.oasp.gastronomy.restaurant.suppliermanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.suppliermanagement.dataaccess.api.SupplierEntity;
import io.oasp.gastronomy.restaurant.suppliermanagement.dataaccess.api.dao.SupplierDao;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.Suppliermanagement;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierEto;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of suppliermanagement
 */
@Named
public class SuppliermanagementImpl extends AbstractComponentFacade implements Suppliermanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(SuppliermanagementImpl.class);

  /** @see #getSupplierDao() */
  @Inject
  private SupplierDao supplierDao;

  /**
   * The constructor.
   */
  public SuppliermanagementImpl() {
    super();
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SUPPLIERS)
  public SupplierEto findSupplier(Long id) {

    LOG.debug("Get Supplier with id {} from database.", id);
    return getBeanMapper().map(getSupplierDao().findOne(id), SupplierEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SUPPLIERS)
  public PaginatedListTo<SupplierEto> findSupplierEtos(SupplierSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<SupplierEntity> suppliers = getSupplierDao().findSuppliers(criteria);
    return mapPaginatedEntityList(suppliers, SupplierEto.class);
  }

  @Override
  public boolean deleteSupplier(Long supplierId) {

    SupplierEntity supplier = getSupplierDao().find(supplierId);
    getSupplierDao().delete(supplier);
    LOG.debug("The supplier with id '{}' has been deleted.", supplierId);
    return true;
  }

  @Override
  public SupplierEto saveSupplier(SupplierEto supplier) {

    Objects.requireNonNull(supplier, "supplier");
    SupplierEntity supplierEntity = getBeanMapper().map(supplier, SupplierEntity.class);

    // initialize, validate supplierEntity here if necessary
    getSupplierDao().save(supplierEntity);
    LOG.debug("Supplier with id '{}' has been created.", supplierEntity.getId());

    return getBeanMapper().map(supplierEntity, SupplierEto.class);
  }

  /**
   * Returns the field 'supplierDao'.
   *
   * @return the {@link SupplierDao} instance.
   */
  public SupplierDao getSupplierDao() {

    return this.supplierDao;
  }

}