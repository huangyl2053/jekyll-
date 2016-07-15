/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名情報のパラメータ
 *
 * @reamsid_L DBD-9999-013 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShikibetsuTaishoPSMMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString psmShikibetsuTaisho;

    /**
     * 宛名情報を取得する
     *
     * @param searchKey searchKey
     */
    public ShikibetsuTaishoPSMMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * psmShikibetsuTaishoの設定
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public void setPsmShikibetsuTaisho(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
