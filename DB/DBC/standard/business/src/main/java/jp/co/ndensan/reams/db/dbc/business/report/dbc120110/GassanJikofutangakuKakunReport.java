/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120110;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuKakunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額合算自己負担額確認情報取込一覧表Report
 *
 * @reamsid_L DBC-2650-030 chenjie
 */
public class GassanJikofutangakuKakunReport extends Report<GassanJikofutangakuKakuninSource> {

    private final KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ;
    private final RDateTime 作成日時;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 取込年月;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteiInEntity
     * @param 連番 int
     * @param 取込年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    public GassanJikofutangakuKakunReport(KogakuGassanJikofutangakuKakunEntity 帳票出力対象データ,
            int 連番,
            FlexibleYearMonth 取込年月,
            RDateTime 作成日時,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.連番 = 連番;
        this.取込年月 = 取込年月;
        this.作成日時 = 作成日時;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJikofutangakuKakuninSource> writer) {
        writeLine(writer);
    }

    private void writeLine(ReportSourceWriter<GassanJikofutangakuKakuninSource> writer) {
        IGassanJikofutangakuKakunEditor headerEditor
                = new GassanJikofutangakuKakunHeaderEditor(帳票出力対象データ, 出力順Map, 取込年月, 作成日時, 改頁リスト);
        IGassanJikofutangakuKakunEditor bodyEditor
                = new GassanJikofutangakuKakunBodyEditor(帳票出力対象データ, 連番);
        IGassanJikofutangakuKakunBuilder builder
                = new GassanJikofutangakuKakunBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
