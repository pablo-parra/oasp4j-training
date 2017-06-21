package io.oasp.gastronomy.restaurant.suppliermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.gastronomy.restaurant.suppliermanagement.dataaccess.api.SupplierEntity;
import io.oasp.gastronomy.restaurant.suppliermanagement.dataaccess.api.dao.SupplierDao;
import io.oasp.gastronomy.restaurant.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link SupplierDao}.
 */
@Named
public class SupplierDaoImpl extends ApplicationDaoImpl<SupplierEntity> implements SupplierDao {

  /**
   * The constructor.
   */
  public SupplierDaoImpl() {

    super();
  }

  @Override
  public Class<SupplierEntity> getEntityClass() {

    return SupplierEntity.class;
  }

  @Override
  public PaginatedListTo<SupplierEntity> findSuppliers(SupplierSearchCriteriaTo criteria) {

    SupplierEntity supplier = Alias.alias(SupplierEntity.class);
    EntityPathBase<SupplierEntity> alias = Alias.$(supplier);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(supplier.getName()).eq(name));
    }
    String description = criteria.getDescription();
    if (description != null) {
      query.where(Alias.$(supplier.getDescription()).eq(description));
    }
    int rate = criteria.getRate();
    query.where(Alias.$(supplier.getRate()).eq(rate));
    return findPaginated(criteria, query, alias);
  }

}