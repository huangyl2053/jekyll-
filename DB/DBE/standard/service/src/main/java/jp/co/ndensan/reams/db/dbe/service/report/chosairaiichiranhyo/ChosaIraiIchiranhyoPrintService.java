/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 認定調査依頼一覧表Printerです。
 */
public class ChosaIraiIchiranhyoPrintService {

    /**
     * 認定調査依頼一覧表を印刷します。
     *
     * @param ichiranhyoReportJoho 認定調査依頼一覧表表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaIraiIchiranhyoReportJoho ichiranhyoReportJoho) {
        ChosaIraiIchiranhyoProperty property = new ChosaIraiIchiranhyoProperty();
        return new Printer<ChosaIraiIchiranhyoReportSource>().spool(property, toReports(ichiranhyoReportJoho));
    }

    private static List<ChosaIraiIchiranhyoReport> toReports(ChosaIraiIchiranhyoReportJoho reportJoho) {
        List<ChosaIraiIchiranhyoReport> list = new ArrayList<>();
        list.add(ChosaIraiIchiranhyoReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
