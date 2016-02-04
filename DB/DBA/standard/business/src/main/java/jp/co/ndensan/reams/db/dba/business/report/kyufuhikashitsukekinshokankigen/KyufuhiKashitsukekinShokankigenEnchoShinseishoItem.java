/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 護保険給付費貸付金償還期限延長申請書Entityリストです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiKashitsukekinShokankigenEnchoShinseishoItem {

    private final RString tsuchiBun;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString kashitsukeNo;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param tsuchiBun RString
     * @param hihokenshaNo RString
     * @param hihokenshaNameKana RString
     * @param hihokenshaName RString
     * @param kashitsukeNo RString
     * @param ninshoshaYakushokuMei RString
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseishoItem(RString tsuchiBun,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString kashitsukeNo,
            RString ninshoshaYakushokuMei) {
        this.tsuchiBun = tsuchiBun;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.kashitsukeNo = kashitsukeNo;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
