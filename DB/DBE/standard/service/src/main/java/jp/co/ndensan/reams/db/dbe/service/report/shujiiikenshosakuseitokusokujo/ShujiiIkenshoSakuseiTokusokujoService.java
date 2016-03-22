/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikenshosakuseitokusokujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書提出督促状Printerです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoService {

    /**
     * 主治医意見書提出督促状を印刷します。
     *
     * @param item 主治医意見書提出督促状作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShujiiIkenshoSakuseiTokusokujoItem> item) {

        ShujiiIkenshoSakuseiTokusokujoProperty property = new ShujiiIkenshoSakuseiTokusokujoProperty();
        return new Printer<ShujiiIkenshoSakuseiTokusokujoReportSource>().spool(property, toReports(item));
    }

    private static List<ShujiiIkenshoSakuseiTokusokujoReport> toReports(List<ShujiiIkenshoSakuseiTokusokujoItem> item) {
        List<ShujiiIkenshoSakuseiTokusokujoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoSakuseiTokusokujoReport.createFrom(item));
        return list;
    }

}
