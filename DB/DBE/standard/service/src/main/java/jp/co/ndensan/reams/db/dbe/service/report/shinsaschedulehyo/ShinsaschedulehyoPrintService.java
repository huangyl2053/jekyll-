/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsaschedulehyo;

import jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo.ShinsaschedulehyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo.ShinsaschedulehyoReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.ScheduleNenkanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会スケジュール表（年間）のPrinterです。
 *
 * @reamsid_L DBE-0130-081 duanzhanli
 */
public class ShinsaschedulehyoPrintService {

    /**
     * 介護認定審査会スケジュール表（年間）を印刷します。
     *
     * @param target 介護認定審査会スケジュール表（年間）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ScheduleNenkanRelateEntity target) {
        ShinsaschedulehyoProperty property = new ShinsaschedulehyoProperty();
        return new Printer<ShinsaschedulehyoReportSource>().spool(property, new ShinsaschedulehyoReport(target));
    }
}
