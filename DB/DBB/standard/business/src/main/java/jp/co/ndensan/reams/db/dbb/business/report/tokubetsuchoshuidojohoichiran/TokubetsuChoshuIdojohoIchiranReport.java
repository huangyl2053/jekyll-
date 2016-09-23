/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 Report クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranReport extends Report<TokubetsuChoshuIdojohoIchiranSource> {

    private final TokuChoYidoIchiranEntity 特徴異動情報;
    private final RDateTime 作成日時;
    private final FlexibleYear 賦課年度;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;

    /**
     * コンストラクタです
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    public TokubetsuChoshuIdojohoIchiranReport(
            TokuChoYidoIchiranEntity 特徴異動情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト) {
        this.特徴異動情報 = 特徴異動情報;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIdojohoIchiranSource> writer) {
        ITokubetsuChoshuIdojohoIchiranEditor editor
                = new TokubetsuChoshuIdojohoIchiranEditor(特徴異動情報, 作成日時, 賦課年度, 出力順Map, 改頁リスト);
        ITokubetsuChoshuIdojohoIchiranBuilder builder = new TokubetsuChoshuIdojohoIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
