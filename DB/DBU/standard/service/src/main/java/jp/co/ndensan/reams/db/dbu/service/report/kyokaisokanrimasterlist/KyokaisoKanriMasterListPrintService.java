/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.report.kyokaisokanrimasterlist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListProperty;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReport;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportJoho;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 境界層管理マスタリストPrinterです。
 */
public class KyokaisoKanriMasterListPrintService {

    /**
     * 境界層管理マスタリストを印刷します。
     *
     * @param reportJoho 境界層管理マスタリストクラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(KyokaisoKanriMasterListReportJoho reportJoho) {
        KyokaisoKanriMasterListProperty property = new KyokaisoKanriMasterListProperty();
        return new Printer<KyokaisoKanriMasterListReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<KyokaisoKanriMasterListReport> toReports(KyokaisoKanriMasterListReportJoho reportJoho) {
        List<KyokaisoKanriMasterListReport> list = new ArrayList<>();
        list.add(KyokaisoKanriMasterListReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
