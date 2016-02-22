/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasangenmentaishoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem {

    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString kakuninNo;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString hihokenshaTelNo;
    private final RString tsuchiBun1;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param kakuninNo 確認番号
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana 被保険者フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 被保険者生年月日
     * @param seibetsu 被保険者性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param hihokenshaTelNo 電話番号
     * @param tsuchiBun1 通知文1
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem(RString ninshoshaYakushokuMei,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString kakuninNo,
            RString hihokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString hihokenshaTelNo,
            RString tsuchiBun1) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.kakuninNo = kakuninNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.tsuchiBun1 = tsuchiBun1;
    }
}
