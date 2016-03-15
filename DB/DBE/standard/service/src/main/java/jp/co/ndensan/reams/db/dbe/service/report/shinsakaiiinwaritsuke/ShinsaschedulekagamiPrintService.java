/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaiiinwaritsuke;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会スケジュール表かがみPrinterです。
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
     * @param items 主治医意見書作成料請求書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShinsaschedulekagamiItem> items) {
        ShinsaschedulekagamiProperty property = new ShinsaschedulekagamiProperty();
        return new Printer<ShinsaschedulekagamiReportSource>().spool(property, toReports(items));
    }

    private static List<ShinsaschedulekagamiReport> toReports(List<ShinsaschedulekagamiItem> items) {
        List<ShinsaschedulekagamiReport> list = new ArrayList<>();
        list.add(ShinsaschedulekagamiReport.createFrom(items));
        return list;
    }
}
