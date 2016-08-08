/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufujissekikoshinkekkaichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 PrintService
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufujissekiKoshinkekkaIchiranPrintService {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * 給付実績更新結果情報一覧表を印刷します。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param shutsuryokujunID RString
     * @param entityList List<ChohyoShutsuryokuTaishoDateEntity>
     * @param システム日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection print(FlexibleYearMonth 処理年月, Long shutsuryokujunID,
            List<ChohyoShutsuryokuTaishoDateEntity> entityList, YMDHMS システム日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(処理年月, shutsuryokujunID, entityList, システム日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 給付実績更新結果情報一覧表を印刷します。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param shutsuryokujunID Long
     * @param entityList List<ChohyoShutsuryokuTaishoDateEntity>
     * @param システム日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void printFukusu(FlexibleYearMonth 処理年月, Long shutsuryokujunID,
            List<ChohyoShutsuryokuTaishoDateEntity> entityList, YMDHMS システム日時, ReportManager reportManager) {
        KyufujissekiKoshinkekkaIchiranProperty property = new KyufujissekiKoshinkekkaIchiranProperty();
        try (ReportAssembler<KyufujissekiKoshinkekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KyufujissekiKoshinkekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200054.getReportId(), shutsuryokujunID);
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
            Collections.sort(entityList, new Comparator<ChohyoShutsuryokuTaishoDateEntity>() {
                @Override
                public int compare(ChohyoShutsuryokuTaishoDateEntity e1, ChohyoShutsuryokuTaishoDateEntity e2) {
                    return e1.get給付実績_コントロールレコード保険者番号().compareTo(e2.get給付実績_コントロールレコード保険者番号());
                }
            });
            List<RString> indexList = new ArrayList<>();
            for (int j = INDEX_0; j < entityList.size() - INDEX_1; j++) {
                if (!entityList.get(j).get給付実績_コントロールレコード保険者番号().equals(entityList.get(j + INDEX_1).
                        get給付実績_コントロールレコード保険者番号())) {
                    indexList.add(new RString(j + INDEX_1));
                }
            }
            indexList.add(new RString(entityList.size()));
            new KyufujissekiKoshinkekkaIchiranReport(処理年月, entityList, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List, システム日時, indexList).writeBy(reportSourceWriter);
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
