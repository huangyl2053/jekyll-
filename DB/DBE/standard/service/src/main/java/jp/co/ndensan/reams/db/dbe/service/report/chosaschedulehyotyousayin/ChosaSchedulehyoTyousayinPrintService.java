/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosaschedulehyotyousayin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 認定調査スケジュール表(調査員)PrinterServiceクラスです。
 */
public class ChosaSchedulehyoTyousayinPrintService {

    /**
     * 認定調査スケジュール表(調査員)を印刷します。
     *
     * @param ichiranReportJoho 認定調査スケジュール表(調査員)作成_帳票パラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaSchedulehyoTyousayinReportJoho ichiranReportJoho) {
        ChosaSchedulehyoTyousayinProperty property = new ChosaSchedulehyoTyousayinProperty();
        return new Printer<ChosaSchedulehyoTyousayinReportSource>().spool(property, toReports(ichiranReportJoho));
    }

    private static List<ChosaSchedulehyoTyousayinReport> toReports(ChosaSchedulehyoTyousayinReportJoho reportJoho) {
        List<ChosaSchedulehyoTyousayinReport> list = new ArrayList<>();
        list.add(ChosaSchedulehyoTyousayinReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
