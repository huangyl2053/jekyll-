/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosahyogaikyochosa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（概況調査）Printerクラスです。
 */
public class ChosahyoGaikyochosaPrintService {

    /**
     * 要介護認定調査票（概況調査）を印刷します。
     *
     * @param itemList 要介護認定調査票（概況調査）パラメータクラス。
     * @return {@link ChosahyoGaikyochosaReport}
     */
    public SourceDataCollection print(List<ChosahyoGaikyochosaItem> itemList) {
        ChosahyoGaikyochosaProperty property = new ChosahyoGaikyochosaProperty();
        return new Printer<ChosahyoGaikyochosaReportSource>().spool(property, toReports(itemList));
    }

    private static List<ChosahyoGaikyochosaReport> toReports(List<ChosahyoGaikyochosaItem> itemList) {
        List<ChosahyoGaikyochosaReport> list = new ArrayList<>();
        list.add(ChosahyoGaikyochosaReport.createFrom(itemList));
        return list;
    }
}
