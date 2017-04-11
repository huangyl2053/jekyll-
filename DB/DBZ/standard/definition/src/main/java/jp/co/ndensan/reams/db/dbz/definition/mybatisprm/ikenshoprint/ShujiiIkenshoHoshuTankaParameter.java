/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoHoshuTankaParameter {

    private final RString 在宅施設区分;
    private final RString 意見書作成回数区分;
    private final RString 基準年月;
    private final boolean is区分指定;

    private ShujiiIkenshoHoshuTankaParameter(RString zaitakuShisetsuKubun,
            RString ikenshoSakuseiKaisuKubun,
            RString kijunYM,
            boolean isKubunShitei) {
        this.在宅施設区分 = zaitakuShisetsuKubun;
        this.意見書作成回数区分 = ikenshoSakuseiKaisuKubun;
        this.基準年月 = kijunYM;
        this.is区分指定 = isKubunShitei;
    }

    public static ShujiiIkenshoHoshuTankaParameter createParameter() {
        return new ShujiiIkenshoHoshuTankaParameter(RString.EMPTY,
                RString.EMPTY,
                RDate.getNowDate().getYearMonth().toDateString(),
                false);
    }

    public static ShujiiIkenshoHoshuTankaParameter createParameter(RString zaitakuShisetsuKubun,
            RString ikenshoSakuseiKaisuKubun) {
        return new ShujiiIkenshoHoshuTankaParameter(zaitakuShisetsuKubun,
                ikenshoSakuseiKaisuKubun,
                RDate.getNowDate().getYearMonth().toDateString(),
                true);
    }
}
