/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険受給資格証明書交付申請書のEntityクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishokoufuShinseishoItem {
    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaTelNo;
    private final RString hihokenJusho;
    private final RString tenshutsuMaeYubinNo;
    private final RString tenshutsuMaeTelNo;
    private final RString tenshutsuMaeJusho;
    private final RString genjushoYubinNo;
    private final RString genjushoTelNo;
    private final RString genjusho;

    /**
     * コンストラクタです。
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNo 介護保険被保険者番号
     * @param hihokenshaNameKana 被保険者氏名フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaTelNo 電話番号
     * @param hihokenJusho 住所
     * @param tenshutsuMaeYubinNo 異動前郵便番号
     * @param tenshutsuMaeTelNo 異動前電話番号
     * @param tenshutsuMaeJusho 異動前住所
     * @param genjushoYubinNo 異動後郵便番号
     * @param genjushoTelNo 異動後電話番号
     * @param genjusho 異動後住所
     */
    public JukyuShikakuShomeishokoufuShinseishoItem(RString ninshoshaYakushokuMei,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenshaTelNo,
            RString hihokenJusho,
            RString tenshutsuMaeYubinNo,
            RString tenshutsuMaeTelNo,
            RString tenshutsuMaeJusho,
            RString genjushoYubinNo,
            RString genjushoTelNo,
            RString genjusho) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenJusho = hihokenJusho;
        this.tenshutsuMaeYubinNo = tenshutsuMaeYubinNo;
        this.tenshutsuMaeTelNo = tenshutsuMaeTelNo;
        this.tenshutsuMaeJusho = tenshutsuMaeJusho;
        this.genjushoYubinNo = genjushoYubinNo;
        this.genjushoTelNo = genjushoTelNo;
        this.genjusho = genjusho;
    }
}
