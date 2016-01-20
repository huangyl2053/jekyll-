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
 * 認定調査依頼一覧表ヘッダのITEMです。
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
    private final RString tsuchibun;

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
     * @param tsuchibun 通知文
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
            RString tsuchibun) {
        this.printTimeStamp = printTimeStamp;
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.yubinNo = yubinNo;
        this.shuchoMei = shuchoMei;
        this.jigyoshaJusho = jigyoshaJusho;
        this.denshiKoin = denshiKoin;
        this.koinShoryaku = koinShoryaku;
        this.jigyoshaName = jigyoshaName;
        this.jigyoshaNo = jigyoshaNo;
        this.tsuchibun = tsuchibun;
    }
}
