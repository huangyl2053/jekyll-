/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.sonotashiryo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryo;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定情報提供その他資料情報Printクラスです。
 *
 * @reamsid_L DBE-0230-050 zhangzhiming
 */
public class SonoTashiryoPrintService {

    /**
     * 要介護認定情報提供その他資料情報Printします。
     *
     * @param reportJoho 要介護認定情報提供その他資料情報_帳票クラスパラメータ
     * @return 要介護認定情報提供その他資料情報_帳票
     */
    public SourceDataCollection print(SonoTashiryo reportJoho) {
        SonoTashiryoProperty property = new SonoTashiryoProperty();
        return new Printer<SonoTashiryoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<SonoTashiryoReport> toReports(SonoTashiryo reportJoho) {
        List<SonoTashiryoReport> list = new ArrayList<>();
        list.add(new SonoTashiryoReport(reportJoho));
        return list;

    }
}
