/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem {

    private final RString serviceYM;
    private final RString hassobiYMD;
    private final RString hokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString telNo;
    private final RString yubinNo;
    private final RString jusho;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * インスタンスを生成します。
     *
     * @param serviceYM サービス提供年月
     * @param hassobiYMD 発送日
     * @param hokenshaNo 保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNo 被保険者番号
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param telNo 電話番号
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者
     */
    public KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem(
            RString serviceYM,
            RString hassobiYMD,
            RString hokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString hihokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString telNo,
            RString yubinNo,
            RString jusho,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.serviceYM = serviceYM;
        this.hassobiYMD = hassobiYMD;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.telNo = telNo;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
