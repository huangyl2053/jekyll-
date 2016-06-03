/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
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
     * @param target 介護認定審査会集計表（現在の状況別）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShinsakaiShukeiGenzainojokyoEntity target) {
        ShinsakaiShukeiGenzainojokyoProperty property = new ShinsakaiShukeiGenzainojokyoProperty();
        return new Printer<ShinsakaiShukeiGenzainojokyoReportSource>().spool(property, new ShinsakaiShukeiGenzainojokyoReport(target));
    }
}
