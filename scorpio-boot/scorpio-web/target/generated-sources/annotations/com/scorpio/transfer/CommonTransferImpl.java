package com.scorpio.transfer;

import com.scorpio.entity.SourceRntity;
import com.scorpio.entity.TargetEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-27T11:14:04+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class CommonTransferImpl implements CommonTransfer {

    @Override
    public TargetEntity sR2TeTransfer(SourceRntity sourceRntity) {
        if ( sourceRntity == null ) {
            return null;
        }

        TargetEntity targetEntity = new TargetEntity();

        targetEntity.setName1( sourceRntity.getName1() );

        return targetEntity;
    }

    @Override
    public List<TargetEntity> sR2TeTransfer(List<SourceRntity> sourceRntitys) {
        if ( sourceRntitys == null ) {
            return null;
        }

        List<TargetEntity> list = new ArrayList<TargetEntity>( sourceRntitys.size() );
        for ( SourceRntity sourceRntity : sourceRntitys ) {
            list.add( sR2TeTransfer( sourceRntity ) );
        }

        return list;
    }
}
