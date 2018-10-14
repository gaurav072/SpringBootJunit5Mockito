package com.startwithjava.dao.repository.projection;
import org.springframework.beans.factory.annotation.Value;
public interface UserProjection {
    @Value("#{target.firstname}")
    String getFullName();
}
