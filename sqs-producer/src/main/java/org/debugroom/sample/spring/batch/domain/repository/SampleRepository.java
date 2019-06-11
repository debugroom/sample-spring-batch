package org.debugroom.sample.spring.batch.domain.repository;

import org.debugroom.sample.spring.batch.domain.model.Sample;

public interface SampleRepository {

    public void save(Sample sample);

}
