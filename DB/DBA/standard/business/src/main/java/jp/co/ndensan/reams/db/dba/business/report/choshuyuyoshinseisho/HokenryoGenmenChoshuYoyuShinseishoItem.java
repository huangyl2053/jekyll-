/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.choshuyuyoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険料徴収猶予申請書のEntityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenryoGenmenChoshuYoyuShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString hokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString hihokenshaTelNo;

    /**
     * コンストラクタです。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 氏名
     * @param hokenshaNo 保険者番号
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param hihokenshaTelNo 電話番号
     */
    public HokenryoGenmenChoshuYoyuShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString hokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString hihokenshaTelNo) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.hokenshaNo = hokenshaNo;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaTelNo = hihokenshaTelNo;
    }
}
