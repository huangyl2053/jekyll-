/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会開催のお知らせのReportです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
public class ShinsakaiKaisaiOshiraseTsuchiReport extends Report<ShinsakaiKaisaiOshiraseTsuchiReportSource> {

    private final ShinsakaiKaisaiOshiraseTsuchiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護認定審査会開催のお知らせのITEMLIST
     */
    public ShinsakaiKaisaiOshiraseTsuchiReport(ShinsakaiKaisaiOshiraseTsuchiItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会開催のお知らせを生成します。
     *
     * @param reportSourceWriter 介護認定審査会開催のお知らせReportSourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiKaisaiOshiraseTsuchiReportSource> reportSourceWriter) {
        IShinsakaiKaisaiOshiraseTsuchiEditor editor = new ShinsakaiKaisaiOshiraseTsuchiEditor(item);
        IShinsakaiKaisaiOshiraseTsuchiBuilder builder = new ShinsakaiKaisaiOshiraseTsuchiBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
