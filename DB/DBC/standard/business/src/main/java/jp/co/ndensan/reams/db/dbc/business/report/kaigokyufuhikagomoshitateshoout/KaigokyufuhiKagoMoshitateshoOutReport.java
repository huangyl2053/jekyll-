/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomoshitateshoout.KyufuKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票設計_DBC200045_給付過誤申立書情報送付一覧表Reportクラスです
 *
 * @reamsid_L DBC-2530-040 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutReport extends Report<KyufuKagoMoshitateshojohoSofuIchiranSource> {

    private final KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;
    private final boolean 合計出力flag;
    private final FlexibleYearMonth 処理年月;
    private final int 件数;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT1613SinsaKetteiSeikyuGokeiTempEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 合計出力flag boolean
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 件数 int
     * @param 連番 int
     */
    public KaigokyufuhiKagoMoshitateshoOutReport(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時,
            boolean 合計出力flag,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            int 件数,
            int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.合計出力flag = 合計出力flag;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.件数 = 件数;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuKagoMoshitateshojohoSofuIchiranSource> reportSourceWriter) {
        IKaigokyufuhiKagoMoshitateshoOutEditor headerEditor
                = new KaigokyufuhiKagoMoshitateshoOutHeaderEditor(出力順Map, 作成日時, 帳票出力対象データ, 改頁リスト, 処理年月);
        IKaigokyufuhiKagoMoshitateshoOutEditor bodyEditor = new KaigokyufuhiKagoMoshitateshoOutBodyEditor(帳票出力対象データ, 合計出力flag, 件数, 連番);
        IKaigokyufuhiKagoMoshitateshoOutBuilder builder
                = new KaigokyufuhiKagoMoshitateshoOutBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
