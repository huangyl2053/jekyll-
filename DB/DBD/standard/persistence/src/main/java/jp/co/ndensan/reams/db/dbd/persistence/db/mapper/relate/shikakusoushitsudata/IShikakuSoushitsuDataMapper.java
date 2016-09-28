/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shikakusoushitsudata;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;

/**
 * 資格喪失（死亡）データMapperです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public interface IShikakuSoushitsuDataMapper {

    /**
     * 資格喪失（死亡）データのEntityを取得する。
     *
     * @param parameter RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter
     *
     * @return List<ChohyoShuchiryokuyoShiseiJyohoEntity>
     */
    List<ChohyoShuchiryokuyoShiseiJyohoEntity> getShikakuSoshitsuEntity(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter parameter);
}
