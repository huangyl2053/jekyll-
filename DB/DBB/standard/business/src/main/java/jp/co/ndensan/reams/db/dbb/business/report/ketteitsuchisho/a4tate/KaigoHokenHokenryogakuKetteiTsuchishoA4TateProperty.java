/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険料額決定通知書のA4縦タイプのプロパティです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KaigoHokenHokenryogakuKetteiTsuchishoA4TateProperty extends ReportPropertyBase<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenHokenryogakuKetteiTsuchishoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100040.getReportId());
    }

    @Override
    protected Breakers<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> defineBreakers(
            Breakers<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> breakers,
            BreakerCatalog<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
