/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.reportId;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBE {

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
     * 介護認定審査会スケジュール表
     */
    DBE514001(
            new ReportId("DBE514001_shinsakaisukejuruhyo"), new RString("介護認定審査会スケジュール表")),
    /**
     * 要介護認定結果通知対象者一覧表
     */
    DBE525005(
            new ReportId("DBE525005_KekkatsuchiTaishoshaIchiran"), new RString("要介護認定結果通知対象者一覧表")),
    /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書
     */
    DBE236001(
            new ReportId("DBE236001_ShujiiIkenshoTeishutsuIraisho"), new RString("介護保険指定医依頼兼主治医意見書提出依頼書")),
    /**
     * 要介護認定調査督促状
     */
    DBE223001_NinteiChosaTokusokujo(
            new ReportId("DBE223001_NinteiChosaTokusokujo"), new RString("要介護認定調査督促状")),
    /**
     * 認定調査督促対象者一覧表
     */
    DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo(
            new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo"), new RString("認定調査督促対象者一覧表"));

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
