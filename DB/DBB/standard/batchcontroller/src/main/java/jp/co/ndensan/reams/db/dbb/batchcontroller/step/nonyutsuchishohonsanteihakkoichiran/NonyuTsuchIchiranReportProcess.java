/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.nonyutsuchishohonsanteihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 *
 */
public class NonyuTsuchIchiranReportProcess extends SimpleBatchProcessBase {

    /**
     * PARAMETER_EDITEDKAR 編集後本算定通知書共通情報
     */
    public static final RString PARAMETER_EDITEDKAR;
    /**
     * NAME 帳票作成日時
     */
    public static final RString NAME;
    /**
     * PARAMETER_TITLE タイトル
     */
    public static final RString PARAMETER_TITLE;
    /**
     * 出力順ID
     */
    public static final RString INPUT_PARAM_KEY_出力順ID;

    static {
        PARAMETER_EDITEDKAR = new RString("編集後本算定通知書共通情報");
        NAME = new RString("帳票作成日時");
        PARAMETER_TITLE = new RString("タイトル");
        INPUT_PARAM_KEY_出力順ID = new RString("出力順ID");
    }

    @BatchWriter
    private BatchReportWriter<NonyuTsuchIchiranSource> batchReportWriter;
    private ReportSourceWriter<NonyuTsuchIchiranSource> reportSourceWriter;
    InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報;
    InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ;
    InputParameter<RString> タイトル;
    InputParameter<Long> 出力順ID;

    @Override
    protected void process() {
//        作成したdataを帳票に引き渡す(編集後本算定通知書共通情報.getValue(), 出力順ID.getValue(),
//                帳票作成日時.getValue(), タイトル.getValue());
    }

    /**
     * 作成したdataを帳票に引き渡す。
     *
     * @param 編集後本算定通知書共通情報
     * @param バッチパラメータ
     * @param 出力順ID
     * @param 帳票作成日時
     */
    private void 作成したdataを帳票に引き渡す(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            Long 出力順ID, RString 帳票作成日時) {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200010.getReportId().value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 市町村コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200010.getReportId(), 出力順ID);
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
            }
        }
        NonyuTsuchIchiranReport report = NonyuTsuchIchiranReport.createFrom(
                編集後本算定通知書共通情報, バッチパラメータ, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
