/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.jotaikubumbetsuhantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.Jotaikubumbetsuhantei;
import jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei.JotaikubumbetsuhanteiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護状態区分別判定件数Printクラスです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
public class JotaikubumbetsuhanteiPrintService {

    /**
     * 要介護状態区分別判定件数Printします。
     *
     * @param reportJoho 要介護状態区分別判定件数作成_帳票クラスパラメータ
     * @return 要介護状態区分別判定件数作成_帳票
     */
    public SourceDataCollection print(Jotaikubumbetsuhantei reportJoho) {
        JotaikubumbetsuhanteiProperty property = new JotaikubumbetsuhanteiProperty();
        return new Printer<JotaikubumbetsuhanteiReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<JotaikubumbetsuhanteiReport> toReports(Jotaikubumbetsuhantei reportJoho) {
        List<JotaikubumbetsuhanteiReport> list = new ArrayList<>();
        list.add(new JotaikubumbetsuhanteiReport(reportJoho));
        return list;

    }

}
