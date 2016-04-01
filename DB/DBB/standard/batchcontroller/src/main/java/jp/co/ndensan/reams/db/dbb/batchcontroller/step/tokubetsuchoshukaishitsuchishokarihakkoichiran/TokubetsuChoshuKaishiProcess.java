
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）発行一覧表
 */
public class TokubetsuChoshuKaishiProcess extends SimpleBatchProcessBase {

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuKaishiSource> batchReportWriter;
//    private ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter;
//    InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報;
//    InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ;
//    InputParameter<RString> 帳票作成日時;

    @Override
    protected void process() {
        // TODO Checkstyle 対応。
//        作成したdataを帳票に引き渡す(編集後本算定通知書共通情報.getValue(),
//                バッチパラメータ.getValue(), 帳票作成日時.getValue());
    }

//    private void 作成したdataを帳票に引き渡す(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
//            NonyuTsuchIchiranBatchParameter バッチパラメータ, RString 帳票作成日時) {
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(
//                ReportIdDBB.DBB200001.getReportId().value())
//                .create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
//        IAssociationFinder finder = AssociationFinderFactory.createInstance();
//        Association association = finder.getAssociation();
//        RString 市町村コード = association.get地方公共団体コード().value();
//        RString 市町村名 = association.get市町村名();
//        TokubetsuChoshuKaishiReport report = TokubetsuChoshuKaishiReport.createFrom(
//                編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名);
//        report.writeBy(reportSourceWriter);
//
//    }
    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
