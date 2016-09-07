/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.UaFt250FindAtesakiParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛先情報のパラメータ
 *
 * @reamsid_L DBD-9999-013 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtesakiPSMMybatisParameter extends UaFt250FindAtesakiParam implements IMyBatisParameter {

    private RString psmAtesaki;

    /**
     * 宛先情報を取得する
     *
     * @param searchKey searchKey
     */
    public AtesakiPSMMybatisParameter(IAtesakiPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * psmShikibetsuTaishoの設定
     *
     * @param psmAtesaki psmAtesaki
     */
    public void setPsmAtesaki(RString psmAtesaki) {
        this.psmAtesaki = psmAtesaki;
    }
}
