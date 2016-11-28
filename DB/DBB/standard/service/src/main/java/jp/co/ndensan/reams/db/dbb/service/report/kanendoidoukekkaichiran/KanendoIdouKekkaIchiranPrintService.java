/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendoidoukekkaichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran.KeisangojohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 PrintService
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranPrintService {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final ReportId 帳票分類ID = new ReportId("DBB200027_KanendoIdouKekkaIchiran");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 更正前後EntityList List<KeisanjohoAtenaKozaKouseizengoEntity>
     * @param 出力順ID RString
     * @param 調定日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            RString 出力順ID, YMDHMS 調定日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(更正前後EntityList, 出力順ID, 調定日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 更正前後EntityList KeisangojohoAtenaKozaKouseizengoEntityのList
     * @param 出力順ID RString
     * @param 調定日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void printFukusu(List<KeisangojohoAtenaKozaKouseizengoEntity> 更正前後EntityList,
            RString 出力順ID, YMDHMS 調定日時, ReportManager reportManager) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200027.getReportId(),
                        Long.valueOf(出力順ID.toString()));
        KanendoIdouKekkaIchiranProperty property = new KanendoIdouKekkaIchiranProperty(並び順);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association = associationFinder.getAssociation();
        try (ReportAssembler<KanendoIdouKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoIdouKekkaIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
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
            doSort(更正前後EntityList);
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
            DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
            new KanendoIdouKekkaIchiranReport(更正前後EntityList, 出力順ID, 調定日時, association, 並び順の１件目, 並び順の２件目,
                    並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List, 帳票制御共通)
                    .writeBy(reportSourceWriter);
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

    private void doSort(List<KeisangojohoAtenaKozaKouseizengoEntity> list) {
        Collections.sort(list, new Comparator<KeisangojohoAtenaKozaKouseizengoEntity>() {
            @Override
            public int compare(KeisangojohoAtenaKozaKouseizengoEntity o1, KeisangojohoAtenaKozaKouseizengoEntity o2) {
                if (null != o2.get計算後情報_宛名_口座_更正前Entity() && null != o1.get計算後情報_宛名_口座_更正前Entity()) {
                    int flag = o2.get計算後情報_宛名_口座_更正前Entity().get通知書番号()
                            .compareTo(o1.get計算後情報_宛名_口座_更正前Entity().get通知書番号());
                    if (INDEX_0 == flag) {
                        flag = o2.get計算後情報_宛名_口座_更正前Entity().get賦課年度()
                                .compareTo(o1.get計算後情報_宛名_口座_更正前Entity().get賦課年度());
                    }
                    return flag;
                }
                return INDEX_0;
            }
        });
    }

}
