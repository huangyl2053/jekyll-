/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼一覧のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoSakuseiIraiIchiranhyoItem {

    private final RString shomeiHakkoYMD;
    private final RString shichosonMei;
    private final RString shuchoMei;
    private final RString koinShoryaku;
    private final RString denshiKoin;
    private final RString printTimeStamp;
    private final RString pageCount;
    private final RString title;
    private final RString yubinNo;
    private final RString iryokikanJusho;
    private final RString iryokikanName;
    private final RString no;
    private final RString shujiiName;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString hihokenshaNameKana;
    private final RString jusho;
    private final RString seinengappiYMD;
    private final RString seibetsu;
    private final RString ikenshoSakuseiKigenYMD;
    private final RString toiawasesaki;
    private final RString shujiiIryokikanCode;

    /**
     * インスタンスを生成します。
     *
     * @param shomeiHakkoYMD 証明発行YMD
     * @param shichosonMei 市町村名
     * @param shuchoMei 首長名
     * @param koinShoryaku 公印省略
     * @param denshiKoin 電子公印
     * @param printTimeStamp 発行時間
     * @param pageCount ページ数
     * @param iryokikanName 医療機関名称
     * @param yubinNo 郵便番号
     * @param iryokikanJusho 医療機関住所
     * @param title 帳票名
     * @param no No.
     * @param shujiiName 担当医
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 被保険者名
     * @param hihokenshaNameKana 被保険者名（カナ）
     * @param jusho 住所
     * @param seinengappiYMD 生年月日
     * @param seibetsu 性別
     * @param ikenshoSakuseiKigenYMD 提出期限
     * @param toiawasesaki 問合せ先
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public IkenshoSakuseiIraiIchiranhyoItem(RString shomeiHakkoYMD, RString shichosonMei, RString shuchoMei, RString koinShoryaku,
            RString denshiKoin, RString printTimeStamp, RString pageCount, RString title, RString yubinNo, RString iryokikanJusho,
            RString iryokikanName, RString no, RString shujiiName, RString hihokenshaNo, RString hihokenshaName, RString hihokenshaNameKana,
            RString jusho, RString seinengappiYMD, RString seibetsu, RString ikenshoSakuseiKigenYMD, RString toiawasesaki,
            RString shujiiIryokikanCode) {
        this.shomeiHakkoYMD = shomeiHakkoYMD;
        this.shichosonMei = shichosonMei;
        this.shuchoMei = shuchoMei;
        this.koinShoryaku = koinShoryaku;
        this.denshiKoin = denshiKoin;
        this.printTimeStamp = printTimeStamp;
        this.pageCount = pageCount;
        this.title = title;
        this.yubinNo = yubinNo;
        this.iryokikanJusho = iryokikanJusho;
        this.iryokikanName = iryokikanName;
        this.no = no;
        this.shujiiName = shujiiName;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.jusho = jusho;
        this.seinengappiYMD = seinengappiYMD;
        this.seibetsu = seibetsu;
        this.ikenshoSakuseiKigenYMD = ikenshoSakuseiKigenYMD;
        this.toiawasesaki = toiawasesaki;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }
}
