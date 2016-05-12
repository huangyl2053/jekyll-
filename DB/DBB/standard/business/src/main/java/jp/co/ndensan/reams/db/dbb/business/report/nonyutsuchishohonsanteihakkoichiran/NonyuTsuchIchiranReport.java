/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranReport
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranReport extends Report<NonyuTsuchIchiranSource> {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final List<RString> 改頁項目リスト;
    private final RString 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 改頁項目リスト List<RString>
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     */
    public NonyuTsuchIchiranReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            List<RString> 改頁項目リスト,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.改頁項目リスト = 改頁項目リスト;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
    }

    /**
     * writeBy
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchIchiranSource> reportSourceWriter) {
        for (int i = 0; i < 編集後本算定通知書共通情報.size(); i++) {
            INonyuTsuchIchiranEditor headerEditor
                    = new HeaderEditor(編集後本算定通知書共通情報.get(i), バッチパラメータ, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名, i);
            INonyuTsuchIchiranBuilder builder = new NonyuTsuchIchiranBuilder(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
