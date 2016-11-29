/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.futsuchoshukarisanteikekkaichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FuchoKariKeisanGoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 帳票設計_DBBRP34001_2_普徴仮算定結果一覧表PrintServiceクラスです。
 *
 * @reamsid_L DBB-0870-030 surun
 */
public class FutsuChoshuKarisanteiKekkaIchiranPrintService {

    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM5 = 5;

    /**
     * 普徴仮算定結果一覧表(単一帳票出力用)
     *
     * @param 普徴仮算定計算後賦課list List<FuchoKariKeisanGoFukaEntity>
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID long
     * @return SourceDataCollection
     */
    public SourceDataCollection printSinger(List<FuchoKariKeisanGoFukaEntity> 普徴仮算定計算後賦課list, long 出力順ID,
            FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(普徴仮算定計算後賦課list, 出力順ID, 調定年度, 賦課年度, 調定日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;

    }

    /**
     * 普徴仮算定結果一覧表の printメソッド(複数帳票出力用)。
     *
     * @param 普徴仮算定計算後賦課list List<FuchoKariKeisanGoFukaEntity>
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID long
     * @param reportManager ReportManager
     */
    public void print(List<FuchoKariKeisanGoFukaEntity> 普徴仮算定計算後賦課list, long 出力順ID,
            FlexibleYear 調定年度, FlexibleYear 賦課年度, YMDHMS 調定日時, ReportManager reportManager) {
        FutsuChoshuKarisanteiKekkaIchiranProperty property = new FutsuChoshuKarisanteiKekkaIchiranProperty();
        try (ReportAssembler<FutsuChoshuKarisanteiKekkaIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<FutsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200006.getReportId(), 出力順ID);
            if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
                executeReport(普徴仮算定計算後賦課list, 調定年度, 賦課年度, 調定日時, association, new ArrayList<RString>(), new ArrayList<RString>(),
                        reportSourceWriter);
                return;
            }
            List<RString> 出力項目リスト = new ArrayList<>();
            List<RString> 改頁項目リスト = new ArrayList<>();
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
            executeReport(普徴仮算定計算後賦課list, 調定年度, 賦課年度, 調定日時, association, 出力項目リスト,
                    改頁項目リスト, reportSourceWriter);

        }
    }

    private void executeReport(List<FuchoKariKeisanGoFukaEntity> 普徴仮算定計算後賦課list,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            ReportSourceWriter<FutsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter) {
        if (普徴仮算定計算後賦課list != null && 普徴仮算定計算後賦課list.size() > NUM0) {
            Collections.sort(普徴仮算定計算後賦課list, new Comparator<FuchoKariKeisanGoFukaEntity>() {
                @Override
                public int compare(FuchoKariKeisanGoFukaEntity o1, FuchoKariKeisanGoFukaEntity o2) {
                    return o1.get通知書番号().compareTo(o2.get通知書番号());
                }
            });
            int i = NUM1;
            for (FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課 : 普徴仮算定計算後賦課list) {
                FutsuChoshuKarisanteiKekkaIchiranReport report = new FutsuChoshuKarisanteiKekkaIchiranReport(普徴仮算定計算後賦課,
                        調定年度, 賦課年度, 調定日時, association, 出力項目リスト, 改頁項目リスト, i);
                report.writeBy(reportSourceWriter);
                i = i + NUM1;
            }
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
