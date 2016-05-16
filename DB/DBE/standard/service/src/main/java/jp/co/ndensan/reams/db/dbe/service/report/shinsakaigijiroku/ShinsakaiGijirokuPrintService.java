/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaigijiroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku.ShinsakaiGijirokuProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku.ShinsakaiGijirokuReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定判定結果一覧表用出力クラスです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuPrintService {

    /**
     * 介護認定審査会議事録を印刷します。
     *
     * @param itemList ShinsakaiKekkaJohoRelateEntity
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShinsakaiKekkaJohoRelateEntity> itemList) {
        ShinsakaiGijirokuProperty property = new ShinsakaiGijirokuProperty();
        return new Printer<ShinsakaiGijirokuReportSource>().spool(property, toReports(itemList));
    }

    private static List<ShinsakaiGijirokuReport> toReports(List<ShinsakaiKekkaJohoRelateEntity> itemList) {
        List<ShinsakaiGijirokuReport> list = new ArrayList<>();
        list.add(ShinsakaiGijirokuReport.createFrom(itemList));
        return list;
    }
}
