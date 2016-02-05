/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 要介護認定区分変更申請書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteikbnHenkoShinseishoItem {

    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString birthYMD;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaTelNo;
    private final RString hihokenJusho;
    private final RString yokaigoKbn;
    private final RString yoshienKbn;
    private final RString yokoKikanSTYMD;
    private final RString yokoKikanEDYMD;
    private final RString tsuchiBun;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * インスタンスを生成します。
     *
     * @param hihokenshaNo 介護保険被保険者番号
     * @param hihokenshaNameKana 被保険者氏名フリガナ
     * @param birthYMD 生年月日
     * @param hihokenshaName 被保険者氏名
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaTelNo 電話番号
     * @param hihokenJusho 住所
     * @param yokaigoKbn 要介護状態区分
     * @param yoshienKbn 要支援状態区分
     * @param yokoKikanSTYMD 認定有効期間開始
     * @param yokoKikanEDYMD 認定有効期間終了
     * @param tsuchiBun 通知文
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者
     */
    public YokaigoNinteikbnHenkoShinseishoItem(
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString birthYMD,
            RString hihokenshaName,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenshaTelNo,
            RString hihokenJusho,
            RString yokaigoKbn,
            RString yoshienKbn,
            RString yokoKikanSTYMD,
            RString yokoKikanEDYMD,
            RString tsuchiBun,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.birthYMD = birthYMD;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenJusho = hihokenJusho;
        this.yokaigoKbn = yokaigoKbn;
        this.yoshienKbn = yoshienKbn;
        this.yokoKikanSTYMD = yokoKikanSTYMD;
        this.yokoKikanEDYMD = yokoKikanEDYMD;
        this.tsuchiBun = tsuchiBun;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
