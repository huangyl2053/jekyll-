/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 Reportクラスです。
 *
 * @reamsid_L DBC-2660-040 lijian
 */
public class GassanHoseizumiJikofutangakuSofuchiranReport extends Report<GassanHoseizumiJikofutangakuSofuchiranSource> {

    private final SyuturyokuEntity 送付一覧表データ;
    private final IOutputOrder 出力順情報;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;
    private final RString 設定値;

    /**
     * コンストラクタです。
     *
     * @param 送付一覧表データ SyuturyokuEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 設定値 RString
     */
    public GassanHoseizumiJikofutangakuSofuchiranReport(
            SyuturyokuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            RString 設定値) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順情報 = 出力順情報;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
        this.設定値 = 設定値;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanHoseizumiJikofutangakuSofuchiranSource> writer) {

        IGassanHoseizumiJikofutangakuSofuchiranEditor headerEditor = new GassanHoseizumiJikofutangakuSofuchiranHeaderEditor(
                出力順情報, 処理年月, 作成日時, 設定値);

        IGassanHoseizumiJikofutangakuSofuchiranEditor bodyEditor = new GassanHoseizumiJikofutangakuSofuchiranBodyEditor(送付一覧表データ, 連番);

        IGassanHoseizumiJikofutangakuSofuchiranBuilder builder = new GassanHoseizumiJikofutangakuSofuchiranBuilder(headerEditor, bodyEditor);

        writer.writeLine(builder);
    }
}
