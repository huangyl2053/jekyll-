/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBU {

    /**
     * 介護事業状況報告月報・保険給付決定状況（様式2）の帳票ID。
     */
    DBU300022(new ReportId("DBU300022_JigyohokokuGeppoYoshiki2_2_2016"), new RString("介護事業状況報告月報・保険給付決定状況（様式2）")),
    /**
     * 介護事業状況報告月報・保険給付決定状況（様式2）の帳票ID。
     */
    DBU300021(new ReportId("DBU300021_JigyohokokuGeppoYoshiki2_1_2016"), new RString("介護事業状況報告月報・保険給付決定状況（様式2）")),
    /**
     * 介護保険連絡票の帳票ID。
     */
    DBU100002(new ReportId("DBU100002_KaigohokenRenrakuhyo"), new RString("介護保険連絡票")),
    /**
     * 介護保険連絡票_実質負担軽減者用の帳票ID。
     */
    DBU100003(new ReportId("DBU100003_KaigohokenRenrakuhyoJisshitsuFutan"), new RString("介護保険連絡票_実質負担軽減者用")),
    /**
     * 境界層管理マスタリストの帳票ID。
     */
    DBA200005(new ReportId("DBU200003_KyokaisoKanriMasterList"), new RString("境界層管理マスタリスト")),
    /**
     * 弁明書の帳票ＩＤです。
     */
    DBU100001(new ReportId("DBU100001_Bemmeisyo"), new RString("弁明書")),
    /**
     * 介護保険　広域内転居結果一覧表の帳票ＩＤです。
     */
    DBU200004(new ReportId("DBU200004_KoikinaiTenkyoKekkaIchiranhyo"), new RString("介護保険　広域内転居結果一覧表")),
    /**
     * 介護事業状況報告月報・一般状況（様式1-4）の帳票ＩＤです。
     */
    DBU300003(new ReportId("DBU300002_JigyohokokuCompYoshiki1_2"), new RString("介護事業状況報告月報・一般状況（様式1-3）")),
    /**
     * 介護事業状況報告月報・一般状況（様式1-4）の帳票ＩＤです。
     */
    DBU300004(new ReportId("DBU300004_JigyohokokuCompYoshiki1_4"), new RString("介護事業状況報告月報・一般状況（様式1-4）")),
    /**
     * 介護事業状況報告月報・一般状況（様式1-5）の帳票ＩＤです。
     */
    DBU300005(new ReportId("DBU300005_JigyohokokuCompYoshiki1_5_1"), new RString("介護事業状況報告月報・一般状況（様式1-5）")),
    /**
     * 介護事業状況報告月報・一般状況（様式1-5）_新様式の帳票ＩＤです。
     */
    DBU300006(new ReportId("DBU300006_JigyohokokuCompYoshiki1_5_2"), new RString("介護事業状況報告月報・一般状況（様式1-5）_新様式")),
    /**
     * 介護事業状況報告月報・一般状況（様式1-5）_新様式の帳票ＩＤです。
     */
    DBU300007(new ReportId("DBU300007_JigyohokokuCompYoshiki1_5_3"), new RString("介護事業状況報告月報・一般状況（様式1-5）_新様式")),
    /**
     * 介護事業状況報告月報・一般状況（別紙）の帳票ＩＤです。
     */
    DBU300008(new ReportId("DBU300008_JigyohokokuGeppoYoshikiBesshi"), new RString("介護事業状況報告月報・一般状況（別紙）")),
    /**
     * 介護事業状況報告月報・一般状況（様式1）の帳票ＩＤです。
     */
    DBU300001(new ReportId("DBU300001_JigyohokokuGeppoYoshiki1"), new RString("介護事業状況報告月報・一般状況（様式1）")),
    /**
     * 介護保険　広域内転居結果一覧表の帳票ＩＤです。
     */
    DBU300002(new ReportId("DBU300002_JigyohokokuCompYoshiki1_2"), new RString("介護保険　広域内転居結果一覧表")),
    /**
     * 処理結果確認リストの帳票ＩＤです。
     */
    DBU200002(new ReportId("DBU200002_ShoriKekkaKakuninList"), new RString("処理結果確認リスト")),
    /**
     * 介護事業状況報告月報・保険給付決定状況（様式2-7）の帳票ＩＤです。
     */
    DBU300020(new ReportId("DBU300020_JigyohokokuGeppoYoshiki2_7of2"), new RString("介護事業状況報告月報・保険給付決定状況（様式2-7）")),
    /**
     * 介護事業状況報告月報・保険給付決定状況（様式2-7）の帳票ＩＤです。
     */
    DBU300010(new ReportId("DBU300010_JigyohokokuGeppoYoshiki2of2"), new RString("介護事業状況報告月報・保険給付決定状況（様式2）")),
    /**
     * 介護事業状況報告月報（様式2-5）の帳票ＩＤです。
     */
    DBU30017(new ReportId("DBU300017_JigyohokokuCompYoshiki2_5"), new RString("介護事業状況報告月報（様式2-5）")),
    /**
     * 介護事業状況報告月報（様式2-6）の帳票ＩＤです。
     */
    DBU30018(new ReportId("DBU300017_JigyohokokuCompYoshiki2_5"), new RString("介護事業状況報告月報（様式2-6）"));

    private final ReportId reportId;

    private final RString reportName;

    private ReportIdDBU(ReportId reportId, RString reportName) {
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
