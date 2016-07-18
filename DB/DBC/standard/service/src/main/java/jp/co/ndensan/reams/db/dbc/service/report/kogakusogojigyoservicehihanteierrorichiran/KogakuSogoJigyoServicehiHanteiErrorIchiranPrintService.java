/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakusogojigyoservicehihanteierrorichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorlist.KogakuSogoJigyoServicehiHanteiErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
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
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリスト PrintService
 *
 * @reamsid_L DBC-2010-130 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranPrintService {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * 高額総合事業サービス費判定エラーリストを印刷します。
     *
     * @param shutsuryokujunID RString
     * @param entityList List<KogakuSogoJigyoServicehiHanteiErrorListEntity>
     * @param システム日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection print(Long shutsuryokujunID, List<KogakuSogoJigyoServicehiHanteiErrorListEntity> entityList, YMDHMS システム日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(shutsuryokujunID, entityList, reportManager, システム日時);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 高額総合事業サービス費判定エラーリストを印刷します。
     *
     * @param shutsuryokujunID Long
     * @param entityList List<KogakuSogoJigyoServicehiHanteiErrorListEntity>
     * @param reportManager ReportManager
     * @param システム日時 YMDHMS
     */
    private void printFukusu(Long shutsuryokujunID, List<KogakuSogoJigyoServicehiHanteiErrorListEntity> entityList, ReportManager reportManager,
            YMDHMS システム日時) {
        KogakuSogoJigyoServicehiHanteiErrorIchiranProperty property = new KogakuSogoJigyoServicehiHanteiErrorIchiranProperty();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        try (ReportAssembler<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200076.getReportId(), shutsuryokujunID);
            int i = 0;
            List<RString> 改頁項目List = new ArrayList<>();
            RString 並び順の１件目 = RString.EMPTY;
            RString 並び順の２件目 = RString.EMPTY;
            RString 並び順の３件目 = RString.EMPTY;
            RString 並び順の４件目 = RString.EMPTY;
            RString 並び順の５件目 = RString.EMPTY;
            if (並び順 != null) {
                for (ISetSortItem item : 並び順.get設定項目リスト()) {
                    if (item.is改頁項目()) {
                        改頁項目List.add(item.get項目名());
                    }
                    if (i == INDEX_0) {
                        並び順の１件目 = item.get項目名();
                    } else if (i == INDEX_1) {
                        並び順の２件目 = item.get項目名();
                    } else if (i == INDEX_2) {
                        並び順の３件目 = item.get項目名();
                    } else if (i == INDEX_3) {
                        並び順の４件目 = item.get項目名();
                    } else if (i == INDEX_4) {
                        並び順の５件目 = item.get項目名();
                    }
                    i = i + 1;
                }
            }
            new KogakuSogoJigyoServicehiHanteiErrorIchiranReport(entityList, association, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List, システム日時).writeBy(reportSourceWriter);
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
