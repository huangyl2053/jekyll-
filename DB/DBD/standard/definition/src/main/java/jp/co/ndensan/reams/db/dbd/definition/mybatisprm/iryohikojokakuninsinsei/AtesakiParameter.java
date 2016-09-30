/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.UaFt250FindAtesakiParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 宛先情報PSM_DB検索用のパラメータです。
 *
 * @reamsid_L DBD-5770-030 tz_chengpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtesakiParameter extends UaFt250FindAtesakiParam implements IMyBatisParameter {

    /**
     * 宛先情報PSMの取得のパラメータ作成を行います。
     *
     * @param searchKey 宛先情報PSM検索キー
     */
    public AtesakiParameter(IAtesakiPSMSearchKey searchKey) {
        super(searchKey);
    }

}
