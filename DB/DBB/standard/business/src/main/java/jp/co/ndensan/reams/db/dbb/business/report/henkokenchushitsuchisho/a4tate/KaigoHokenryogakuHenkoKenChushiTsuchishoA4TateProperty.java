/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.a4tate;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のA4縦タイプのプロパティです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateProperty
        extends ReportPropertyBase<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100043.getReportId());
    }

    @Override
    protected Breakers<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> defineBreakers(
            Breakers<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> breakers,
            BreakerCatalog<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

}
