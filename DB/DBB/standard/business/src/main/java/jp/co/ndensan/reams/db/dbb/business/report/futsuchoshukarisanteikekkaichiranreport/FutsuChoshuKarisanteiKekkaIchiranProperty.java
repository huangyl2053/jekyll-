/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP34001_2_普徴仮算定結果一覧表Propertyクラスです。
 *
 * @reamsid_L DBB-0870-030 surun
 */
public class FutsuChoshuKarisanteiKekkaIchiranProperty extends
        ReportPropertyBase<FutsuChoshuKarisanteiKekkaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(FutsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields.listUpper_2.name()),
            new RString(FutsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields.listCenter_2.name()),
            new RString(FutsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields.listUpper_5.name()),
            new RString(FutsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields.listUpper_6.name()),
            new RString(FutsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields.hokenshaNo.name())
    ));

    /**
     * コンストラクタです
     */
    public FutsuChoshuKarisanteiKekkaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200006.getReportId());
    }

    @Override
    public Breakers<FutsuChoshuKarisanteiKekkaIchiranSource> defineBreakers(
            Breakers<FutsuChoshuKarisanteiKekkaIchiranSource> breakers,
            BreakerCatalog<FutsuChoshuKarisanteiKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> currentRecord,
                    ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
