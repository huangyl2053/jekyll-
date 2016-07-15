/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬請求書のBodyクラスです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahoshuseikyuBody {

    private final RString listGokei_1;
    private final RString listGokei_2;
    private final RString listGokei_3;

    /**
     * コンストラクタです。
     *
     * @param listGokei_1 listGokei_1
     * @param listGokei_2 listGokei_2
     * @param listGokei_3 listGokei_3
     */
    public ChosahoshuseikyuBody(RString listGokei_1,
            RString listGokei_2,
            RString listGokei_3) {
        this.listGokei_1 = listGokei_1;
        this.listGokei_2 = listGokei_2;
        this.listGokei_3 = listGokei_3;
    }
}
