/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.saichekkuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoRyoumenProperty;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoRyoumenReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票差異チェック票Printerです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenPrintService {

    /**
     * 要介護認定調査票差異チェック票を印刷します。
     *
     * @param itemList 要介護認定調査票差異チェック票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<SaiChekkuhyoItem> itemList) {
        SaiChekkuhyoRyoumenProperty property = new SaiChekkuhyoRyoumenProperty();
        return new Printer<SaiChekkuhyoReportSource>().spool(property, toReports(itemList));
    }

    private static List<SaiChekkuhyoRyoumenReport> toReports(List<SaiChekkuhyoItem> itemList) {
        List<SaiChekkuhyoRyoumenReport> list = new ArrayList<>();
        list.add(SaiChekkuhyoRyoumenReport.createFrom(itemList));
        return list;
    }
}
