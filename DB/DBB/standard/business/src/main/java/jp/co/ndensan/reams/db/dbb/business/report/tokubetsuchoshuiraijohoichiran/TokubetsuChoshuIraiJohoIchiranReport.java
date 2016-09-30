/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表
 *
 * @reamsid_L DBB-1840-060 chenyadong
 */
public class TokubetsuChoshuIraiJohoIchiranReport extends Report<TokubetsuChoshuIraiJohoIchiranSource> {

    private final TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁項目;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public TokubetsuChoshuIraiJohoIchiranReport(
            TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁項目 = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIraiJohoIchiranSource> reportSourceWriter) {
        ITokubetsuChoshuIraiJohoIchiranEditor headerEditor = new TokubetsuChoshuIraiJohoIchiranHeaderEditor(
                帳票出力対象データ, 出力順Map, 改頁項目, 作成日時);
        ITokubetsuChoshuIraiJohoIchiranEditor bodyEditor = new TokubetsuChoshuIraiJohoIchiranBodyEditor(
                帳票出力対象データ);
        ITokubetsuChoshuIraiJohoIchiranBuilder builder = new TokubetsuChoshuIraiJohoIchiranBuilder(
                headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }

}
