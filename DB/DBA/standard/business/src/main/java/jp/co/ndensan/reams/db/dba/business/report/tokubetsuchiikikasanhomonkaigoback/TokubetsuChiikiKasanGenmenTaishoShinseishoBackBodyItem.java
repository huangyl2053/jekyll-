/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem {

    private final RString ninshoshaYakushokuMei;
    private final RString tsuchiBun2;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param tsuchiBun2 通知文2
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem(RString ninshoshaYakushokuMei,
            RString tsuchiBun2) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.tsuchiBun2 = tsuchiBun2;
    }
}
