/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shisetsuhenkotsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReport;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportJoho;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険住所地特例施設変更通知書Printerです。
 */
public class ShisetsuHenkoTsuchishoPrintService {

    /**
     * 介護保険住所地特例施設変更通知書を印刷します。
     *
     * @param joho 介護保険住所地特例施設変更通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShisetsuHenkoTsuchishoReportJoho joho) {
        ShisetsuHenkoTsuchishoProperty property = new ShisetsuHenkoTsuchishoProperty();
        return new Printer<ShisetsuHenkoTsuchishoReportSource>().spool(property, toReports(joho));
    }

    private static List<ShisetsuHenkoTsuchishoReport> toReports(ShisetsuHenkoTsuchishoReportJoho joho) {
        List<ShisetsuHenkoTsuchishoReport> list = new ArrayList<>();
        list.add(ShisetsuHenkoTsuchishoReport.createFrom(joho.getItem()));
        return list;
    }
}
