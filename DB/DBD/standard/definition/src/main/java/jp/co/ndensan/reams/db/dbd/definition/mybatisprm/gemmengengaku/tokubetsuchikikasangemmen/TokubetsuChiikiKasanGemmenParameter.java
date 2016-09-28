/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 特別地域加算減免申請（画面）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3680-030 miaojin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChiikiKasanGemmenParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 減免減額種類;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     */
    public TokubetsuChiikiKasanGemmenParameter(HihokenshaNo 被保険者番号, RString 減免減額種類) {
        this.被保険者番号 = 被保険者番号;
        this.減免減額種類 = 減免減額種類;
    }
}
