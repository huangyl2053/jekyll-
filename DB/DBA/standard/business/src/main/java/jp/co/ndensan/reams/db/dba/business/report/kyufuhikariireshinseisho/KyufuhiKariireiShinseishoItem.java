/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikariireshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険給付費借入申請書のEntityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiKariireiShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString birthYMD;
    private final RString hihokenshaNo;
    private final RString hihokenJusho;
    private final RString hihokenshaName;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaTelNo;
    private final RString hihokenshaYubinNo;
    private final RString seibetsu;
    private final RString tsuchiBun1;
    private final RString tsuchiBun2;

    /**
     * コンストラクタです。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param birthYMD 生年月日
     * @param hihokenshaNo 介護保険被保険者番号
     * @param hihokenJusho 住所
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNameKana 被保険者氏名フリガナ
     * @param hihokenshaTelNo 電話番号
     * @param hihokenshaYubinNo 郵便番号
     * @param seibetsu 性別
     * @param tsuchiBun1 依頼文
     * @param tsuchiBun2 注意文
     */
    public KyufuhiKariireiShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString birthYMD,
            RString hihokenshaNo,
            RString hihokenJusho,
            RString hihokenshaName,
            RString hihokenshaNameKana,
            RString hihokenshaTelNo,
            RString hihokenshaYubinNo,
            RString seibetsu,
            RString tsuchiBun1,
            RString tsuchiBun2) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.birthYMD = birthYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.seibetsu = seibetsu;
        this.tsuchiBun1 = tsuchiBun1;
        this.tsuchiBun2 = tsuchiBun2;
    }
}
