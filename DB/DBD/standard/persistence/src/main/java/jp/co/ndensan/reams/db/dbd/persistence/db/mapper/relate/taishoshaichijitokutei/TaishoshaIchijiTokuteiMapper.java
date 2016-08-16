/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.taishoshaichijitokutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.taishoshaichijitokutei.TaishoshaIchijiTokuteiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanteiyouconkyosakuseishoushaiqiji.HanteiyouConkyosakuseishoushaiqijiRelateEntity;

/**
 * 対象者一次特定を取得します
 *
 * @a@reamsid_LDBD-3830-040 tianyh
 */
public interface TaishoshaIchijiTokuteiMapper {

    /**
     * 対象者一次特定を取得します。
     *
     * @param parameter TaishoshaIchijiTokuteiParameter
     * @return HanteiyouConkyosakuseishoushaiqijiRelateEntity{@code list}
     */
    List<HanteiyouConkyosakuseishoushaiqijiRelateEntity> select対象者一次特定(TaishoshaIchijiTokuteiParameter parameter);

}
