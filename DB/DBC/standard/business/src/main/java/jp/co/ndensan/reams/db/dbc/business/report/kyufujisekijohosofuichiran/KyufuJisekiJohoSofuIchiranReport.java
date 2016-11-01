/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyuufujisekikoshinnkekka.KyuufuJisekiKoshinnKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200053_給付実績情報送付一覧表　Reportクラスです。
 *
 * @reamsid_L DBC-2460-030 lijian
 */
public class KyufuJisekiJohoSofuIchiranReport extends Report<KyufuJisekiJohoSofuIchiranSource> {

    private final KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final boolean 合計フラグ;
    private final Decimal 合計件数;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 給付実績更新結果一覧表データ KyuufuJisekiKoshinnKekkaEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @param 連番 int
     */
    public KyufuJisekiJohoSofuIchiranReport(
            KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            boolean 合計フラグ,
            Decimal 合計件数,
            int 連番) {

        this.給付実績更新結果一覧表データ = 給付実績更新結果一覧表データ;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.合計フラグ = 合計フラグ;
        this.合計件数 = 合計件数;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuJisekiJohoSofuIchiranSource> writer) {

        IKyufuJisekiJohoSofuIchiranEditor headerEditor = new KyufuJisekiJohoSofuIchiranHeaderEditor(
                給付実績更新結果一覧表データ,
                出力順リスト,
                改頁リスト,
                処理年月,
                作成日時);
        IKyufuJisekiJohoSofuIchiranEditor bodyEditor
                = new KyufuJisekiJohoSofuIchiranBodyEditor(給付実績更新結果一覧表データ, 合計フラグ, 合計件数, 連番);

        IKyufuJisekiJohoSofuIchiranBuilder builder = new KyufuJisekiJohoSofuIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);

    }

}
