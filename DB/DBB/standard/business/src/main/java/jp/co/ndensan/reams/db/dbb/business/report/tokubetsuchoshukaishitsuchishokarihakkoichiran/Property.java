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
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Propertyクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class Property extends
        ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listLower_1.name())
    ));

    /**
     * コンストラクタです。
     */
    public Property() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200001.getReportId());
    }

    @Override
    public Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(



            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> occuredBreak(
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentRecord,
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
