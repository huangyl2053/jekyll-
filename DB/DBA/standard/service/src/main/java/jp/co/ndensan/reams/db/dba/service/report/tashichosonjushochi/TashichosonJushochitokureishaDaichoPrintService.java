/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.tashichosonjushochi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReport;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 他市町村住所地特例者台帳Printerです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
public class TashichosonJushochitokureishaDaichoPrintService {

    /**
     * 他市町村住所地特例者台帳を印刷します。
     *
     * @param joho 他市町村住所地特例者台帳クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(TashichosonJushochitokureishaDaichoReportJoho joho) {
        TashichosonJushochitokureishaDaichoProperty property = new TashichosonJushochitokureishaDaichoProperty();

        return new Printer<TashichosonJushochitokureishaDaichoReportSource>().spool(property, toReports(joho));
    }

    private static List<TashichosonJushochitokureishaDaichoReport> toReports(TashichosonJushochitokureishaDaichoReportJoho joho) {
        List<TashichosonJushochitokureishaDaichoReport> list = new ArrayList<>();
        list.add(TashichosonJushochitokureishaDaichoReport.createFrom(joho.getHeadItem(), joho.getBodyItemList()));
        return list;
    }
}
