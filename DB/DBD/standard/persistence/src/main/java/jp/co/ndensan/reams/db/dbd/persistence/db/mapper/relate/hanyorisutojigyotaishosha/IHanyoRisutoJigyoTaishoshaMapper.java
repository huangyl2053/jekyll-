/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutojigyotaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaEntity;

/**
 * 汎用リスト出力(事業対象者)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-5080-030 mawy
 */
public interface IHanyoRisutoJigyoTaishoshaMapper {

    /**
     * 要介護認定情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoRisutoJigyoTaishoshaEntity>
     */
    List<HanyoRisutoJigyoTaishoshaEntity> get汎用リスト(HanyoRisutoJigyoTaishoshaMybatisParameter parameter);
}
