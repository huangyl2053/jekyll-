/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査依頼一覧表ヘッダのITEMです
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoHeadItem {

    private final RDateTime printTimeStamp;
    private final RString shomeiHakkoYMD;
    private final RString yubinNo;
    private final RString shuchoMei;
    private final RString jigyoshaJusho;
    private final RString koinShoryaku;
    private final RString denshiKoin;
    private final RString jigyoshaName;
    private final RString jigyoshaNo;
    private final RString tsuchibun1;
    private final RString tsuchibun2;
    private final RString tsuchibun3;
    private final RString tsuchibun4;
    private final RString tsuchibun5;
    private final RString tsuchibun6;
    private final RString tsuchibun7;
    private final RString tsuchibun8;
    private final RString tsuchibun9;
    private final RString tsuchibun10;
    private final RString tsuchibun11;
    private final RString tsuchibun12;
    private final RString tsuchibun13;
    private final RString tsuchibun14;
    private final RString tsuchibun15;
    private final RString tsuchibun16;
    private final RString tsuchibun17;
    private final RString tsuchibun18;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 印刷時点
     * @param shomeiHakkoYMD 証明発行YMD
     * @param yubinNo 郵便番号
     * @param shuchoMei 首長名
     * @param jigyoshaJusho 事業所住所
     * @param koinShoryaku 公印省略
     * @param denshiKoin 電子公印
     * @param jigyoshaName 事業所名
     * @param jigyoshaNo 事業所の番号
     * @param tsuchibun1 通知文
     * @param tsuchibun2 通知文
     * @param tsuchibun3 通知文
     * @param tsuchibun4 通知文
     * @param tsuchibun5 通知文
     * @param tsuchibun6 通知文
     * @param tsuchibun7 通知文
     * @param tsuchibun8 通知文
     * @param tsuchibun9 通知文
     * @param tsuchibun10 通知文
     * @param tsuchibun11 通知文
     * @param tsuchibun12 通知文
     * @param tsuchibun13 通知文
     * @param tsuchibun14 通知文
     * @param tsuchibun15 通知文
     * @param tsuchibun16 通知文
     * @param tsuchibun17 通知文
     * @param tsuchibun18 通知文
     */
    public ChosaIraiIchiranhyoHeadItem(
            RDateTime printTimeStamp,
            RString shomeiHakkoYMD,
            RString yubinNo,
            RString shuchoMei,
            RString jigyoshaJusho,
            RString denshiKoin,
            RString koinShoryaku,
            RString jigyoshaName,
            RString jigyoshaNo,
            RString tsuchibun1,
            RString tsuchibun2,
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
            RString tsuchibun18) {
        this.printTimeStamp = printTimeStamp;
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.yubinNo = yubinNo;
        this.shuchoMei = shuchoMei;
        this.jigyoshaJusho = jigyoshaJusho;
        this.denshiKoin = denshiKoin;
        this.koinShoryaku = koinShoryaku;
        this.jigyoshaName = jigyoshaName;
        this.jigyoshaNo = jigyoshaNo;
        this.tsuchibun1 = tsuchibun1;
        this.tsuchibun2 = tsuchibun2;
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
        this.tsuchibun18 = tsuchibun18;
    }
}
