/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ｓhokanｋetteiｓsuchiｓhoｓealer;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のReportです。
 *
 */
public class ShokanKetteiTsuchiShoSealer2Report extends Report<ShokanKetteiTsuchiShoSealer2ReportSource> {

    private final ShokanKetteiTsuchiShoSealer2Item item;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書督促対象者一覧表のITEM
     * @return 主治医意見書督促対象者一覧表のReport
     */
    public static ShokanKetteiTsuchiShoSealer2Report createFrom(ShokanKetteiTsuchiShoSealer2Item item) {
        return new ShokanKetteiTsuchiShoSealer2Report(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書督促対象者一覧表のITEM
     */
    protected ShokanKetteiTsuchiShoSealer2Report(ShokanKetteiTsuchiShoSealer2Item item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoSealer2ReportSource> reportSourceWriter) {
        ShokanKetteiTsuchiShoSealer2HeadEditor editor = new ShokanKetteiTsuchiShoSealer2HeadEditor(item);
        ShokanKetteiTsuchiShoSealer2BuliderImpl builder = new ShokanKetteiTsuchiShoSealer2BuliderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
