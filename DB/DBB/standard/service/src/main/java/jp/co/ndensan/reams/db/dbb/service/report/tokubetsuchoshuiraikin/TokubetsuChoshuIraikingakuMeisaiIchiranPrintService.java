/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuiraikin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のPrintServiceです。
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranPrintService {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 通知書情報List List<KariTokuchoKaishiTsuchisyoJoho>
     * @param 出力順ID RString
     * @param 調定年度 RYear
     * @param 帳票作成日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<KariTokuchoKaishiTsuchisyoJoho> 通知書情報List,
            RString 出力順ID, RYear 調定年度, YMDHMS 帳票作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(通知書情報List, 出力順ID, 調定年度, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 通知書情報List List<KariTokuchoKaishiTsuchisyoJoho>
     * @param 出力順ID RString
     * @param 調定年度 RYear
     * @param 帳票作成日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void printFukusu(List<KariTokuchoKaishiTsuchisyoJoho> 通知書情報List,
            RString 出力順ID, RYear 調定年度, YMDHMS 帳票作成日時, ReportManager reportManager) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200023.getReportId(),
                        Long.valueOf(出力順ID.toString()));
        TokubetsuChoshuIraikingakuMeisaiIchiranProperty property = new TokubetsuChoshuIraikingakuMeisaiIchiranProperty(並び順);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association = associationFinder.getAssociation();
        try (ReportAssembler<TokubetsuChoshuIraikingakuMeisaiIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
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
            doSort(通知書情報List);
            new TokubetsuChoshuIraikingakuMeisaiIchiranReport(通知書情報List,
                    調定年度, 帳票作成日時, 並び順の１件目, 並び順の２件目, 並び順の３件目,
                    並び順の４件目, 並び順の５件目, 改頁項目List, association)
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

    private void doSort(List<KariTokuchoKaishiTsuchisyoJoho> list) {
        Collections.sort(list, new Comparator<KariTokuchoKaishiTsuchisyoJoho>() {
            @Override
            public int compare(KariTokuchoKaishiTsuchisyoJoho o1, KariTokuchoKaishiTsuchisyoJoho o2) {
                int flag = INDEX_0;
                if (null != o2.get編集後仮算定通知書共通情報().get通知書番号()
                        && null != o1.get編集後仮算定通知書共通情報().get通知書番号()) {
                    flag = o2.get編集後仮算定通知書共通情報().get通知書番号()
                            .compareTo(o1.get編集後仮算定通知書共通情報().get通知書番号());
                }
                if (INDEX_0 == flag && (null != o2.get編集後仮算定通知書共通情報().get識別コード()
                        && null != o1.get編集後仮算定通知書共通情報().get識別コード())) {
                    flag = o2.get編集後仮算定通知書共通情報().get識別コード()
                            .compareTo(o1.get編集後仮算定通知書共通情報().get識別コード());
                }
                if (INDEX_0 == flag && (null != o2.get編集後仮算定通知書共通情報().get編集後宛先()
                        && null != o1.get編集後仮算定通知書共通情報().get編集後宛先())) {
                    flag = o2.get編集後仮算定通知書共通情報().get編集後宛先().get行政区コード()
                            .compareTo(o1.get編集後仮算定通知書共通情報().get編集後宛先().get行政区コード());
                }
                return flag;
            }
        });
    }
}
