/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishukeigenzainojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査会集計表（現在の状況別）のPrinterです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoPrintService {

    /**
     * 介護認定審査会集計表（現在の状況別）を印刷します。
     *
     * @param itemlist 介護認定審査会集計表（現在の状況別）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShinsakaiShukeiGenzainojokyoItem> itemlist) {
        ShinsakaiShukeiGenzainojokyoProperty property = new ShinsakaiShukeiGenzainojokyoProperty();
        return new Printer<ShinsakaiShukeiGenzainojokyoReportSource>().spool(property, toReports(itemlist));
    }

    private static List<ShinsakaiShukeiGenzainojokyoReport> toReports(List<ShinsakaiShukeiGenzainojokyoItem> itemlist) {
        List<ShinsakaiShukeiGenzainojokyoReport> list = new ArrayList<>();
        list.add(ShinsakaiShukeiGenzainojokyoReport.createFrom(itemlist));
        return list;
    }
}
