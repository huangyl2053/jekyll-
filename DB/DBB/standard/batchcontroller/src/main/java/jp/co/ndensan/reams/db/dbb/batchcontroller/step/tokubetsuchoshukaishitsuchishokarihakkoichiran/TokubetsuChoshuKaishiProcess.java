
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranentity;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
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
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）発行一覧表
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiProcess extends SimpleBatchProcessBase {

    /**
     * PARAMETER_EDITEDKAR 編集後本算定通知書共通情報
     */
    public static final RString PARAMETER_EDITEDKAR;
    /**
     * NAME 帳票作成日時
     */
    public static final RString NAME;
    /**
     * PARAMETER_TITLE バッチパラメータ
     */
    public static final RString PARAMETER_TITLE;
    /**
     * 出力順ID
     */
    public static final RString INPUT_PARAM_KEY_出力順ID;
    private static final int NUM0 = 0;
    private static final int NUM4 = 4;

    static {
        PARAMETER_EDITEDKAR = new RString("編集後本算定通知書共通情報");
        NAME = new RString("帳票作成日時");
        PARAMETER_TITLE = new RString("バッチパラメータ");
        INPUT_PARAM_KEY_出力順ID = new RString("出力順ID");
    }

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuKaishiSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter;
    InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報;
    InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ;
    InputParameter<RString> 帳票作成日時;

    @Override
    protected void process() {
        作成したdataを帳票に引き渡す(編集後本算定通知書共通情報.getValue(),
                バッチパラメータ.getValue(), 帳票作成日時.getValue());
    }

    /**
     * 変数初期化
     *
     * @param 編集後本算定通知書共通情報 InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>>
     * @param バッチパラメータ InputParameter<NonyuTsuchIchiranBatchParameter>
     * @param 帳票作成日時 InputParameter<RString>
     */
    public TokubetsuChoshuKaishiProcess(InputParameter<List<EditedHonSanteiTsuchiShoKyotsu>> 編集後本算定通知書共通情報,
            InputParameter<NonyuTsuchIchiranBatchParameter> バッチパラメータ,
            InputParameter<RString> 帳票作成日時) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * 変数初期化
     */
    public TokubetsuChoshuKaishiProcess() {
    }

    private void 作成したdataを帳票に引き渡す(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ, RString 帳票作成日時) {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200011.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        RString 市町村コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();

        if (バッチパラメータ == null || バッチパラメータ.get出力帳票entity() == null || バッチパラメータ.get出力帳票entity().isEmpty()) {
            TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                    編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名, new ArrayList(), new ArrayList());
            report.writeBy(reportSourceWriter);
            return;
        }
        RString 出力順ID = RString.EMPTY;
        for (NonyuTsuchIchiranentity nonyutsuchichiranentity : バッチパラメータ.get出力帳票entity()) {
            if (ReportIdDBB.DBB200011.getReportId().value().equals(nonyutsuchichiranentity.get帳票ID().value())) {
                出力順ID = nonyutsuchichiranentity.get出力順ID();
                break;
            }
        }
        if (RString.isNullOrEmpty(出力順ID)) {
            TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                    編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名, new ArrayList(), new ArrayList());
            report.writeBy(reportSourceWriter);
            return;
        }
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200011.getReportId(), Long.parseLong(出力順ID.toString()));
        if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
            TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                    編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名, new ArrayList(), new ArrayList());
            report.writeBy(reportSourceWriter);
            return;
        }
        List<RString> 出力項目リスト = new ArrayList();
        List<RString> 改頁項目リスト = new ArrayList();
        for (int i = NUM0; i < NUM4; i++) {
            if (並び順.get設定項目リスト().size() > i) {
                出力項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                if (並び順.get設定項目リスト().get(i).is改頁項目()) {
                    改頁項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                } else {
                    改頁項目リスト.add(RString.EMPTY);
                }
            } else {
                break;
            }
        }
        TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                編集後本算定通知書共通情報, バッチパラメータ, 帳票作成日時, 市町村コード, 市町村名, 出力項目リスト, 改頁項目リスト);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
    }
}
