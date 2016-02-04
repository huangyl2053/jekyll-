/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosahyotokkijiko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（特記事項）Printerです。
 */
public class ChosahyoTokkijikoPrintService {

    /**
     * 要介護認定調査票（特記事項）を印刷します。
     *
     * @param itemList 要介護認定調査票（特記事項）作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosahyoTokkijikoItem> itemList) {
        ChosahyoTokkijikoProperty property = new ChosahyoTokkijikoProperty();
        return new Printer<ChosahyoTokkijikoReportSource>().spool(property, toReports(itemList));
    }

    private static List<ChosahyoTokkijikoReport> toReports(List<ChosahyoTokkijikoItem> itemList) {
        List<ChosahyoTokkijikoReport> list = new ArrayList<>();
        list.add(ChosahyoTokkijikoReport.createFrom(itemList));
        return list;
    }
}
