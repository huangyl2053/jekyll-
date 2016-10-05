/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.sogosyokaifukajyoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoEntity;

/**
 * 総合照会_賦課情報のMapper
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
public interface ISoGoSyoKaiFuKaJyoHoMapper {

    /**
     * 調定情報の取得。
     *
     * @param parameter SoGoSyoKaiFuKaJyoHoParameter
     * @return List<SoGoSyoKaiFuKaJyoHoEntity>
     */
    List<SoGoSyoKaiFuKaJyoHoEntity> get調定情報(SoGoSyoKaiFuKaJyoHoParameter parameter);
}
