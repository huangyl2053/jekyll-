/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）発行一覧表 Property
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiProperty
        extends ReportPropertyBase<TokubetsuChoshuKaishiSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(
            Arrays.asList(new RString(TokubetsuChoshuKaishiSource.ReportSourceFields.kaipage1.name()),
                    new RString(TokubetsuChoshuKaishiSource.ReportSourceFields.kaipage2.name()),
                    new RString(TokubetsuChoshuKaishiSource.ReportSourceFields.kaipage3.name()),
                    new RString(TokubetsuChoshuKaishiSource.ReportSourceFields.kaipage4.name()),
                    new RString(TokubetsuChoshuKaishiSource.ReportSourceFields.kaipage5.name())));

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200011.getReportId());
    }

    @Override
    public Breakers<TokubetsuChoshuKaishiSource> defineBreakers(
            Breakers<TokubetsuChoshuKaishiSource> breakers,
            BreakerCatalog<TokubetsuChoshuKaishiSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<TokubetsuChoshuKaishiSource> occuredBreak(
                    ReportLineRecord<TokubetsuChoshuKaishiSource> currentRecord,
                    ReportLineRecord<TokubetsuChoshuKaishiSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
