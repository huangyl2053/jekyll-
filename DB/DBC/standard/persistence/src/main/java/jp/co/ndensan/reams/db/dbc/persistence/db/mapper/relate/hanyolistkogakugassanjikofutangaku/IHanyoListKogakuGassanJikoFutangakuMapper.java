/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkogakugassanjikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuEntity;

/**
 * 汎用リスト出力(高額合算自己負担額情報)のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
public interface IHanyoListKogakuGassanJikoFutangakuMapper {

    /**
     * データの取得
     *
     * @param parameter HanyoListKogakuGassanJikoFutangakuMybatisParameter
     * @return HanyoListKogakuGassanJikoFutangakuEntity
     */
    List<HanyoListKogakuGassanJikoFutangakuEntity> selectAllデータ(HanyoListKogakuGassanJikoFutangakuMybatisParameter parameter);
}
