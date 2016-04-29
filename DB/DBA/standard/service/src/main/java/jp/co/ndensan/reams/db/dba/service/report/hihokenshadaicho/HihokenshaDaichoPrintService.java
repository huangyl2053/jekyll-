/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho.HihokenshaDaichoProerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho.HihokenshaDaichoReport;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 被保険者台帳一覧表Printクラスです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoPrintService {

    /**
     * 被保険者台帳一覧表をPrintします。
     *
     * @param itemList 被保険者台帳一覧表itemリスト
     * @return 被保険者台帳一覧表_帳票
     */
    public SourceDataCollection print(List<HihokenshaDaichoSakusei> itemList) {
        HihokenshaDaichoProerty property = new HihokenshaDaichoProerty();
        return new Printer<HihokenshaDaichoReportSource>().spool(property, toReports(itemList));
    }

    private static List<HihokenshaDaichoReport> toReports(List<HihokenshaDaichoSakusei> itemList) {
        List<HihokenshaDaichoReport> list = new ArrayList<>();
        list.add(HihokenshaDaichoReport.createReport(itemList));
        return list;
    }
}
