/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ｓhokanｋetteiｓsuchiｓhoｓealer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）のプロパティです。
 *
 */
public class ShokanKetteiTsuchiShoSealer2Property extends ReportPropertyBase<ShokanKetteiTsuchiShoSealer2ReportSource> {

    private static final ReportId ID = new ReportId("DBC100006");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public ShokanKetteiTsuchiShoSealer2Property() {
        super(SubGyomuCode.DBC介護給付, ID);
    }

    @Override
    public Breakers<ShokanKetteiTsuchiShoSealer2ReportSource> defineBreakers(
            Breakers<ShokanKetteiTsuchiShoSealer2ReportSource> breakers,
            BreakerCatalog<ShokanKetteiTsuchiShoSealer2ReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(








            PAGE_BREAK_KEYS){
         @Override
            public ReportLineRecord<ShokanKetteiTsuchiShoSealer2ReportSource> occuredBreak(
                    ReportLineRecord<ShokanKetteiTsuchiShoSealer2ReportSource> currentRecord,
                    ReportLineRecord<ShokanKetteiTsuchiShoSealer2ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

}
