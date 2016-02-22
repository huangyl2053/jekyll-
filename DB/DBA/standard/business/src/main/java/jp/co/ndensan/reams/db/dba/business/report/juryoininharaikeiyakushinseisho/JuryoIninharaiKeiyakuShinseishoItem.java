/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険受領委任払い契約申請書Entityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuryoIninharaiKeiyakuShinseishoItem {
    private final RString ninshoshaYakushokuMei;
    private final RString remban;
    private final RString tsuchiBun1;
    private final RString tsuchiBun2;
    private final RString tsuchiBun3;
    private final RString tsuchiBun4;
    private final RString title;

    /**
     * コンストラクタです。
     * @param ninshoshaYakushokuMei 認証者
     * @param remban 連番
     * @param tsuchiBun1 申請文
     * @param tsuchiBun2 同意文
     * @param tsuchiBun3 承認要件文
     * @param tsuchiBun4 審査文
     * @param title タイトル
     */
    public JuryoIninharaiKeiyakuShinseishoItem(RString ninshoshaYakushokuMei,
            RString remban,
            RString tsuchiBun1,
            RString tsuchiBun2,
            RString tsuchiBun3,
            RString tsuchiBun4,
            RString title) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.remban = remban;
        this.tsuchiBun1 = tsuchiBun1;
        this.tsuchiBun2 = tsuchiBun2;
        this.tsuchiBun3 = tsuchiBun3;
        this.tsuchiBun4 = tsuchiBun4;
        this.title = title;
    }
}
