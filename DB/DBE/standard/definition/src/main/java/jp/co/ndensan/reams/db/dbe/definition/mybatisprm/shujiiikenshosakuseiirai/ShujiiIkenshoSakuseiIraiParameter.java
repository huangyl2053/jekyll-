/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書一覧のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoSakuseiIraiParameter {

    private final RString hihokenshaNo;
    private final RString shoriJotaiKubunTsujo;
    private final RString shoriJotaiKubunEnki;

    private ShujiiIkenshoSakuseiIraiParameter(RString hihokenshaNo, RString shoriJotaiKubunTsujo, RString shoriJotaiKubunEnki) {
        this.hihokenshaNo = hihokenshaNo;
        this.shoriJotaiKubunTsujo = shoriJotaiKubunTsujo;
        this.shoriJotaiKubunEnki = shoriJotaiKubunEnki;
    }

    /**
     * 主治医意見書一覧のMyBatisパラメータクラスを作成します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @return 主治医意見書一覧のMyBatisパラメータ。
     */
    public static ShujiiIkenshoSakuseiIraiParameter createShujiiIkenshoSakuseiIraiParameter(RString hiHokenshaNo) {
        return new ShujiiIkenshoSakuseiIraiParameter(hiHokenshaNo, ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード());
    }
}
