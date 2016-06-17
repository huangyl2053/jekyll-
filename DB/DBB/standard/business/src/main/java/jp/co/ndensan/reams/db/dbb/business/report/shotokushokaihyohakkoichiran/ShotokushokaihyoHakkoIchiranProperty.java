/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のProperty
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranProperty extends ReportPropertyBase<ShotokushokaihyoHakkoIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString(
            ShotokushokaihyoHakkoIchiranSource.ReportSourceFields.listUpper_1.name()), new RString(
                    ShotokushokaihyoHakkoIchiranSource.ReportSourceFields.listLower_1.name()), new RString(
                    ShotokushokaihyoHakkoIchiranSource.ReportSourceFields.listUpper_2.name())));

    /**
     * コンストラクタです。
     */
    public ShotokushokaihyoHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200024.getReportId());
    }

    @Override
    public Breakers<ShotokushokaihyoHakkoIchiranSource> defineBreakers(
            Breakers<ShotokushokaihyoHakkoIchiranSource> breakers,
            BreakerCatalog<ShotokushokaihyoHakkoIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> occuredBreak(
                    ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> currentRecord,
                    ReportLineRecord<ShotokushokaihyoHakkoIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
