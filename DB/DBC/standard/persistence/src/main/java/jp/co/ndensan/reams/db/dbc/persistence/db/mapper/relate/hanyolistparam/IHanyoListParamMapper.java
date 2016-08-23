/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hanyolistparam;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunshunyugakutekiyo.KijunShunyugakuTekiyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistparam.HanyoListParamRelateEntity;

/**
 * 汎用リスト_基準収入額適用情報のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
public interface IHanyoListParamMapper {

    /**
     * 基準収入額適用情報データを取得します。
     *
     * @param parameter KijunShunyugakuTekiyoMybatisParameter
     * @return HanyoListParamRelateEntity
     */
    List<HanyoListParamRelateEntity> get基準収入額適用情報(KijunShunyugakuTekiyoMybatisParameter parameter);

}
