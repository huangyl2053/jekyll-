/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 認定調査スケジュール表(事務所)Printerクラスです。
 */
public class ChosaSchedulehyoPrintService {

    /**
     * 認定調査スケジュール表(事務所)を印刷します。
     *
     * @param reportJoho 認定調査スケジュール表(事務所)作成_帳票パラメータクラス。
     * @return {@link ChosaSchedulehyoReport}
     */
    public SourceDataCollection print(ChosaSchedulehyoReportJoho reportJoho) {
        ChosaSchedulehyoProperty property = new ChosaSchedulehyoProperty();
        return new Printer<ChosaSchedulehyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ChosaSchedulehyoReport> toReports(ChosaSchedulehyoReportJoho reportJoho) {
        List<ChosaSchedulehyoReport> list = new ArrayList<>();
        list.add(ChosaSchedulehyoReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
