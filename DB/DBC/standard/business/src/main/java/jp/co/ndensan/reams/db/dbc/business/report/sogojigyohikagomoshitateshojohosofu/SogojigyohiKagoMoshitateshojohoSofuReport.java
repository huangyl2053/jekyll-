/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のReportSourceクラスです。
 *
 * @author DBC-2045-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuReport extends Report<SogojigyohiKagoMoshitateshojohoSofuSource> {

    private final SogojigyohiKagoMoshitateshojohoSofuIchiranEntity 送付一覧表データ;
    private final IOutputOrder 出力順情報;
    private final RYearMonth 処理年月;
    private final YMDHMS 作成日時;
    private final int 連番;
    private final int 合計;
    private final boolean flag;

    /**
     * コンストラクタです。
     *
     * @param 送付一覧表データ SogojigyohiKagoMoshitateshojohoSofuIchiranEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     * @param 連番 int
     * @param 合計 int
     * @param flag boolean
     */
    public SogojigyohiKagoMoshitateshojohoSofuReport(
            SogojigyohiKagoMoshitateshojohoSofuIchiranEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            RYearMonth 処理年月,
            YMDHMS 作成日時,
            int 連番,
            int 合計,
            boolean flag) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順情報 = 出力順情報;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
        this.合計 = 合計;
        this.flag = flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoMoshitateshojohoSofuSource> writer) {
        ISogojigyohiKagoMoshitateshojohoSofuEditor headEditor
                = new SogojigyohiKagoMoshitateshojohoSofuHeadEditor(送付一覧表データ, 出力順情報, 処理年月, 作成日時);
        ISogojigyohiKagoMoshitateshojohoSofuEditor bodyEditor
                = new SogojigyohiKagoMoshitateshojohoSofuBodyEditor(送付一覧表データ, 連番, 合計, flag);
        ISogojigyohiKagoMoshitateshojohoSofuBuilder builder = new SogojigyohiKagoMoshitateshojohoSofuBuilder(headEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
