/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.business.core.itakusakichosainichiran.ItakusakiChosainIchiranHead;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 認定調査委託先・認定調査員一覧表のReportです。
 *
 * @reamsid_L DBE-0290-020 dongyabin
 */
public final class ItakusakiChosainIchiranReport extends Report<ItakusakiChosainIchiranReportSource> {

    private final ItakusakiChosainIchiranHead headItem;

    /**
     * コンストラクタです。
     *
     * @param headItem 認定調査委託先・認定調査員一覧表のパラメータ
     */
    public ItakusakiChosainIchiranReport(ItakusakiChosainIchiranHead headItem) {
        this.headItem = headItem;
    }

    /**
     * 認定調査委託先・認定調査員一覧表を出力です。
     *
     * @param reportSourceWriter 調査委託先・調査員一覧表Source
     */
    @Override
    public void writeBy(ReportSourceWriter<ItakusakiChosainIchiranReportSource> reportSourceWriter) {
        ItakusakiChosainIchiranEditor headEditor = new ItakusakiChosainIchiranHeaderEditor(headItem);
        ItakusakiChosainIchiranBuilder builder = new ItakusakiChosainIchiranBuilderItem(headEditor);
        reportSourceWriter.writeLine(builder);
    }

}
