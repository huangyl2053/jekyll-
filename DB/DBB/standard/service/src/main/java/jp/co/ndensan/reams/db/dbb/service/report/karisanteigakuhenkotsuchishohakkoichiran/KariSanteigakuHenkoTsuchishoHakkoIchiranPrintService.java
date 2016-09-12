/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteigakuhenkotsuchishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 帳票「帳票設計_DBBRP35003_2_仮算定額変更通知書発行一覧表（平準化＋仮算定異動）」のプリントサービスです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class KariSanteigakuHenkoTsuchishoHakkoIchiranPrintService {

    /**
     * 帳票「仮算定額変更通知書発行一覧表」<br>
     * （DBB200014_KariSanteigakuHenkoTsuchishoHakkoIchiran.rse）を出力します。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param 出力順１ 出力順１
     * @param 出力順２ 出力順２
     * @param 出力順３ 出力順３
     * @param 出力順４ 出力順４
     * @param 出力順５ 出力順５
     * @param 帳票作成日時 帳票作成日時
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print仮算定額変更通知書発行一覧表(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            RString 出力順１, RString 出力順２, RString 出力順３, RString 出力順４, RString 出力順５, RDateTime 帳票作成日時) {

        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print仮算定額変更通知書発行一覧表(editedDataList,
                    出力順１, 出力順２, 出力順３, 出力順４, 出力順５, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票「仮算定額変更通知書発行一覧表」<br>
     * （DBB200014_KariSanteigakuHenkoTsuchishoHakkoIchiran.rse）を出力します。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param 出力順１ 出力順１
     * @param 出力順２ 出力順２
     * @param 出力順３ 出力順３
     * @param 出力順４ 出力順４
     * @param 出力順５ 出力順５
     * @param 帳票作成日時 帳票作成日時
     * @param reportManager reportManager
     */
    public void print仮算定額変更通知書発行一覧表(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            RString 出力順１, RString 出力順２, RString 出力順３, RString 出力順４, RString 出力順５, RDateTime 帳票作成日時, ReportManager reportManager) {

        KariSanteigakuHenkoTsuchishoHakkoIchiranProperty property = new KariSanteigakuHenkoTsuchishoHakkoIchiranProperty();
        try (ReportAssembler<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            KariSanteigakuHenkoTsuchishoHakkoIchiranReport report = new KariSanteigakuHenkoTsuchishoHakkoIchiranReport(editedDataList,
                    出力順１, 出力順２, 出力順３, 出力順４, 出力順５, 帳票作成日時);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票「特別徴収平準化_仮算定額変更通知書_発行一覧表」<br>
     * （DBB200004_TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiran.rse）を出力します。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param outputOrder outputOrder
     * @param 帳票作成日時 帳票作成日時
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print特別徴収平準化_仮算定額変更通知書_発行一覧表(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            IOutputOrder outputOrder, RDateTime 帳票作成日時) {

        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print特別徴収平準化_仮算定額変更通知書_発行一覧表(editedDataList, outputOrder, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票「特別徴収平準化_仮算定額変更通知書_発行一覧表」<br>
     * （DBB200004_TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiran.rse）を出力します。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param outputOrder outputOrder
     * @param 帳票作成日時 帳票作成日時
     * @param reportManager reportManager
     */
    public void print特別徴収平準化_仮算定額変更通知書_発行一覧表(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            IOutputOrder outputOrder, RDateTime 帳票作成日時, ReportManager reportManager) {

        TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty property
                = new TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty(outputOrder);
        try (ReportAssembler<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            TokuChoHeijunkaKariSanteigakuHakkoIchiranReport report = new TokuChoHeijunkaKariSanteigakuHakkoIchiranReport(editedDataList,
                    outputOrder, 帳票作成日時);
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
