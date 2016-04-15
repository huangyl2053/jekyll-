/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.hihokenshashoa4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Joho;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Proerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Report;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険被保険者証Printクラスです。
 *
 * @reamsid_L DBU-0490-070 suguangjun
 */
public class HihokenshashoA4PrintService {

    /**
     * 介護保険被保険者証Printします。
     *
     * @param hihokenshashoA4Joho 介護保険被保険者証作成_帳票クラスパラメータ
     * @return 介護保険被保険者証作成_帳票
     */
    public SourceDataCollection print(HihokenshashoA4Joho hihokenshashoA4Joho) {
        HihokenshashoA4Proerty property = new HihokenshashoA4Proerty();
        return new Printer<HihokenshashoA4ReportSource>().spool(property, toReports(hihokenshashoA4Joho));
    }

    private static List<HihokenshashoA4Report> toReports(HihokenshashoA4Joho joho) {
        List<HihokenshashoA4Report> list = new ArrayList<>();
        list.add(HihokenshashoA4Report.createReport(joho.getBodyItem()));
        return list;
    }
}
