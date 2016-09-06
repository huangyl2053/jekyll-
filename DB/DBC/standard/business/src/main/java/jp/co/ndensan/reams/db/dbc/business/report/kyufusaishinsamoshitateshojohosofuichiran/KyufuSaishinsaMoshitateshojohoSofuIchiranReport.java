/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 Reportクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranReport extends Report<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> {

    private final SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;
    private final boolean 合計フラグ;
    private final Decimal 合計件数;

    /**
     * コンストラクタです。
     *
     * @param 送付一覧表データ SaishinsaMoshitateIchiranhyoTaisyoEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     */
    public KyufuSaishinsaMoshitateshojohoSofuIchiranReport(
            SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            boolean 合計フラグ,
            Decimal 合計件数) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
        this.合計フラグ = 合計フラグ;
        this.合計件数 = 合計件数;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> writer) {

        IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor headerEditor = new KyufuSaishinsaMoshitateshojohoSofuIchiranHeaderEditor(
                送付一覧表データ,
                出力順リスト,
                改頁リスト,
                処理年月,
                作成日時);
        IKyufuSaishinsaMoshitateshojohoSofuIchiranEditor bodyEditor
                = new KyufuSaishinsaMoshitateshojohoSofuIchiranBodyEditor(送付一覧表データ, 連番, 合計フラグ, 合計件数);

        IKyufuSaishinsaMoshitateshojohoSofuIchiranBuilder builder = new KyufuSaishinsaMoshitateshojohoSofuIchiranBuilder(headerEditor, bodyEditor);

        writer.writeLine(builder);
    }

}
