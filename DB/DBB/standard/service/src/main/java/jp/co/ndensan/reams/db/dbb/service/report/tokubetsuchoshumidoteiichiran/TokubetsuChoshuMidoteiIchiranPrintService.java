/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshumidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran.TokushoTaishioIchiranMidoteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranPrintService {

    /**
     * 特別徴収未同定一覧表
     *
     * @param 特別徴収未同定一覧情報entityList 特別徴収未同定一覧情報entityList
     * @param 出力順リスト 出力順リスト
     * @param 改頁リスト 改頁リスト
     * @param reportManager ReportManager
     * @param 特徴開始月 特徴開始月
     */
    public void print(List<TokushoTaishioIchiranMidoteiEntity> 特別徴収未同定一覧情報entityList,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト, ReportManager reportManager,
            RString 特徴開始月) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        TokubetsuChoshuMidoteiIchiranProperty property = new TokubetsuChoshuMidoteiIchiranProperty();
        try (ReportAssembler<TokubetsuChoshuMidoteiIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuMidoteiIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            TokubetsuChoshuMidoteiIchiranReport report = TokubetsuChoshuMidoteiIchiranReport
                    .createForm(特別徴収未同定一覧情報entityList, 出力順リスト, 改頁リスト, association, 特徴開始月);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 特別徴収未同定一覧表
     *
     * @param 特別徴収未同定一覧情報entityList List<TokushoTaishioIchiranMidoteiEntity>
     * @param 出力順リスト 出力順リスト
     * @param 改頁リスト 改頁リスト
     * @param 特徴開始月 改頁リスト
     * @return SourceDataCollection
     */
    public SourceDataCollection printChohyo(List<TokushoTaishioIchiranMidoteiEntity> 特別徴収未同定一覧情報entityList,
            List<RString> 出力順リスト, List<RString> 改頁リスト, RString 特徴開始月) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(特別徴収未同定一覧情報entityList, 出力順リスト, 改頁リスト, reportManager, 特徴開始月);
            collection = reportManager.publish();
        }
        return collection;
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
