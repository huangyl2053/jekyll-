/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2Entityリストです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item {

    private final RString tsuchiBun1;
    private final RString tsuchiBun2;
    private final RString tsuchiBun3;
    private final RString remban;

    /**
     * コンストラクタです。
     *
     * @param tsuchiBun1 RString
     * @param tsuchiBun2 RString
     * @param tsuchiBun3 RString
     * @param remban RString
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item(RString tsuchiBun1,
            RString tsuchiBun2,
            RString tsuchiBun3,
            RString remban) {
        this.tsuchiBun1 = tsuchiBun1;
        this.tsuchiBun2 = tsuchiBun2;
        this.tsuchiBun3 = tsuchiBun3;
        this.remban = remban;
    }
}
