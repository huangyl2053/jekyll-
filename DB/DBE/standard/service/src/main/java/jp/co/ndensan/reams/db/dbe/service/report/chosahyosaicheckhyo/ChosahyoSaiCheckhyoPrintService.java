/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosahyosaicheckhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 前回認定調査結果との比較表Printerです。
 */
public class ChosahyoSaiCheckhyoPrintService {

    /**
     * 前回認定調査結果との比較表を印刷します。
     *
     * @param itemList 前回認定調査結果との比較表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosahyoSaiCheckhyoItem> itemList) {
        ChosahyoSaiCheckhyoProperty property = new ChosahyoSaiCheckhyoProperty();
        return new Printer<ChosahyoSaiCheckhyoReportSource>().spool(property, toReports(itemList));
    }

    private static List<ChosahyoSaiCheckhyoReport> toReports(List<ChosahyoSaiCheckhyoItem> itemList) {
        List<ChosahyoSaiCheckhyoReport> list = new ArrayList<>();
        list.add(ChosahyoSaiCheckhyoReport.createFrom(itemList));
        return list;
    }
}
