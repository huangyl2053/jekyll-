/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidofuka;

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
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KariSanteiIdoFukaPsmParameter implements IMyBatisParameter {

    private final RString 出力順;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタです
     *
     * @param 出力順 RString
     * @param shikibetsutaishoParam UaFt200FindShikibetsuTaishoParam
     */
    private KariSanteiIdoFukaPsmParameter(
            RString 出力順,
            UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam) {
        this.出力順 = 出力順;
        this.shikibetsutaishoParam = shikibetsutaishoParam;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 出力順 RString
     * @param shikibetsutaishoParam UaFt200FindShikibetsuTaishoParam
     * @return パラメータ
     */
    public static KariSanteiIdoFukaPsmParameter createSelectByKeyParam(
            RString 出力順,
            UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam) {
        return new KariSanteiIdoFukaPsmParameter(出力順, shikibetsutaishoParam);
    }

}
