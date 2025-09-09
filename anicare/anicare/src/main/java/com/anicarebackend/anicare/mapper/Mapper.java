package com.anicarebackend.anicare.mapper;

public interface Mapper<entity, dto> {
    entity toEntity(dto dto);
    dto toDto(entity entity);
}
