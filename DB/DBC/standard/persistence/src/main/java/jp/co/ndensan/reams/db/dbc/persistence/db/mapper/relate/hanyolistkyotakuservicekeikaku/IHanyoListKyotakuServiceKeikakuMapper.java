/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkyotakuservicekeikaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuKijunYMDParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuEntity;

/**
 * 汎用リスト 居宅サービス計画Mapperクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
public interface IHanyoListKyotakuServiceKeikakuMapper {

    /**
     * selectbyKey
     *
     * @param parameter HanyoListKyotakuServiceKeikakuMybatisParameter
     * @return List<HanyoList_KyotakuServiceKeikakuEntity>
     */
    List<HanyoListKyotakuServiceKeikakuEntity> getCSVData(HanyoListKyotakuServiceKeikakuMybatisParameter parameter);

    /**
     * selectbyKey
     *
     * @param parameter HanyoListKyotakuServiceKeikakuKijunYMDParameter
     * @return List<HanyoList_KyotakuServiceKeikakuEntity>
     */
    int getKijunYMDData(HanyoListKyotakuServiceKeikakuKijunYMDParameter parameter);
}
