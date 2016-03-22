/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shisetsuhenkotsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoItem;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReport;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険住所地特例施設変更通知書Printerです。
 */
public class ShisetsuHenkoTsuchishoPrintService {

    /**
     * 介護保険住所地特例施設変更通知書を印刷します。
     *
     * @param item 介護保険住所地特例施設変更通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShisetsuHenkoTsuchishoItem item) {
        ShisetsuHenkoTsuchishoProperty property = new ShisetsuHenkoTsuchishoProperty();
        return new Printer<ShisetsuHenkoTsuchishoReportSource>().spool(property, toReports(item));
    }

    private static List<ShisetsuHenkoTsuchishoReport> toReports(ShisetsuHenkoTsuchishoItem item) {
        List<ShisetsuHenkoTsuchishoReport> list = new ArrayList<>();
        list.add(ShisetsuHenkoTsuchishoReport.createFrom(item));
        return list;
    }
}
