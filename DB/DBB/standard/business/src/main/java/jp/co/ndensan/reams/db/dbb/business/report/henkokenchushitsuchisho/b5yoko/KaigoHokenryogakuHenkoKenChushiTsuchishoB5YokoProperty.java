/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のB5横タイプのプロパティです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoProperty
        extends ReportPropertyBase<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100042.getReportId());
    }

    @Override
    protected Breakers<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> defineBreakers(
            Breakers<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> breakers,
            BreakerCatalog<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }
}
