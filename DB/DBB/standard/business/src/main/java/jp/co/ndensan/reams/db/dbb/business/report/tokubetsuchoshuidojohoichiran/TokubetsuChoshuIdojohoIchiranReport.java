/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
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
    private final UaFt200FindShikibetsuTaishoEntity 宛名情報;
    private final RDateTime 作成日時;
    private final FlexibleYear 賦課年度;
    private final RString 保険者番号;
    private final RString 保険者名称;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;

    /**
     * コンストラクタです
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 宛名情報 UaFt200FindShikibetsuTaishoEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     */
    public TokubetsuChoshuIdojohoIchiranReport(
            TokuChoYidoIchiranEntity 特徴異動情報,
            UaFt200FindShikibetsuTaishoEntity 宛名情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        this.特徴異動情報 = 特徴異動情報;
        this.宛名情報 = 宛名情報;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIdojohoIchiranSource> writer) {
        ITokubetsuChoshuIdojohoIchiranEditor editor
                = new TokubetsuChoshuIdojohoIchiranEditor(特徴異動情報, 宛名情報,
                        作成日時, 賦課年度, 保険者番号, 保険者名称, 出力順リスト, 改頁リスト);
        ITokubetsuChoshuIdojohoIchiranBuilder builder = new TokubetsuChoshuIdojohoIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
