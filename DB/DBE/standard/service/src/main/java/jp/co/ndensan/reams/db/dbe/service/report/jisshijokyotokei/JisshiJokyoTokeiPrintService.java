/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.jisshijokyotokei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei.JisshiJokyoTokeiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei.JisshiJokyoTokeiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定実施状況統計Printクラスです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JisshiJokyoTokeiPrintService {

    /**
     * 要介護認定実施状況統計Printします。
     *
     * @param reportJoho 要介護認定実施状況統計作成_帳票クラスパラメータ
     * @return 要介護認定実施状況統計作成_帳票
     */
    public SourceDataCollection print(JisshiJokyoTokei reportJoho) {
        JisshiJokyoTokeiProperty property = new JisshiJokyoTokeiProperty();
        return new Printer<JisshiJokyoTokeiReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<JisshiJokyoTokeiReport> toReports(JisshiJokyoTokei reportJoho) {
        List<JisshiJokyoTokeiReport> list = new ArrayList<>();
        list.add(new JisshiJokyoTokeiReport(reportJoho));
        return list;

    }

}
