/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 認定調査督促状のReportです。
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReport extends Report<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private final List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> targets;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 認定調査督促対象者一覧表ボディのITEMリスト
     * @return 認定調査督促状のReport
     */
    public static NinteiChosaTokusokuTaishoshaIchiranhyoReport createFrom(@NonNull List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList) {

        return new NinteiChosaTokusokuTaishoshaIchiranhyoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 認定調査督促対象者一覧表ボディのITEMリスト
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoReport(List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList) {

        this.targets = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter) {
        
        for (NinteiChosaTokusokuTaishoshaIchiranhyoItem item : targets) {
            INinteiChosaTokusokuTaishoshaIchiranhyoEditor headerEditor = new NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor(item);
            INinteiChosaTokusokuTaishoshaIchiranhyoEditor bodyEditor = new NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor(item);
            INinteiChosaTokusokuTaishoshaIchiranhyoBuilder builder = new NinteiChosaTokusokuTaishoshaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
