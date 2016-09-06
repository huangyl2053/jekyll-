package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkogakugassanshikyugakukettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 汎用リスト出力(高額合算支給額決定情報)Mapperです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
public interface IHanyoListKogakuGassanShikyugakuKetteiMapper {

    /**
     * CSVデータの取得
     *
     * @param parameter HanyoListKogakuGassanShikyugakuKetteiMybatisParameter
     * @return HanyoListKogakuGassanShikyugakuKetteiEntity
     */
    List<HanyoListKogakuGassanShikyugakuKetteiEntity> getCSVData(HanyoListKogakuGassanShikyugakuKetteiMybatisParameter parameter);
}
