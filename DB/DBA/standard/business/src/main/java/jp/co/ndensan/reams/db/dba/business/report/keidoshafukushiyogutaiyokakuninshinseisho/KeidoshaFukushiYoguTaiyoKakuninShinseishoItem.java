/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書Entityリストです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeidoshaFukushiYoguTaiyoKakuninShinseishoItem {

    private final RString tsuchiBun1;
    private final RString jusho;
    private final RString shimei;
    private final RString hihokenshaNo;
    private final RString tsuchiBun2;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param tsuchiBun1 RString
     * @param jusho RString
     * @param shimei RString
     * @param hihokenshaNo RString
     * @param tsuchiBun2 RString
     * @param remban RString
     * @param ninshoshaYakushokuMei RString
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoItem(RString tsuchiBun1,
            RString jusho,
            RString shimei,
            RString hihokenshaNo,
            RString tsuchiBun2,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.tsuchiBun1 = tsuchiBun1;
        this.jusho = jusho;
        this.shimei = shimei;
        this.hihokenshaNo = hihokenshaNo;
        this.tsuchiBun2 = tsuchiBun2;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
