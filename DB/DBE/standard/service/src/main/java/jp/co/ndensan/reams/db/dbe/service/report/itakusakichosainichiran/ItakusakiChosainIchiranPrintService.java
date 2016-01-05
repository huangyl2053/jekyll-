/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.itakusakichosainichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranProerty;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranReport;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 調査委託先・調査員一覧表Printクラスです。
 */
public class ItakusakiChosainIchiranPrintService {

    /**
     * 調査委託先・調査員一覧表Printします。
     *
     * @param reportJoho 調査委託先・調査員一覧表作成_帳票クラスパラメータ
     * @return 調査委託先・調査員一覧表作成_帳票
     */
    public SourceDataCollection print(ItakusakiChosainIchiranReportJoho reportJoho) {
        ItakusakiChosainIchiranProerty property = new ItakusakiChosainIchiranProerty();
        return new Printer<ItakusakiChosainIchiranReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<ItakusakiChosainIchiranReport> toReports(ItakusakiChosainIchiranReportJoho reportJoho) {
        List<ItakusakiChosainIchiranReport> list = new ArrayList<>();
        list.add(ItakusakiChosainIchiranReport.createFrom(reportJoho.getHeadItem(), reportJoho.getBodyItemList()));

        return list;

    }

}
