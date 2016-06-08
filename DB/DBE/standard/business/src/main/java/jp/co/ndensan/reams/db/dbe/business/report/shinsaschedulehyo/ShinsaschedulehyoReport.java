/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.GogitaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.ScheduleNenkanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会スケジュール表（年間）のReportです。
 *
 * @reamsid_L DBE-0130-081 duanzhanli
 */
public class ShinsaschedulehyoReport extends Report<ShinsaschedulehyoReportSource> {

    private final ScheduleNenkanRelateEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target 年間Entity
     */
    public ShinsaschedulehyoReport(ScheduleNenkanRelateEntity target) {
        this.target = target;
    }

    /**
     * 介護認定審査会スケジュール表（年間）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaschedulehyoReportSource> reportSourceWriter) {
        for (GogitaiRelateEntity entity : target.getGogitaiList()) {
            IShinsaschedulehyoHeadEditor headEditor = new ShinsaschedulehyoHeadEditor(target.getWeek());
            IShinsaschedulehyoEditor editor = new ShinsaschedulehyoEditor(entity);
            IShinsaschedulehyoBuilder builder = new ShinsaschedulehyoBuilder(headEditor, editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
