/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikenshoteishutsuiraisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険指定医依頼兼主治医意見書提出依頼書Printerです。
 */
public class ShujiiIkenshoTeishutsuIraishoPrintService {

    /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書を印刷します。
     *
     * @param joho 介護保険指定医依頼兼主治医意見書提出依頼書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShujiiIkenshoTeishutsuIraishoReportJoho joho) {
        ShujiiIkenshoTeishutsuIraishoProperty property = new ShujiiIkenshoTeishutsuIraishoProperty();

        return new Printer<ShujiiIkenshoTeishutsuIraishoReportSource>().spool(property, toReports(joho));
    }

    private static List<ShujiiIkenshoTeishutsuIraishoReport> toReports(ShujiiIkenshoTeishutsuIraishoReportJoho joho) {
        List<ShujiiIkenshoTeishutsuIraishoReport> list = new ArrayList<>();
        list.add(ShujiiIkenshoTeishutsuIraishoReport.createFrom(joho.getItemList()));
        return list;
    }
}
