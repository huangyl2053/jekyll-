/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会スケジュール表かがみPrinterです。
 *
 * @reamsid_L DBE-0130-080 xuyannan
 */
public class ShinsaschedulekagamiPrintService {

    /**
     * 介護認定審査会スケジュール表かがみを印刷します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみ作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    /**
     * 主治医意見書作成料請求書を印刷します。
     *
     * @param item 主治医意見書作成料請求書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShinsaschedulekagamiItem item) {
        ShinsaschedulekagamiProperty property = new ShinsaschedulekagamiProperty();
        return new Printer<ShinsaschedulekagamiReportSource>().spool(property, new ShinsaschedulekagamiReport(item));
    }

}
