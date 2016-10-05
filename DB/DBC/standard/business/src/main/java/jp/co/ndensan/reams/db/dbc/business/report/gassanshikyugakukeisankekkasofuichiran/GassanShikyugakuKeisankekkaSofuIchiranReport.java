/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 Reportクラスです。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public class GassanShikyugakuKeisankekkaSofuIchiranReport extends Report<GassanShikyugakuKeisankekkaSofuIchiranSource> {

    private final GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ;
    private final IOutputOrder 出力順情報;
    private final RYearMonth 処理年月;
    private final YMDHMS 作成日時;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 送付一覧表データ GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     * @param 連番 int
     */
    public GassanShikyugakuKeisankekkaSofuIchiranReport(
            GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            RYearMonth 処理年月,
            YMDHMS 作成日時,
            int 連番) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順情報 = 出力順情報;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyugakuKeisankekkaSofuIchiranSource> writer) {

        IGassanShikyugakuKeisankekkaSofuIchiranEditor headerEditor = new GassanShikyugakuKeisankekkaSofuIchiranHeaderEditor(出力順情報, 処理年月, 作成日時);

        IGassanShikyugakuKeisankekkaSofuIchiranEditor bodyEditor = new GassanShikyugakuKeisankekkaSofuIchiranBodyEditor(送付一覧表データ, 連番);

        IGassanShikyugakuKeisankekkaSofuIchiranBuilder builder = new GassanShikyugakuKeisankekkaSofuIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);

    }

}
