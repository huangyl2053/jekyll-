/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutojyukyusyadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoEntity;

/**
 * 汎用リスト受給者台帳２のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1810-020 yaodongsheng
 */
public interface IHanyoRisutoJyukyusyaDaichoMapper {

    /**
     * 要介護認定情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<NursingCareInformationCodeEntity>
     */
    List<HanyoRisutoJyukyusyaDaichoEntity> get汎用リスト(HanyoRisutoJyukyusyaDaichoMybatisParameter parameter);
}
