/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書Itemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakuServiceKeikaluSakuseiIraiTodokedeshoItem {

    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString birthYＭＤ;
    private final RString shiseiBun;
    private final RString chuiBun;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param seibetsu 性別
     * @param birthYＭＤ 生年月日
     * @param shiseiBun 届出文
     * @param chuiBun 注意文
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者役職名
     */
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoItem(RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString seibetsu,
            RString birthYＭＤ,
            RString shiseiBun,
            RString chuiBun,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthYＭＤ = birthYＭＤ;
        this.shiseiBun = shiseiBun;
        this.chuiBun = chuiBun;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;

    }
}
