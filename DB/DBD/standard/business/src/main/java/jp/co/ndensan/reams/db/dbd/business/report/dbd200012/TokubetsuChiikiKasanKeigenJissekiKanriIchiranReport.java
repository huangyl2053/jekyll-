/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200012;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.KyuhuJissekiHihokensha;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別地域加算軽減実績管理リストのReportです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public final class TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport extends
        Report<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> {

    private final TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final KyuhuJissekiHihokensha 宛名;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 TokubetsuChiikiKasanKeigenJissekiKanri
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 宛名 KyuhuJissekiHihokensha
     * @return 特別地域加算軽減実績管理リスト
     */
    public static TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport createReport(
            TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報, Association association,
            IOutputOrder iOutputOrder, KyuhuJissekiHihokensha 宛名) {
        return new TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport(帳票情報, association, iOutputOrder, 宛名);
    }

    private TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport(
            TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報, Association association,
            IOutputOrder iOutputOrder, KyuhuJissekiHihokensha 宛名) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.宛名 = 宛名;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> writer) {
        ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                帳票情報, association, iOutputOrder, 宛名);
        ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }

}
