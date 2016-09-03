/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistkogakugassanshinseishojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoEntity;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)Mapper
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public interface IHanyoListKogakuGassanShinseishoJohoMapper {

    /**
     * CSVデータの取得
     *
     * @param parameter HanyoListShokanbaraiJokyoMybatisParameter
     * @return HanyoListKogakuGassanShinseishoJohoEntity
     */
    List<HanyoListKogakuGassanShinseishoJohoEntity> getCSVData(HanyoListKogakuGassanShinseishoJohoMybatisParameter parameter);
}
