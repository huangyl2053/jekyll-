/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 認定調査委託先・認定調査員一覧表のReportです。
 */
public final class ItakusakiChosainIchiranReport extends Report<ItakusakiChosainIchiranReportSource> {

    private final ItakusakiChosainIchiranHeadItem headItem;
    private final List<ItakusakiChosainIchiranBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査委託先・認定調査員一覧表ヘッダのITEM
     * @param bodyItemList 認定調査委託先・認定調査員一覧表ボディのITEMリスト
     * @return 認定調査委託先・認定調査員一覧表のReport
     */
    public static ItakusakiChosainIchiranReport createFrom(ItakusakiChosainIchiranHeadItem headItem,
            @NonNull List<ItakusakiChosainIchiranBodyItem> bodyItemList) {
        return new ItakusakiChosainIchiranReport(headItem, bodyItemList);
    }

    private ItakusakiChosainIchiranReport(ItakusakiChosainIchiranHeadItem headItem,
            List<ItakusakiChosainIchiranBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }

    /**
     * 認定調査委託先・認定調査員一覧表を出力です。
     *
     * @param reportSourceWriter 調査委託先・調査員一覧表Source
     */
    @Override
    public void writeBy(ReportSourceWriter<ItakusakiChosainIchiranReportSource> reportSourceWriter) {
        for (ItakusakiChosainIchiranBodyItem bodyItem : bodyItemList) {
            ItakusakiChosainIchiranHeaderEditor headEditor = new ItakusakiChosainIchiranHeaderEditor(headItem);
            ItakusakiChosainIchiranEditor bodyEditor = new ItakusakiChosainIchiranBodyEditor(bodyItem);
            ItakusakiChosainIchiranBuilder builder = new ItakusakiChosainIchiranBuilderItem(headEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
