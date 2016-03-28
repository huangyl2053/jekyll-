/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.nonyutsuchishohonsanteihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表
 */
public class NonyuTsuchIchiranReportProcess extends SimpleBatchProcessBase {

    @BatchWriter
    private BatchReportWriter<NonyuTsuchIchiranSource> batchReportWriter;
    private ReportSourceWriter<NonyuTsuchIchiranSource> reportSourceWriter;
    //パラメータ受取変数
    InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報;
    InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ;
    InputParameter<RString> 帳票作成日時;

    @Override
    protected void process() {
        作成したdataを帳票に引き渡す(編集後本算定通知書共通情報.getValue(),
                バッチパラメータ.getValue(),
                帳票作成日時.getValue());
    }

    /**
     * 作成したdataを帳票に引き渡す。
     *
     * @param 編集後本算定通知書共通情報 編集後本算定通知書共通情報
     * @param バッチパラメータ バッチパラメータ
     * @param 帳票作成日時 帳票作成日時
     */
    private void 作成したdataを帳票に引き渡す(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ, RString 帳票作成日時) {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200010.getReportId().value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 市町村コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        NonyuTsuchIchiranReport report = NonyuTsuchIchiranReport.createFrom(
                編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
