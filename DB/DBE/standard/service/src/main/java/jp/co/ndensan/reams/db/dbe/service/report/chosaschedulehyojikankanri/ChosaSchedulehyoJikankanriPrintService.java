/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyojikankanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 認定調査スケジュール表(時間管理)PrinterServiceクラスです。
 */
public class ChosaSchedulehyoJikankanriPrintService {

    /**
     * 認定調査スケジュール表(時間管理)を印刷します。
     *
     * @param ichiranReportJoho 認定調査スケジュール表(時間管理)作成_帳票パラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaSchedulehyoJikankanriReportJoho ichiranReportJoho) {
        ChosaSchedulehyoJikankanriProperty property = new ChosaSchedulehyoJikankanriProperty();
        return new Printer<ChosaSchedulehyoJikankanriReportSource>().spool(property, toReports(ichiranReportJoho));
    }

    private static List<ChosaSchedulehyoJikankanriReport> toReports(ChosaSchedulehyoJikankanriReportJoho reportJoho) {
        List<ChosaSchedulehyoJikankanriReport> list = new ArrayList<>();
        list.add(ChosaSchedulehyoJikankanriReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
