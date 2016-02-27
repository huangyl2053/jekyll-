/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険被保険者証交付申請書（第2号被保険者）です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashokoufuShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString hihokenshaTelNo;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNameKana 被保険者氏名フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param seibetsu 被保険者性別
     * @param birthYMD 被保険者生年月日
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param hihokenshaTelNo 電話番号
     */
    public HihokenshashokoufuShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString seibetsu,
            RString birthYMD,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString hihokenshaTelNo
    ) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaTelNo = hihokenshaTelNo;
    }
}
