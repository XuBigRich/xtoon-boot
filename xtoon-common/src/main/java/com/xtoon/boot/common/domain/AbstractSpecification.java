package com.xtoon.boot.common.domain;


/**
 * Abstract base implementation of composite {@link Specification} with default
 * implementations for {@code and}, {@code or} and {@code not}.
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract boolean isSatisfiedBy(T t);

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> and(final Specification<T> specification) {
    return new AndSpecification<T>(this, specification);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> or(final Specification<T> specification) {
    return new OrSpecification<T>(this, specification);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Specification<T> not(final Specification<T> specification) {
    return new NotSpecification<T>(specification);
  }
}
