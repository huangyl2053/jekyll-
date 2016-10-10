/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutojyukyusya;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusya.HanyoRisutoJyukyusyaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoEntity;

/**
 * 汎用リスト出力(受給者台帳)のマッパーインタフェースです。。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
public interface IHanyoRisutoJyukyusyaMapper {
    /**
     * 要介護認定情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<NursingCareInformationCodeEntity>
     */
    List<HanyoRisutoJyukyusyaDaichoEntity> get汎用リスト(HanyoRisutoJyukyusyaMybatisParameter parameter);
}
