/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBB {

    /**
     * 調定簿（帳票）
     */
    DBB3001(new ReportId("DBB300001_Choteibo"), new RString("介護保険料　調定簿")),
    /**
     * 賦課台帳（本算定）の帳票ID
     */
    DBB100065(new ReportId("DBB100065_FukaDaicho"), new RString("賦課台帳 本算定")),
    /**
     * 月別推移表の帳票ID。
     */
    DBB300002(new ReportId("DBB300002_TsukibetsuSuiihyo"), new RString("月別推移表")),
    /**
     * 通知書発行後異動対象者一覧の帳票ID
     */
    DBB200028(new ReportId("DBB200028_HakkogoIdoTaishoshaIchiran"), new RString("通知書発行後異動対象者一覧")),
    /**
     * 介護保険料減免決定通知書A4縦タイプ帳票
     */
    DDBB100078(new ReportId("DDBB100078_KaigoHokenryoGenmenKetteiTsuchishoA4Tate"), new RString("介護保険料減免決定通知書A4縦タイプ.")),
    /**
     * 介護保険料減免決定通知書B5横タイプ
     */
    DBB100077(new ReportId("DBB100077_KaigoHokenryoGenmenKetteiTsuchishoB5Yoko"), new RString("介護保険料減免決定通知書B5横タイプ.")),
    /**
     * 賦課台帳（仮算定）の帳票ID
     */
    DBB100031(new ReportId("DBB100031_KarisanteiFukaDaicho"), new RString("賦課台帳 仮算定")),
    /**
     * 保険料納入通知書（本算定）の帳票ID
     */
    DBB200010(new ReportId("DBB200010_NonyuTsuchishoHonsanteiHakkoIchiran"), new RString("保険料納入通知書 本算定")),
    /**
     * 介護保険料額決定通知書発行一覧表の帳票ID
     */
    DBB200012(new ReportId("DBB200012_KaigoHokenryogakuKetteiHenkoTsuchiHakkoIchiran"), new RString("介護保険料額決定通知書発行 一覧表")),
    /**
     * 特別徴収開始通知書（本算定）発行一覧表の帳票ID
     */
    DBB200001(new ReportId("DBB200001_TokubetsuChoshuKaishiTsuchishoKariHakkoIchiran"), new RString("特別徴収開始通知書 本算定"));
    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBB(ReportId reportId, RString reportName) {
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
