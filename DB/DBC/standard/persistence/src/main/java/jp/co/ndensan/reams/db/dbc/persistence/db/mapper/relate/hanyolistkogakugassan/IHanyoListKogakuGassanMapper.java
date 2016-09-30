package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassan.HanyoListKogakuGassanKeisanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassan.HanyoListKogakuGassanKeisanEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)のmapperです
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
public interface IHanyoListKogakuGassanMapper {

    /**
     * CSVデータの取得
     *
     * @param parameter HanyoListKogakuGassanKeisanProcessParameter
     * @return HanyoListKogakuGassanKeisanEntity
     */
    List<HanyoListKogakuGassanKeisanEntity> getCSVData(HanyoListKogakuGassanKeisanMybatisParameter parameter);
}
