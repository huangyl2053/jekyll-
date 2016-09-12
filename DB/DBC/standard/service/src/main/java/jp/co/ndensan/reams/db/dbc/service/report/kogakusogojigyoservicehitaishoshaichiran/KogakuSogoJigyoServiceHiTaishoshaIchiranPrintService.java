/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakusogojigyoservicehitaishoshaichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * 高額総合事業サービス費対象者一覧表PrintService
 *
 * @reamsid_L DBC-2010-120 surun
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranPrintService {

    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM5 = 5;

    /**
     * printSingle
     *
     * @param 高額総合事業サービス費対象者一覧表list List<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity>
     * @param 出力順ID long
     * @param システム日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity> 高額総合事業サービス費対象者一覧表list,
            long 出力順ID, YMDHMS システム日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(高額総合事業サービス費対象者一覧表list, 出力順ID, システム日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * print
     *
     * @param 高額総合事業サービス費対象者一覧表list List<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity>
     * @param 出力順ID long
     * @param システム日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(
            List<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity> 高額総合事業サービス費対象者一覧表list,
            long 出力順ID,
            YMDHMS システム日時,
            ReportManager reportManager) {
        KogakuSogoJigyoServiceHiTaishoshaIchiranProperty property = new KogakuSogoJigyoServiceHiTaishoshaIchiranProperty();
        try (ReportAssembler<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200077.getReportId(), 出力順ID);
            if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
                executeReport(高額総合事業サービス費対象者一覧表list, システム日時, association, new ArrayList(),
                        new ArrayList(), reportSourceWriter);
                return;
            }
            List<RString> 出力項目リスト = new ArrayList();
            List<RString> 改頁項目リスト = new ArrayList();
            for (int i = NUM0; i < NUM5; i++) {
                if (i < 並び順.get設定項目リスト().size()) {
                    出力項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                    if (並び順.get設定項目リスト().get(i).is改頁項目()) {
                        改頁項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                    }
                } else {
                    break;
                }
            }
            executeReport(高額総合事業サービス費対象者一覧表list, システム日時, association, 出力項目リスト,
                    改頁項目リスト, reportSourceWriter);

        }
    }

    private void executeReport(List<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity> 高額総合事業サービス費対象者一覧表list,
            YMDHMS システム日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            ReportSourceWriter<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> reportSourceWriter) {
        Collections.sort(高額総合事業サービス費対象者一覧表list, new Comparator<KogakuSogoJigyoServiceHiTaishoshaIchiranEntity>() {
            @Override
            public int compare(KogakuSogoJigyoServiceHiTaishoshaIchiranEntity o1, KogakuSogoJigyoServiceHiTaishoshaIchiranEntity o2) {
                int flag = o1.get識別コード().compareTo(o2.get識別コード());
                if (0 == flag) {
                    flag = o1.get利用者負担額().compareTo(o2.get利用者負担額());
                    if (0 == flag) {
                        flag = o1.get支給予定金額().compareTo(o2.get支給予定金額());
                    }
                }
                return flag;
            }
        });
        int i = NUM1;
        for (KogakuSogoJigyoServiceHiTaishoshaIchiranEntity 高額総合事業サービス費対象者一覧表 : 高額総合事業サービス費対象者一覧表list) {
            KogakuSogoJigyoServiceHiTaishoshaIchiranReport report = new KogakuSogoJigyoServiceHiTaishoshaIchiranReport(
                    高額総合事業サービス費対象者一覧表, システム日時, association, 出力項目リスト, 改頁項目リスト, i);
            report.writeBy(reportSourceWriter);
            i = i + NUM1;
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
