/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistsogojigyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistsogojigyo.HanyoListSogoJigyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsogojigyohi.HanyoListSogoJigyoHiRelateEntity;

/**
 * 汎用リスト出力(総合事業費情報)のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
public interface IHanyoListSogoJigyoReibanMapper {

    /**
     * CSVデータの取得
     *
     * @param parameter HanyoListShokanbaraiJokyoMybatisParameter
     * @return List<HanyoListSogoJigyoHiRelateEntity>
     */
    List<HanyoListSogoJigyoHiRelateEntity> get総合事業費(HanyoListSogoJigyoMybatisParameter parameter);
}
