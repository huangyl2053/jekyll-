/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32003;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納状況把握情報の取得SQL用パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShunoJokyoHaakuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString psmTotalShunyu;

    /**
     * コンストラクタです
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param psmTotalShunyu psmTotalShunyu
     */
    public ShunoJokyoHaakuMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey, RString psmTotalShunyu) {
        super(searchKey);
        psmTotalShunyu = this.psmTotalShunyu;
    }

}
