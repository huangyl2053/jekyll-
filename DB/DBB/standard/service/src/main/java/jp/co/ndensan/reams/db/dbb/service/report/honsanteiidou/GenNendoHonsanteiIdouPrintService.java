/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.honsanteiidou;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogenendofuka.HonSanteiIdoGenendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbc.business.report.honsanteiidou.GenNendoHonsanteiIdouProperty;
import jp.co.ndensan.reams.db.dbc.business.report.honsanteiidou.GenNendoHonsanteiIdouReport;
import jp.co.ndensan.reams.db.dbc.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 本算定異動（現年度）結果一覧表帳票Serviceクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouPrintService {

    public SourceDataCollection print(List<KeisanjohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            HonSanteiIdoGenendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時, FlexibleYear 賦課年度) {

        GenNendoHonsanteiIdouProperty property = new GenNendoHonsanteiIdouProperty();

        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<GenNendoHonsanteiIdouSource> assembler = createAssembler(property, reportManager)) {

                ReportSourceWriter<GenNendoHonsanteiIdouSource> reportSourceWriter = new ReportSourceWriter(assembler);
                new GenNendoHonsanteiIdouReport(更正前後EntityList, バッチパラメータ, 調定日時, 賦課年度, association).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
