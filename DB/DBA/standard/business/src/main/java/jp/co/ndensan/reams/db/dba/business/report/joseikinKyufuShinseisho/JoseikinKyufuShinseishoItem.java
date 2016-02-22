/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険助成金給付申請書です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JoseikinKyufuShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString birthYMD;
    private final RString hihokenJusho;
    private final RString hihokenshaName;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaNo;
    private final RString hokenshaNo;
    private final RString remban;
    private final RString seibetsu;
    private final RString telNo;
    private final RString tsuchiBun;
    private final RString yubinNo;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param birthYMD 生年月日
     * @param hihokenJusho 住所
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaNo 被保険者番号
     * @param hokenshaNo 保険者番号
     * @param remban 連番
     * @param seibetsu 性別
     * @param telNo 電話番号
     * @param tsuchiBun 通知文
     * @param yubinNo 郵便番号
     */
    public JoseikinKyufuShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString birthYMD,
            RString hihokenJusho,
            RString hihokenshaName,
            RString hihokenshaNameKana,
            RString hihokenshaNo,
            RString hokenshaNo,
            RString remban,
            RString seibetsu,
            RString telNo,
            RString tsuchiBun,
            RString yubinNo
    ) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.birthYMD = birthYMD;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaNo = hihokenshaNo;
        this.hokenshaNo = hokenshaNo;
        this.remban = remban;
        this.seibetsu = seibetsu;
        this.telNo = telNo;
        this.tsuchiBun = tsuchiBun;
        this.yubinNo = yubinNo;
    }
}
