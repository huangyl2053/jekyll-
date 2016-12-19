/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBA-9999-021 zhengsongling
 */
public enum ReportIdDBZ {

    /**
     * 要介護認定調査票差異チェック票(両面左)の帳票ＩＤです。
     */
    DBE292003(new ReportId("DBE292003_SaiChekkuhyoHidari"), new RString("要介護認定調査票差異チェック票(両面左)")),
    /**
     * 要介護認定調査票差異チェック票(両面右)の帳票ＩＤです。
     */
    DBE292002(new ReportId("DBE292002_SaiChekkuhyoMigi"), new RString("要介護認定調査票差異チェック票(両面右)")),
    /**
     * 主治医意見書作成料請求書です。
     */
    DBE234001(new ReportId("DBE234001_ShujiiIkenshoSakuseiRyoSeikyusho"), new RString("主治医意見書作成料請求書")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE230001(new ReportId("DBE230001_ShujiiIkenshoSakuseiIraisho"), new RString("主治医意見書作成依頼書")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE292001(new ReportId("DBE292001_SaiChekkuhyo"), new RString("要介護認定調査票差異チェック票")),
    /**
     * 要介護認定調査票（概況特記）の帳票ID。
     */
    DBE221051(new ReportId("DBE221051_GaikyotokkiA4"), new RString("要介護認定調査票（概況特記）")),
    /**
     * 要介護認定調査票（デザイン）両面の帳票ＩＤです。
     */
    DBE221001(new ReportId("DBE221001_ChosahyoDesignRyomen"), new RString("要介護認定調査票（デザイン用紙）")),
    /**
     * 要介護認定調査票（デザイン）片面の帳票ＩＤです。
     */
    DBE221002(new ReportId("DBE221002_ChosahyoDesignKatamen"), new RString("要介護認定調査票（デザイン用紙）")),
    /**
     * 要介護認定調査票OCR両面の帳票ＩＤです。
     */
    DBE221011(new ReportId("DBE221011_ChosahyoOcrRyomen"), new RString("要介護認定調査票（OCR）")),
    /**
     * 要介護認定調査票OCR片面の帳票ＩＤです。
     */
    DBE221012(new ReportId("DBE221012_ChosahyoOcrKatamen"), new RString("要介護認定調査票（OCR）")),
    /**
     * 要介護認定調査票（特記事項）デザイン用紙の帳票ＩＤです。
     */
    DBE221003(new ReportId("DBE221003_ChosahyoTokkijikoDesign"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）OCR両面の帳票ＩＤです。
     */
    DBE221031(new ReportId("DBE221031_ChosahyoTokkijikoOcrRyomen"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）OCR片面の帳票ＩＤです。
     */
    DBE221032(new ReportId("DBE221032_ChosahyoTokkijikoOcrKatamen"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）項目有りの帳票ＩＤです。
     */
    DBE221021(new ReportId("DBE221021_ChosahyoTokkijikoKomokuAri"), new RString("要介護認定調査票（特記事項）項目有り")),
    /**
     * 要介護認定調査票（特記事項）項目無しの帳票ＩＤです。
     */
    DBE221022(new ReportId("DBE221022_ChosahyoTokkijikoKomokuNashi"), new RString("要介護認定調査票（特記事項）項目無し")),
    /**
     * 要介護認定調査票（特記事項）フリー様式の帳票ＩＤです。
     */
    DBE221023(new ReportId("DBE221023_ChosahyoTokkijikoFree"), new RString("要介護認定調査票（特記事項）フリー様式")),
    /**
     * 要介護認定調査票（特記事項）項目有り（手入力）の帳票ＩＤです。
     */
    DBE221024(new ReportId("DBE221024_ChosahyoTokkijikoKomokuAriTenyuryoku"), new RString("要介護認定調査票（特記事項）項目有り")),
    /**
     * 要介護認定調査票（特記事項）項目無し（手入力）の帳票ＩＤです。
     */
    DBE221025(new ReportId("DBE221025_ChosahyoTokkijikoKomokuNashiTenyuryoku"), new RString("要介護認定調査票（特記事項）項目無し")),
    /**
     * 要介護認定調査票（特記事項）フリー様式（手入力）の帳票ＩＤです。
     */
    DBE221026(new ReportId("DBE221026_ChosahyoTokkijikoFreeTenyuryoku"), new RString("要介護認定調査票（特記事項）フリー様式")),
    /**
     * 認定調査票（特記事項）-調査項目有り-白黒の帳票ＩＤです。
     */
    DBE221021_Ari_Mono(new ReportId("DBE221021_chosahyoTokkijiko_Ari_Mono"), getReportName複数()),
    /**
     * 認定調査票（特記事項）-調査項目有り-カラーの帳票ＩＤです。
     */
    DBE221021_Ari_Color(new ReportId("DBE221021_chosahyoTokkijiko_Ari_Color"), getReportName複数()),
    /**
     * 認定調査票（特記事項）-調査項目なし-白黒の帳票ＩＤです。
     */
    DBE221024_Nashi_Mono(new ReportId("DBE221024_chosahyoTokkijiko_Nashi_Mono"), getReportName複数()),
    /**
     * 認定調査票（特記事項）-調査項目なし-カラーの帳票ＩＤです。
     */
    DBE221024_Nashi_Color(new ReportId("DBE221024_chosahyoTokkijiko_Nashi_Color"), getReportName複数()),
    /**
     * 認定調査票OCR（特記事項）-両面の帳票ＩＤです。
     */
    DBE221042_Ryomen(new ReportId("DBE221042_tokkijikoOCR_Ryomen"), new RString("認定調査票OCR（特記事項）")),
    /**
     * 認定調査票OCR（特記事項）-片面の帳票ＩＤです。
     */
    DBE221042_Katamen(new ReportId("DBE221042_tokkijikoOCR_Katamen"), new RString("認定調査票OCR（特記事項）")),
    /**
     * 介護保険診断命令書の帳票ＩＤです。
     */
    DBE235001(new ReportId("DBE235001_kaigohokenShindanMeireisho"), new RString("介護保険診断命令書")),
    /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書です。
     */
    DBE236001(
            new ReportId("DBE236001_ShujiiIkenshoTeishutsuIraisho"), new RString("介護保険指定医依頼兼主治医意見書提出依頼書")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230002(
            new ReportId("DBE230002_IkenshoSakuseiIraiIchiranhyo"), new RString("主治医意見書作成依頼一覧")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001(new ReportId("DBE231001_ikenshokinyuyoshi"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001_Ryomen_Mono(new ReportId("DBE231001_ikenshokinyuyoshi_Ryomen_Mono"), new RString("主治医意見書記入用紙")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001_Katamen_Mono(new ReportId("DBE231001_ikenshokinyuyoshi_Katamen_Mono"), new RString("主治医意見書記入用紙")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231011_Ryomen_Color(new ReportId("DBE231011_ikenshokinyuyoshiOCR_Ryomen_Color"), new RString("主治医意見書記入用紙OCR")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231011_Katamen_Color(new ReportId("DBE231011_ikenshokinyuyoshiOCR_Katamen_Color"), new RString("主治医意見書記入用紙OCR")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231012(new ReportId("DBE231012_ikenshokinyuyoshiOCR"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231014(new ReportId("DBE231014_ikenshokinyuyoshiOCR"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 要介護認定調査依頼書の帳票ＩＤです。
     */
    DBE220001(
            new ReportId("DBE220001_ChosaIraisho"), new RString("要介護認定調査依頼書")),
    /**
     * 認定調査依頼一覧表の帳票ＩＤです。
     */
    DBE220002(
            new ReportId("DBE220002_ChosaIraiIchiranhyo"), new RString("認定調査依頼一覧表")),
    /**
     * 宛名シールの帳票ＩＤです。
     */
    DBZ100001(new ReportId("DBZ100001_AtenaSeal"), new RString("宛名シール")),
    /**
     * 汎用リストの帳票ＩＤです。
     */
    DBZ700001(new ReportId("DBZ700001_HanyoList"), new RString("汎用リスト"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBZ(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    private static RString getReportName複数() {
        return new RString("認定調査票（特記事項）");
    }

    /**
     * 帳票ＩＤの取得します。
     *
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     *
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }

}
