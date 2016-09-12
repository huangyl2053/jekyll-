/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階と差額の組み合わせを格納する。
 *
 * @reamsid_L DBB-0830-020 wangkanglei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenryoDankaibetu {

    private RString 保険料段階;
    private Decimal 差額;

    /**
     * コンストラクタです。
     */
    public HokenryoDankaibetu() {
    }

    /**
     * コンストラクタです。
     *
     * @param 保険料段階 RString
     * @param 差額 Decimal
     */
    public HokenryoDankaibetu(RString 保険料段階, Decimal 差額) {
        this.保険料段階 = 保険料段階;
        this.差額 = 差額;
    }
}
