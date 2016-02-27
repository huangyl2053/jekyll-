/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険料納付額証明書交付申請書Itemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NofugakuShomeishoKofuShinseishoItem {

    private final RString tsuchiBun;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaTelNo;
    private final RString hihokenJusho;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param tsuchiBun 通知文
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaTelNo 電話番号
     * @param hihokenJusho 住所
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者役職名
     */
    public NofugakuShomeishoKofuShinseishoItem(RString tsuchiBun,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenshaTelNo,
            RString hihokenJusho,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.tsuchiBun = tsuchiBun;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenJusho = hihokenJusho;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;

    }
}
