/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（現在の状況別）のReportです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoReport extends Report<ShinsakaiShukeiGenzainojokyoReportSource> {

    private final ShinsakaiShukeiGenzainojokyoEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target 介護認定審査会集計表（現在の状況別）target
     */
    public ShinsakaiShukeiGenzainojokyoReport(ShinsakaiShukeiGenzainojokyoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiShukeiGenzainojokyoReportSource> reportSourceWriter) {
        IShinsakaiShukeiGenzainojokyoEditor editor = new ShinsakaiShukeiGenzainojokyoEditor(target);
        IShinsakaiShukeiGenzainojokyoBuilder builder = new ShinsakaiShukeiGenzainojokyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
