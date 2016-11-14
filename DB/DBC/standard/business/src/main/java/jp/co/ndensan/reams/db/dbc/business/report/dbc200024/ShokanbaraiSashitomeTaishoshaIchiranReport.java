/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200024;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200024.ShokanbaraiSashitomeTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200024_償還払支給差止対象者一覧表のReport
 *
 * @reamsid_L DBC-1000-160 liwul
 */
public class ShokanbaraiSashitomeTaishoshaIchiranReport extends Report<ShokanbaraiSashitomeTaishoshaIchiranSource> {

    private final List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     */
    protected ShokanbaraiSashitomeTaishoshaIchiranReport(
            List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     * @return 償還払支給（不支給）決定通知一覧表覧表のReport
     */
    public static ShokanbaraiSashitomeTaishoshaIchiranReport createFrom(
            List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList) {
        return new ShokanbaraiSashitomeTaishoshaIchiranReport(itemList);
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiSashitomeTaishoshaIchiranSource> writer) {
        for (ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem item : itemList) {
            IShokanbaraiSashitomeTaishoshaIchiranEditor editor = new ShokanbaraiSashitomeTaishoshaIchiranEditor(item);
            IShokanbaraiSashitomeTaishoshaIchiranBuilder builder = new ShokanbaraiSashitomeTaishoshaIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }
}
