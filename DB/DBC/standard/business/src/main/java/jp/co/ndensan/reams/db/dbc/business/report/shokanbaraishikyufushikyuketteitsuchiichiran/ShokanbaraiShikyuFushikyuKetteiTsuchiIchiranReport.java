/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知一覧表覧表のReportです。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport extends Report<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> {

    private final List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     * @return 償還払支給（不支給）決定通知一覧表覧表のReport
     */
    public static ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport createFrom(
            List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList) {

        return new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     */
    protected ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport(
            List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> reportSourceWriter) {
        for (ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item : itemList) {
            IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor editor = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranEditor(item);
            IShokanbaraiShikyuFushikyuKetteiTsuchiIchiranBuilder builder = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
