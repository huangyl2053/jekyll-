/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.saichekkuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoReport;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票差異チェック票Printerです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoPrintService {

    /**
     * 要介護認定調査票差異チェック票を印刷します。
     *
     * @param itemList 要介護認定調査票差異チェック票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<SaiChekkuhyoItem> itemList) {
        SaiChekkuhyoProperty property = new SaiChekkuhyoProperty();
        return new Printer<SaiChekkuhyoReportSource>().spool(property, toReports(itemList));
    }

    private static List<SaiChekkuhyoReport> toReports(List<SaiChekkuhyoItem> itemList) {
        List<SaiChekkuhyoReport> list = new ArrayList<>();
        list.add(SaiChekkuhyoReport.createFrom(itemList));
        return list;
    }
}
