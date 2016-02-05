/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem {

    private final RString hihokenshaNameKana;
    private final RString hokenshaNo;
    private final RString hihokenshaName;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString yubinNo;
    private final RString telNo;
    private final RString hihokenJusho;
    private final RString shiseiBun;
    private final RString douiBun;
    private final RString chuiBun;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * インスタンスを生成します。
     *
     * @param hihokenshaNameKana 氏名フリガナ
     * @param hokenshaNo 保険者番号
     * @param hihokenshaName 氏名
     * @param hihokenshaNo 介護保険被保険者番号
     * @param birthYMD 生年月日
     * @param yubinNo 郵便番号
     * @param telNo 電話番号
     * @param hihokenJusho 住所
     * @param shiseiBun 申請文
     * @param douiBun 委任文
     * @param chuiBun 注意文
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者役職名
     */
    public JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem(
            RString hihokenshaNameKana,
            RString hokenshaNo,
            RString hihokenshaName,
            RString hihokenshaNo,
            RString birthYMD,
            RString yubinNo,
            RString telNo,
            RString hihokenJusho,
            RString shiseiBun,
            RString douiBun,
            RString chuiBun,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.birthYMD = birthYMD;
        this.yubinNo = yubinNo;
        this.telNo = telNo;
        this.hihokenJusho = hihokenJusho;
        this.shiseiBun = shiseiBun;
        this.douiBun = douiBun;
        this.chuiBun = chuiBun;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
