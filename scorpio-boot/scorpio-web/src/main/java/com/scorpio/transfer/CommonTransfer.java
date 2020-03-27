package com.scorpio.transfer;

import com.scorpio.entity.SourceRntity;
import com.scorpio.entity.TargetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommonTransfer {
    CommonTransfer INSTANCE = Mappers.getMapper(CommonTransfer.class);

    TargetEntity sR2TeTransfer(SourceRntity sourceRntity);

    List<TargetEntity> sR2TeTransfer(List<SourceRntity> sourceRntitys);
}
