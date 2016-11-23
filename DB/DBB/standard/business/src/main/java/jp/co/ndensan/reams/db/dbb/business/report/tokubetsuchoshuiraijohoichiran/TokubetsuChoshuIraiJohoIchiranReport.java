/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
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
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報;
    private final List<RString> 出力順;
    private final List<RString> 改頁項目;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 宛名情報 UaFt200FindShikibetsuTaishoEntity
     * @param 出力順 List<RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public TokubetsuChoshuIraiJohoIchiranReport(
            TokubetsuChoshuIraiJohoIchiranEntity 帳票出力対象データ,
            UaFt200FindShikibetsuTaishoEntity 宛名情報,
            List<RString> 出力順,
            List<RString> 改頁リスト,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.宛名情報 = 宛名情報;
        this.出力順 = 出力順;
        this.改頁項目 = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIraiJohoIchiranSource> reportSourceWriter) {
        ITokubetsuChoshuIraiJohoIchiranEditor headerEditor = new TokubetsuChoshuIraiJohoIchiranHeaderEditor(
                帳票出力対象データ, 宛名情報, 出力順, 改頁項目, 作成日時);
        ITokubetsuChoshuIraiJohoIchiranEditor bodyEditor = new TokubetsuChoshuIraiJohoIchiranBodyEditor(
                帳票出力対象データ);
        ITokubetsuChoshuIraiJohoIchiranBuilder builder = new TokubetsuChoshuIraiJohoIchiranBuilder(
                headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }

}
