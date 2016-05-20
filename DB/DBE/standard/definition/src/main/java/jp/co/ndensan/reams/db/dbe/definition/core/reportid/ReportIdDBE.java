/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBE-9999-021 zhangzhiming
 */
public enum ReportIdDBE {

    /**
     * 医療機関・主治医一覧表の帳票ID。
     */
    DBE591001(new ReportId("DBE591001_ShujiiIryokikanShujiiIchiranhyo"), new RString("医療機関・主治医一覧表")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE230001(new ReportId("DBE230001_ShujiiIkenshoSakuseiIraisho"), new RString("主治医意見書作成依頼書")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE223002(
            new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo"), new RString("主治医意見書督促対象者一覧表")),
    /**
     * 要介護認定調査票（基本調査）（枠有 カラー印刷片面用）の帳票ＩＤです。
     */
    DBE221002(new ReportId("DBE221002_ChosahyoKihonchosaKatamen"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 要介護認定調査票（基本調査）（枠有 カラー印刷両面用）の帳票ＩＤです。
     */
    DBE221003(new ReportId("DBE221003_ChosahyoKihonchosaRyomen"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 認定調査依頼発行一覧表の帳票ＩＤです。
     */
    DBE220003(new ReportId("DBE220003_ChosaIraiHakkoIchiranhyo"), new RString("認定調査依頼発行一覧表")),
    /**
     * 認定調査依頼発行一覧表の帳票ＩＤです。
     */
    DBE233001(new ReportId("DBE233001_ShujiiIkenshoSakuseiTokusokujo"), new RString("主治医意見書提出督促状")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230002(
            new ReportId("DBE230002_IkenshoSakuseiIraiIchiranhyo"), new RString("主治医意見書作成依頼一覧")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230003(
            new ReportId("DBE230003_IkenshoSakuseiIraiHakkoIchiranhyo"), new RString("主治医意見書作成依頼発行一覧表")),
    /**
     * 要介護認定業務進捗状況一覧表の帳票ＩＤです。
     */
    DBE521002(new ReportId("DBE521002_NiteiGyomuShinchokuJokyoIchiranhyo"), new RString("要介護認定業務進捗状況一覧表")),
    /**
     * 認定調査スケジュール表(事務所)の帳票ＩＤです。
     */
    DBE202002(new ReportId("DBE202002_ChosaSchedulehyo"), new RString("認定調査スケジュール表(事務所)")),
    /**
     * 認定調査スケジュール表(時間管理)の帳票ＩＤです。
     */
    DBE202011(new ReportId("DBE202011_ChosaSchedulehyo"), new RString("認定調査スケジュール表(時間管理)")),
    /**
     * 認定調査スケジュール表(調査員)の帳票ＩＤです。
     */
    DBE202001(new ReportId("DBE202001_ChosaSchedulehyo"), new RString("認定調査スケジュール表(調査員)")),
    /**
     * 介護保険診断命令書の帳票ＩＤです。
     */
    DBE235001(new ReportId("DBE235001_kaigohokenShindanMeireisho"), new RString("介護保険診断命令書")),
    /**
     * 認定調査依頼一覧表の帳票ＩＤです。
     */
    DBE220002(
            new ReportId("DBE220002_ChosaIraiIchiranhyo"), new RString("認定調査依頼一覧表")),
    /**
     * 要介護認定調査依頼書の帳票ＩＤです。
     */
    DBE220001(
            new ReportId("DBE220001_ChosaIraisho"), new RString("要介護認定調査依頼書")),
    /**
     * 介護認定審査会スケジュール表です。
     */
    DBE514001(
            new ReportId("DBE514001_Shinsakaisukejuruhyo"), new RString("介護認定審査会スケジュール表")),
    /**
     * 要介護認定結果通知対象者一覧表です。
     */
    DBE525005(
            new ReportId("DBE525005_KekkatsuchiTaishoshaIchiran"), new RString("要介護認定結果通知対象者一覧表")),
    /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書です。
     */
    DBE236001(
            new ReportId("DBE236001_ShujiiIkenshoTeishutsuIraisho"), new RString("介護保険指定医依頼兼主治医意見書提出依頼書")),
    /**
     * 要介護認定調査督促状です。
     */
    DBE223001_NinteiChosaTokusokujo(
            new ReportId("DBE223001_NinteiChosaTokusokujo"), new RString("要介護認定調査督促状")),
    /**
     * 要介護認定・要支援認定等申請者一覧です。
     */
    DBE011001(
            new ReportId("DBE011001_yokaigoyoshienshinseiichiran"), new RString("要介護認定・要支援認定等申請者一覧")),
    /**
     * 認定調査督促対象者一覧表です。
     */
    DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo(
            new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo"), new RString("認定調査督促対象者一覧表")),
    /**
     * 主治医意見書作成料請求書です。
     */
    DBE234001(new ReportId("DBE234001_ShujiiIkenshoSakuseiRyoSeikyusho"), new RString("主治医意見書作成料請求書")),
    /**
     * 介護認定審査会スケジュール表かがみの帳票ID。
     */
    DBE514002(new ReportId("DBE514002_Shinsaschedulekagami"), new RString("介護認定審査会スケジュール表かがみ")),
    /**
     * 要介護認定調査票（概況調査）の帳票ＩＤです。
     */
    DBE221011(new ReportId("DBE221011_chosahyoGaikyochosa"), new RString("要介護認定調査票（概況調査）")),
    /**
     * 要介護認定調査票（概況調査）の帳票ＩＤです。
     */
    DBE221001(new ReportId("DBE221001_ChosahyoGaikyochosa"), new RString("要介護認定調査票（概況調査）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221022_1(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221021(new ReportId("DBE221021_chosahyoTokkijiko"), new RString("DBE221021_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221023(new ReportId("DBE221023_chosahyoTokkijiko"), new RString("DBE221023_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221024(new ReportId("DBE221024_chosahyoTokkijiko"), new RString("DBE221024_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221041(new ReportId("DBE221041_tokkijikoOCR"), new RString("DBE221041_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221042(new ReportId("DBE221042_tokkijikoOCR"), new RString("DBE221042_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221043(new ReportId("DBE221043_tokkijikoOCR"), new RString("DBE221043_要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（特記事項）フリー様式の帳票ＩＤです。
     */
    DBE221022_2(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）フリー様式")),
    /**
     * 要介護認定調査票（基本調査）の帳票ＩＤです。
     */
    DBE221012(new ReportId("DBE221012_chosahyoKihonchosa"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 前回認定調査結果との比較表の帳票ＩＤです。
     */
    DBE293001(new ReportId("DBE293001_ChosahyoSaiCheckhyo"), new RString("前回認定調査結果との比較表")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE292001(new ReportId("DBE292001_SaiChekkuhyo"), new RString("要介護認定調査票差異チェック票")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE701001(new ReportId("DBE701001_ShinsaHanteiJokyo"), new RString("介護認定審査会判定状況表")),
    /**
     * 要介護認定調査票差異チェック票(両面)の帳票ＩＤです。
     */
    DBE292001_Ryoumen(new ReportId("SaiChekkuhyoRyoumen"), new RString("要介護認定調査票差異チェック票")),
    /**
     * 介護認定審査会集計表（現在の状況別）の帳票ＩＤです。
     */
    DBE701009(new ReportId("DBE701009_ShinsakaiShukeiGenzainojokyo"), new RString("介護認定審査会集計表（現在の状況別）")),
    /**
     * 要介護認定実施状況統計の帳票ＩＤです。
     */
    DBE701003(new ReportId("DBE701003_JisshiJokyoTokei"), new RString("要介護認定実施状況統計")),
    /**
     * 要介護認定実施状況統計の帳票ＩＤです。
     */
    DBE702001(new ReportId("DBE702001_JigyoJokyoHokoku"), new RString("要介護認定事業状況報告")),
    /**
     * 要介護認定判定結果一覧表の帳票ＩＤです。
     */
    DBE525001(new ReportId("DBE525001_hanteikekkaichiranA4"), new RString("要介護認定判定結果一覧表")),
    /**
     * 要介護認定判定結果一覧表Ａ３版の帳票ＩＤです。
     */
    DBE525002(new ReportId("DBE525002_HanteiKekkaIchiranA3"), new RString("要介護認定判定結果一覧表Ａ３版")),
    /**
     * 介護認定審査判定結果（鑑）の帳票ＩＤです。
     */
    DBE525006(new ReportId("DBE525006_HanteikekkaKagami"), new RString("介護認定審査判定結果（鑑）")),
    /**
     * 介護認定審査会議事録の帳票ＩＤです。
     */
    DBE525003(new ReportId("DBE525003_ShinsakaiGijiroku"), new RString("介護認定審査会議事録")),
    /**
     * 要介護認定結果通知一覧表の帳票ＩＤです。
     */
    DBE525004(new ReportId("DBE525004_kekkatsuchiIchiranhyo"), new RString("要介護認定結果通知一覧表")),
    /**
     * 認定調査委託先・認定調査員一覧表の帳票ＩＤです。
     */
    DBE592001(new ReportId("DBE592001_ChosaItakusakiNinteiChosainIchiranhyo"), new RString("認定調査委託先・認定調査員一覧表")),
    /**
     * 介護認定審査会スケジュール表（年間）の帳票ＩＤです。
     */
    DBE514003(new ReportId("DBE514003_shinsakainenkansukejuruhyo"), new RString("介護認定審査会スケジュール表（年間）")),
    /**
     * 要介護状態区分別判定件数の帳票ＩＤです。
     */
    DBE701005(new ReportId("DBE701005_Jotaikubumbetsuhantei"), new RString("要介護状態区分別判定件数")),
    /**
     * 審査判定の変更状況の帳票ＩＤです。
     */
    DBE701006(new ReportId("DBE701006_ShinsahanteinoHenkojokyo"), new RString("審査判定の変更状況")),
    /**
     * 介護認定審査会集計表（判定別）の帳票ＩＤです。
     */
    DBE701007(new ReportId("DBE701007_shinsakaishukeihyoHanteibetsu"), new RString("介護認定審査会集計表（判定別）")),
    /**
     * 介護認定審査会集計表（判定別）の帳票ＩＤです。
     */
    DBE701008(new ReportId("DBE701008_ShinsakaiShukeihyo"), new RString("介護認定審査会集計表（申請区分別）")),
    /**
     * 要介護認定情報提供その他資料情報の帳票ＩＤです。
     */
    DBE517016(new ReportId("DBE517016_SonotashiryoA4"), new RString("その他資料")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001(new ReportId("DBE231001_ikenshokinyuyoshi"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 主治医意見書帳票ＩＤです。
     */
    DBE517151(new ReportId("DBE517151_Shujiiikensho"), new RString("主治医意見書")),
    /**
     * 一次判定結果ＩＤです。
     */
    DBE517181(new ReportId("DBE517181_IchijihanteikekkahyoA4"), new RString("一次判定結果")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091002(new ReportId("DBE091002_NinteiChosaJohohyo"), new RString("認定調査票情報_09B総合事業")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091012(new ReportId("DBE091012_NinteiChosaJohohyo"), new RString("認定調査票情報_09B")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091022(new ReportId("DBE091022_NinteiChosaJohohyo"), new RString("認定調査票情報_09A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091032(new ReportId("DBE091032_06ANinteiChosaJohohyo"), new RString("認定調査票情報_06A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091042(new ReportId("DBE091042_02ANinteiChosaJohohyo"), new RString("認定調査票情報_02A")),
    /**
     * 認定調査票情報の帳票ＩＤです。
     */
    DBE091052(new ReportId("DBE091052_99ANinteiChosaJohohyo"), new RString("認定調査票情報_99A"));

    private final ReportId reportId;

    private final RString reportName;

    private ReportIdDBE(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
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
