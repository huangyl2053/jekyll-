/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.jigyojokyohokoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
import jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku.JigyoJokyoHokokuProperty;
import jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku.JigyoJokyoHokokuReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定事業状況報告Printクラスです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuPrintService {

    /**
     * 要介護認定事業状況報告Printします。
     *
     * @param reportJoho 要介護認定事業状況報告作成_帳票クラスパラメータ
     * @return 要介護認定事業状況報告作成_帳票
     */
    public SourceDataCollection print(JigyoJokyoHokoku reportJoho) {
        JigyoJokyoHokokuProperty property = new JigyoJokyoHokokuProperty();
        return new Printer<JigyoJokyoHokokuReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<JigyoJokyoHokokuReport> toReports(JigyoJokyoHokoku reportJoho) {
        List<JigyoJokyoHokokuReport> list = new ArrayList<>();
        list.add(new JigyoJokyoHokokuReport(reportJoho));
        return list;

    }

}
