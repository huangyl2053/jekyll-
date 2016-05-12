/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.hanteikekkakagami;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami.HanteikekkaKagamiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami.HanteikekkaKagamiReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護認定審査判定結果（鑑）用出力クラスです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiPrintService {

    /**
     * 介護認定審査判定結果（鑑）を印刷します。
     *
     * @param itemList HanteikekkaKagamiEntity
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<HanteikekkaKagamiEntity> itemList) {
        HanteikekkaKagamiProperty property = new HanteikekkaKagamiProperty();
        return new Printer<HanteikekkaKagamiReportSource>().spool(property, toReports(itemList));
    }

    private static List<HanteikekkaKagamiReport> toReports(List<HanteikekkaKagamiEntity> itemList) {
        List<HanteikekkaKagamiReport> list = new ArrayList<>();
        list.add(HanteikekkaKagamiReport.createFrom(itemList));
        return list;
    }
}
