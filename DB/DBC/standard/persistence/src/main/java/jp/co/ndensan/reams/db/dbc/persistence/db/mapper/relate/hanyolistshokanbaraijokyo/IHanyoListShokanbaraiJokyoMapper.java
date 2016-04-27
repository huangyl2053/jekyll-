/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistshokanbaraijokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoEntity;

/**
 * 汎用リスト出力(償還払い状況)Mapper
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public interface IHanyoListShokanbaraiJokyoMapper {

    /**
     * CSVデータの取得
     *
     * @param parameter HanyoListShokanbaraiJokyoMybatisParameter
     * @return HanyoListShokanbaraiJokyoEntity
     */
    List<HanyoListShokanbaraiJokyoEntity> getCSVData(HanyoListShokanbaraiJokyoMybatisParameter parameter);
}
