/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoShujiiIchiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 主治医医療機関・主治医一覧表のReportです。
 */
public class IkenshoShujiiIchiranReport extends Report<ShujiiIryokikanShujiiIchiranhyoReportSource> {

    private final List<IkenshoShujiiIchiranBodyItem> bodyItemList;
    private final IkenshoShujiiIchiranHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医医療機関・主治医一覧表ヘッダのITEM
     * @param itemList 主治医医療機関・主治医一覧表ボディのITEMリスト
     * @return 主治医医療機関・主治医一覧表のReport
     */
    public static IkenshoShujiiIchiranReport createFrom(
            IkenshoShujiiIchiranHeadItem headItem,
            @NonNull List<IkenshoShujiiIchiranBodyItem> itemList) {

        return new IkenshoShujiiIchiranReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医医療機関・主治医一覧表ヘッダのITEM
     * @param itemList 主治医医療機関・主治医一覧表のITEMリスト
     */
    protected IkenshoShujiiIchiranReport(
            IkenshoShujiiIchiranHeadItem headItem,
            List<IkenshoShujiiIchiranBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter) {
        for (IkenshoShujiiIchiranBodyItem bodyItem : bodyItemList) {
            IkenshoShujiiIchiranEditor headerEditor = new IkenshoShujiiIchiranHeaderEditor(headItem);
            IkenshoShujiiIchiranEditor bodyEditor = new IkenshoShujiiIchiranBodyEditor(bodyItem);
            IkenshoShujiiIchiranBuilder builder = new IkenshoShujiiIchiranBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
