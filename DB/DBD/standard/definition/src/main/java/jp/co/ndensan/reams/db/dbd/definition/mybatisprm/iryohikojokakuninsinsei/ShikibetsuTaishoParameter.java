/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 宛名情報PSM_DB検索用のパラメータです。
 *
 * @reamsid_L DBD-5770-030 tz_chengpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuTaishoParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * 宛名識別対象PSMの取得のパラメータ作成を行います。
     *
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     */
    public ShikibetsuTaishoParameter(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        super(shikibetsuTaishoPSMSearchKey);
    }
}
