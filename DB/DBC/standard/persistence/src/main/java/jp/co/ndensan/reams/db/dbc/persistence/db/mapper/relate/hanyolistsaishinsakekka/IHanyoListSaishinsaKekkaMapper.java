/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistsaishinsakekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaRelateEntity;

/**
 * 汎用リスト 再審査結果情報のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
public interface IHanyoListSaishinsaKekkaMapper {

    /**
     * 汎用リスト 再審査結果情報データを取得します。
     *
     * @param parameter HanyoListSaishinsaKekkaMybatisParameter
     * @return HanyoListSaishinsaKekkaRelateEntity
     */
    List<HanyoListSaishinsaKekkaRelateEntity> get再審査結果情報(HanyoListSaishinsaKekkaMybatisParameter parameter);
}
