/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiReport
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiReport extends Report<TokubetsuChoshuKaishiSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 帳票作成日時;
    private final List<RString> 改頁項目リスト;
    private final List<RString> 出力項目リスト;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ TokubetsuChoshuKaishiParameter
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public TokubetsuChoshuKaishiReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名, List<RString> 出力項目リスト, List<RString> 改頁項目リスト) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.改頁項目リスト = 改頁項目リスト;
        this.出力項目リスト = 出力項目リスト;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter) {
        for (int i = 0; i < 編集後本算定通知書共通情報.size(); i++) {
            ITokubetsuChoshuKaishiEditor tokubetsuchoshukaishieditor = new TokubetsuChoshuKaishiEditor(
                    編集後本算定通知書共通情報.get(i), バッチパラメータ, 出力項目リスト, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名, i);
            TokubetsuChoshuKaishiBuilder builder = new TokubetsuChoshuKaishiBuilder(tokubetsuchoshukaishieditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
