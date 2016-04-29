package jp.co.ndensan.reams.db.dbu.service.report.bemmeisyo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoHeadItem;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoProperty;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoReport;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoReportJoho;
import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 弁明書Printerクラスです。
 *
 * @reamsid_L DBU-1080-150 linghuhang
 */
public class BemmeisyoPrintService {

    /**
     * 弁明書を印刷します。
     *
     * @param headItem 弁明書ヘッダのITEM。
     * @return {@link BemmeisyoReport}
     */
    public SourceDataCollection print(BemmeisyoHeadItem headItem) {
        BemmeisyoProperty property = new BemmeisyoProperty();
        return new Printer<BemmeisyoReportSource>().spool(property, toReports(new BemmeisyoReportJoho(headItem)));
    }

    private static List<BemmeisyoReport> toReports(BemmeisyoReportJoho reportJoho) {
        List<BemmeisyoReport> list = new ArrayList<>();
        list.add(BemmeisyoReport.createFrom(
                reportJoho.getHeadItem()));
        return list;
    }
}
