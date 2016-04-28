/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険料額決定通知書のB5横タイプのプロパティです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KaigoHokenHokenryogakuKetteiTsuchishoB5YokoProperty extends ReportPropertyBase<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenHokenryogakuKetteiTsuchishoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100039.getReportId());
    }

    @Override
    protected Breakers<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> defineBreakers(
            Breakers<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> breakers,
            BreakerCatalog<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }
}
