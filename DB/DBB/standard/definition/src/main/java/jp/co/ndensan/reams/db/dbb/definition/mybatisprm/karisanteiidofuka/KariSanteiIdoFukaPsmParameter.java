/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定異動賦課のビジネス用パラメータクラスです。
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class KariSanteiIdoFukaPsmParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 出力順;

    /**
     * コンストラクタです
     *
     * @param 出力順 出力順
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public KariSanteiIdoFukaPsmParameter(
            RString 出力順,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.出力順 = 出力順;
    }

}
