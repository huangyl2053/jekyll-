/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikenshosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書作成料請求書Printerです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoService {

    /**
     * 主治医意見書作成料請求書を印刷します。
     *
     * @param items 主治医意見書作成料請求書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> items) {
        ShujiiIkenshoSakuseiRyoSeikyushoProperty property = new ShujiiIkenshoSakuseiRyoSeikyushoProperty();
        return new Printer<ShujiiIkenshoSakuseiRyoSeikyushoReportSource>().spool(property, toReports(items));
    }

    private static List<ShujiiIkenshoSakuseiRyoSeikyushoReport> toReports(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> items) {
        List<ShujiiIkenshoSakuseiRyoSeikyushoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoSakuseiRyoSeikyushoReport.createFrom(items));
        return list;
    }
}
