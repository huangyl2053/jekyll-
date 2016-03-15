/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosahyotokkijikofree;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoFreeProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijikofree.ChosahyoTokkijikoFreeReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（特記事項）フリー様式Printerです。
 */
public class ChosahyoTokkijikoFreePrintService {

    /**
     * 要介護認定調査票（特記事項）フリー様式を印刷します。
     *
     * @param itemList 要介護認定調査票（特記事項）フリー様式作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosahyoTokkijikoItem> itemList) {
        ChosahyoTokkijikoFreeProperty property = new ChosahyoTokkijikoFreeProperty();
        return new Printer<ChosahyoTokkijikoReportSource>().spool(property, toReports(itemList));
    }

    private static List<ChosahyoTokkijikoFreeReport> toReports(List<ChosahyoTokkijikoItem> itemList) {
        List<ChosahyoTokkijikoFreeReport> list = new ArrayList<>();
        list.add(ChosahyoTokkijikoFreeReport.createFrom(itemList));
        return list;
    }
}
