/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 再審査決定通知書情報取込一覧表帳票用Report
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInReport extends Report<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final SaishinsaKetteiResultEntity 帳票出力対象データ;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final List<RString> 出力項目リスト;
    private final boolean 集計Flag;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SaishinsaKetteiResultEntity
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 集計Flag boolean
     * @param 出力項目リスト List<RString>
     * @param 連番 int
     */
    public SaishinsaKetteiHokenshaInReport(
            SaishinsaKetteiResultEntity 帳票出力対象データ,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            List<RString> 出力項目リスト, boolean 集計Flag, int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.出力項目リスト = 出力項目リスト;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> writer) {
        writeLine(writer, 帳票出力対象データ, 集計Flag);
    }

    private void writeLine(ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> writer,
            SaishinsaKetteiResultEntity 帳票出力対象データ, boolean 集計Flag) {
        ISaishinsaKetteiHokenshaInEditor editor
                = new SaishinsaKetteiHokenshaInEditor(帳票出力対象データ, 処理年月, 作成日時, 出力項目リスト, 集計Flag, 連番);
        ISaishinsaKetteiHokenshaInBuilder builder
                = new SaishinsaKetteiHokenshaInBuilder(editor);
        writer.writeLine(builder);
    }

}
