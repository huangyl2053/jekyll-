/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.tashichosonjushochitokureisharenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoItem;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReport;
import jp.co.ndensan.reams.db.dba.entity.report.source.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険他市町村住所地特例者連絡票Printerです。
 */
public class TashichosonJushochitokureishaRenrakuhyoPrintService {

    /**
     * 介護保険他市町村住所地特例者連絡票を印刷します。
     *
     * @param item 介護保険他市町村住所地特例者連絡票_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(TashichosonJushochitokureishaRenrakuhyoItem item) {
        TashichosonJushochitokureishaRenrakuhyoProperty property = new TashichosonJushochitokureishaRenrakuhyoProperty();
        return new Printer<TashichosonJushochitokureishaRenrakuhyoReportSource>().spool(property, toReports(item));
    }

    private static List<TashichosonJushochitokureishaRenrakuhyoReport> toReports(TashichosonJushochitokureishaRenrakuhyoItem item) {
        List<TashichosonJushochitokureishaRenrakuhyoReport> list = new ArrayList<>();
        list.add(TashichosonJushochitokureishaRenrakuhyoReport.createFrom(item));
        return list;
    }
}
