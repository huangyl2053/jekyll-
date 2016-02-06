/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shokanharaishikyushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険償還払支給申請書Itemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanharaiShikyuShinseishoItem {

    private final RString hihokenshaNameKana;
    private final RString hokenshaNo;
    private final RString hihokenshaName;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString telNo;
    private final RString yubinNo;
    private final RString hihokenJusho;
    private final RString shiseiBun;
    private final RString chuiBun;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNameKana フリガナ
     * @param hokenshaNo 証記載保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNo 被保険者番号
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param telNo 電話番号
     * @param yubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param shiseiBun 申請文
     * @param chuiBun 注意文
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者
     */
    public ShokanharaiShikyuShinseishoItem(RString hihokenshaNameKana,
            RString hokenshaNo,
            RString hihokenshaName,
            RString hihokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString telNo,
            RString yubinNo,
            RString hihokenJusho,
            RString shiseiBun,
            RString chuiBun,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.telNo = telNo;
        this.yubinNo = yubinNo;
        this.hihokenJusho = hihokenJusho;
        this.shiseiBun = shiseiBun;
        this.chuiBun = chuiBun;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;

    }
}
