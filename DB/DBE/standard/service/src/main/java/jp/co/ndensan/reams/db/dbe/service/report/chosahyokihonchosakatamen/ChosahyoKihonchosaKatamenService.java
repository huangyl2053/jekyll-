/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosahyokihonchosakatamen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenProperty;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReport;
import jp.co.ndensan.reams.db.dbz.entity.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（基本調査）のPrinterです。
 *
 * @reamsid_L DBE-0080-020 zuotao
 */
public class ChosahyoKihonchosaKatamenService {

    /**
     * 要介護認定調査票（基本調査）を印刷します。
     *
     * @param itemList 要介護認定調査票（基本調査）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosahyoKihonchosaKatamenItem> itemList) {
        ChosahyoKihonchosaKatamenProperty property = new ChosahyoKihonchosaKatamenProperty();
        return new Printer<ChosahyoKihonchosaKatamenReportSource>().spool(property, toReports(itemList));
    }

    private static List<ChosahyoKihonchosaKatamenReport> toReports(List<ChosahyoKihonchosaKatamenItem> itemList) {
        List<ChosahyoKihonchosaKatamenReport> list = new ArrayList<>();
        list.add(ChosahyoKihonchosaKatamenReport.createFrom(itemList));
        return list;
    }
}
