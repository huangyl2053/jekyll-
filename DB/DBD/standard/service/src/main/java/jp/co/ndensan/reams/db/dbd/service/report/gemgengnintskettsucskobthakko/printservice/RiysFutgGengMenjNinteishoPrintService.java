/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice;

import jp.co.ndensan.reams.db.dbd.business.report.dbd100015.RiysFutgGengMenjNinteishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100015.RiysFutgGengMenjNinteishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100015.RiysFutgGengMenjNinteishoReport;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 利用者負担額減額・免除等認定証のReportSource
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoPrintService {

    /**
     * 帳票を出力
     *
     * @param target パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(RiysFutgGengMenjNinteishoItem target, ReportManager reportManager) {
        ReportId reportId = ReportIdDBD.DBD100015.getReportId();
        if (target.get利用者負担額減額情報().is旧措置者有無()) {
            reportId = ReportIdDBD.DBD100016.getReportId();
        }
        RiysFutgGengMenjNinteishoProerty property = new RiysFutgGengMenjNinteishoProerty(reportId);
        try (ReportAssembler<RiysFutgGengMenjNinteishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<RiysFutgGengMenjNinteishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, target.get帳票分類ID(),
                    new FlexibleDate(target.get発行日().toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            target.setNinshoshaSource(ninshoshaSource);
            RiysFutgGengMenjNinteishoReport report = RiysFutgGengMenjNinteishoReport.createReport(target);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
