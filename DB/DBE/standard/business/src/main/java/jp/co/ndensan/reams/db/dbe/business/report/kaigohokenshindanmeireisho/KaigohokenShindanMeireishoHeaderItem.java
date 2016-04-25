/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険診断命令書のITEMです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigohokenShindanMeireishoHeaderItem {

    private RString shomeiHakkoYMD;
    private RString shichosonMei;
    private RString shuchoMei;
    private RString koinShoryaku;
    private RString denshiKoin;
    private RString bunshoNo;
    private RString hakkoYMD;
    private RString tsuchibun1;
    private RString tsuchibun2;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString iryokikanName;
    private RString tantoIshiName;
    private RString iryokikanJusho;
    private RString telNo;
    private RString jushinKikan;
    private RString jushinArea;
    private RString tsuchibun3;
    private RString tsuchibun4;
    private RString tsuchibun5;
    private RString tsuchibun6;
    private RString tsuchibun7;
    private RString tsuchibun8;
    private RString tsuchibun9;
    private RString tsuchibun10;
    private RString tsuchibun11;
    private RString tsuchibun12;
    private RString tsuchibun13;
    private RString tsuchibun14;
    private RString tsuchibun15;
    private RString tsuchibun16;
    private RString tsuchibun17;
    private RString remban;

    /**
     * インスタンスを生成します。
     */
    public KaigohokenShindanMeireishoHeaderItem() {
    }

    /**
     * インスタンスを生成します。
     *
     * @param shomeiHakkoYMD 証明発行YMD
     * @param shichosonMei 市町村名
     * @param shuchoMei 首長名
     * @param koinShoryaku 公印省略
     * @param denshiKoin 電子公印
     * @param bunshoNo 文書番号
     * @param hakkoYMD 発行YMD
     * @param tsuchibun1 通知文１
     * @param tsuchibun2 通知文２
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param iryokikanName 診断を行う医療機関．名称
     * @param tantoIshiName 診断を行う医療機関．担当医師名
     * @param iryokikanJusho 診断を行う医療機関．所在地
     * @param telNo 診断を行う医療機関．電話番号
     * @param jushinKikan 診断を受ける日時
     * @param jushinArea 診断を受ける場所
     * @param tsuchibun3 通知文3
     * @param tsuchibun4 通知文4
     * @param tsuchibun5 通知文5
     * @param tsuchibun6 通知文6
     * @param tsuchibun7 通知文7
     * @param tsuchibun8 通知文7
     * @param tsuchibun9 通知文9
     * @param tsuchibun10 通知文10
     * @param tsuchibun11 通知文11
     * @param tsuchibun12 通知文12
     * @param tsuchibun13 通知文13
     * @param tsuchibun14 通知文14
     * @param tsuchibun15 通知文15
     * @param tsuchibun16 通知文16
     * @param tsuchibun17 通知文17
     * @param remban 連番
     */
    public KaigohokenShindanMeireishoHeaderItem(
            RString shomeiHakkoYMD,
            RString shichosonMei,
            RString shuchoMei,
            RString koinShoryaku,
            RString denshiKoin,
            RString bunshoNo,
            RString hakkoYMD,
            RString tsuchibun1,
            RString tsuchibun2,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString iryokikanName,
            RString tantoIshiName,
            RString iryokikanJusho,
            RString telNo,
            RString jushinKikan,
            RString jushinArea,
            RString tsuchibun3,
            RString tsuchibun4,
            RString tsuchibun5,
            RString tsuchibun6,
            RString tsuchibun7,
            RString tsuchibun8,
            RString tsuchibun9,
            RString tsuchibun10,
            RString tsuchibun11,
            RString tsuchibun12,
            RString tsuchibun13,
            RString tsuchibun14,
            RString tsuchibun15,
            RString tsuchibun16,
            RString tsuchibun17,
            RString remban) {
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.shichosonMei = shichosonMei;
        this.shuchoMei = shuchoMei;
        this.koinShoryaku = koinShoryaku;
        this.denshiKoin = denshiKoin;
        this.bunshoNo = bunshoNo;
        this.hakkoYMD = hakkoYMD;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.iryokikanName = iryokikanName;
        this.tantoIshiName = tantoIshiName;
        this.iryokikanJusho = iryokikanJusho;
        this.telNo = telNo;
        this.jushinKikan = jushinKikan;
        this.jushinArea = jushinArea;
        this.tsuchibun3 = tsuchibun3;
        this.tsuchibun4 = tsuchibun4;
        this.tsuchibun5 = tsuchibun5;
        this.tsuchibun6 = tsuchibun6;
        this.tsuchibun7 = tsuchibun7;
        this.tsuchibun8 = tsuchibun8;
        this.tsuchibun9 = tsuchibun9;
        this.tsuchibun10 = tsuchibun10;
        this.tsuchibun11 = tsuchibun11;
        this.tsuchibun12 = tsuchibun12;
        this.tsuchibun13 = tsuchibun13;
        this.tsuchibun14 = tsuchibun14;
        this.tsuchibun15 = tsuchibun15;
        this.tsuchibun16 = tsuchibun16;
        this.tsuchibun17 = tsuchibun17;
        this.remban = remban;
    }
}
