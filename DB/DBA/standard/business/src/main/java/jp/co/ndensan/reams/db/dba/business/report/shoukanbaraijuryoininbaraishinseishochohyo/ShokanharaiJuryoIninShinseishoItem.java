/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険償還払受領委任払申請書のEntityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanharaiJuryoIninShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString birthYMD;
    private final RString chuiBun;
    private final RString hihokenJusho;
    private final RString hihokenshaName;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaNo;
    private final RString hokenshaNo;
    private final RString remban;
    private final RString seibetsu;
    private final RString shiseiBun;
    private final RString telNo;
    private final RString yubinNo;

    /**
     * コンストラクタです。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param birthYMD 生年月日
     * @param chuiBun 注意文
     * @param hihokenJusho 住所
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaNo 被保険者番号
     * @param hokenshaNo 保険者番号
     * @param remban 連番
     * @param seibetsu 性別
     * @param shiseiBun 申請文
     * @param telNo 電話番号
     * @param yubinNo 郵便番号
     */
    public ShokanharaiJuryoIninShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString birthYMD,
            RString chuiBun,
            RString hihokenJusho,
            RString hihokenshaName,
            RString hihokenshaNameKana,
            RString hihokenshaNo,
            RString hokenshaNo,
            RString remban,
            RString seibetsu,
            RString shiseiBun,
            RString telNo,
            RString yubinNo) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.birthYMD = birthYMD;
        this.chuiBun = chuiBun;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaNo = hihokenshaNo;
        this.hokenshaNo = hokenshaNo;
        this.remban = remban;
        this.seibetsu = seibetsu;
        this.shiseiBun = shiseiBun;
        this.telNo = telNo;
        this.yubinNo = yubinNo;
    }
}
