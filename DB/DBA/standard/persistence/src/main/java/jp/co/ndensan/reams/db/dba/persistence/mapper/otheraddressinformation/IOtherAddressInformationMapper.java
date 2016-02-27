/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.otheraddressinformation;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atena.OtherAddressInformationRecipientNameMybatisParam;
import jp.co.ndensan.reams.db.dba.definition.otheraddressledger.OtherAddressInformationParameter;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressInfFromDBEntity;
import jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger.OtherAddressInformationRecipientNameMybatisEntity;

/**
 * 他市町村住所地特例者情報のMapperクラスです。
 */
public interface IOtherAddressInformationMapper {

    /**
     * 他市町村住所地特例者情報の取得する
     *
     * @param 検索条件
     * @return List<OtherAddressInfFromDBEntity>
     */
    List<OtherAddressInfFromDBEntity> get他市町村住所地特例者情報の取得処理(OtherAddressInformationParameter 検索条件);

    /**
     * 宛名識別対象の取得する
     *
     * @param recipientNameMybatisParam recipientNameMybatisParam
     * @return List<OtherAddressInformationRecipientNameMybatisEntity>
     */
    List<OtherAddressInformationRecipientNameMybatisEntity>
            get宛名識別対象(OtherAddressInformationRecipientNameMybatisParam recipientNameMybatisParam);
}
