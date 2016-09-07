/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 共同処理用受給者情報一覧表のEntityクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
public class KyodoJukyushaKoshinkekkaIchiranReport extends Report<KyodoJukyushaKoshinkekkaIchiranReportSource> {

    private final KyodoJukyushaKoshinkekkaIchiranReportData 帳票用データ;
    private final RString 帳票制御汎用項目名;
    private final RDateTime 作成日時;
    private final IOutputOrder 出力順情報;

    /**
     * コンストラクタです
     *
     * @param 帳票用データ KyodoJukyushaKoshinkekkaIchiranReportData
     * @param 帳票制御汎用項目名 帳票制御汎用項目名
     * @param 作成日時 RDateTime
     * @param 出力順情報 IOutputOrder
     */
    public KyodoJukyushaKoshinkekkaIchiranReport(
            KyodoJukyushaKoshinkekkaIchiranReportData 帳票用データ,
            RString 帳票制御汎用項目名,
            RDateTime 作成日時,
            IOutputOrder 出力順情報) {
        this.帳票用データ = 帳票用データ;
        this.帳票制御汎用項目名 = 帳票制御汎用項目名;
        this.作成日時 = 作成日時;
        this.出力順情報 = 出力順情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> reportSourceWriter) {
        IKyodoJukyushaKoshinkekkaIchiranEditor editor = new KyodoJukyushaKoshinkekkaIchiranEditor(
                帳票用データ, 帳票制御汎用項目名, 作成日時, 出力順情報);
        IKyodoJukyushaKoshinkekkaIchiranBuilder builder = new KyodoJukyushaKoshinkekkaIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
