/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 認定調査依頼発行一覧表のReportです。
 */
public class ChosaIraiHakkoIchiranhyoReport extends Report<ChosaIraiHakkoIchiranhyoReportSource> {

    private final List<ChosaIraiHakkoIchiranhyoItem> items;

    /**
     * インスタンスを生成します。
     *
     * @param items 認定調査依頼発行一覧表のITEM
     * @return 認定調査依頼発行一覧表のReport
     */
    public static ChosaIraiHakkoIchiranhyoReport createFrom(List<ChosaIraiHakkoIchiranhyoItem> items) {
        return new ChosaIraiHakkoIchiranhyoReport(items);
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 認定調査依頼発行一覧表のITEM
     */
    protected ChosaIraiHakkoIchiranhyoReport(List<ChosaIraiHakkoIchiranhyoItem> items) {
        this.items = items;
    }

    /**
     * 認定調査依頼発行一覧表を出力します。
     *
     * @param reportSourceWriter 認定調査依頼発行一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaIraiHakkoIchiranhyoReportSource> reportSourceWriter) {
        for (ChosaIraiHakkoIchiranhyoItem item : items) {
            IChosaIraiHakkoIchiranhyoEditor editor = new ChosaIraiHakkoIchiranhyoEditor(item);
            IChosaIraiHakkoIchiranhyoBuilder builder = new ChosaIraiHakkoIchiranhyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
