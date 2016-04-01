/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 帳票設計_DBBRP43002_3_介護保険料額決定通知書発行一覧表
 */
public class KaigoHokenryogakuProcess extends SimpleBatchProcessBase {

    @BatchWriter
    private BatchReportWriter<KaigoHokenryogakuSource> batchReportWriter;
//    private ReportSourceWriter<KaigoHokenryogakuSource> reportSourceWriter;
//    InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報;
//    InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ;
//    InputParameter<RString> 帳票作成日時;
//    InputParameter<RString> タイトル;

    @Override
    protected void process() {
        // TODO Checkstyle対応
//        Map<String, Object> sqlParam = new HashMap<>();
//        作成したdataを帳票に引き渡す()
//        作成したdataを帳票に引き渡す(編集後本算定通知書共通情報.getValue(), バッチパラメータ.getValue(),
//                帳票作成日時.getValue(), タイトル.getValue());

    }

//    /**
//     * 作成したdataを帳票に引き渡す。
//     *
//     * @param 編集後本算定通知書共通情報 編集後本算定通知書共通情報
//     * @param バッチパラメータ バッチパラメータ
//     * @param 帳票作成日時 帳票作成日時
//     */
//    private void 作成したdataを帳票に引き渡す(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
//            NonyuTsuchIchiranBatchParameter バッチパラメータ, RString 帳票作成日時, RString タイトル) {
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(
//                ReportIdDBB.DBB200012.getReportId().value())
//                .create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
//        IAssociationFinder finder = AssociationFinderFactory.createInstance();
//        Association association = finder.getAssociation();
//        RString 市町村コード = association.get地方公共団体コード().value();
//        RString 市町村名 = association.get市町村名();
//        KaigoHokenryogakuReport report = KaigoHokenryogakuReport.createFrom(
//                編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, タイトル, 市町村コード, 市町村名);
//        report.writeBy(reportSourceWriter);
//
//    }
    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
