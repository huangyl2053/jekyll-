/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shisetsutaishotsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReport;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportJoho;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険住所地特例施設退所通知書Printerです。
 */
public class ShisetsuTaishoTsuchishoPrintService {

    /**
     * 介護保険住所地特例施設退所通知書を印刷します。
     *
     * @param joho 介護保険住所地特例施設退所通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShisetsuTaishoTsuchishoReportJoho joho) {
        ShisetsuTaishoTsuchishoProperty property = new ShisetsuTaishoTsuchishoProperty();
        return new Printer<ShisetsuTaishoTsuchishoReportSource>().spool(property, toReports(joho));
    }

    private static List<ShisetsuTaishoTsuchishoReport> toReports(ShisetsuTaishoTsuchishoReportJoho joho) {
        List<ShisetsuTaishoTsuchishoReport> list = new ArrayList<>();
        list.add(ShisetsuTaishoTsuchishoReport.createFrom(joho.getItem()));
        return list;
    }
}
