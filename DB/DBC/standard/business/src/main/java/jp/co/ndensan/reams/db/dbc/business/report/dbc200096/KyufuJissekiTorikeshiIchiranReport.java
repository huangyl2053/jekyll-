/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200096;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseitaishoKyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200096.KyufuJissekiTorikeshiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200096_給付実績取消一覧表Report
 *
 * @reamsid_L DBC-4960-050 jiangxiaolong
 */
public class KyufuJissekiTorikeshiIchiranReport
        extends Report<KyufuJissekiTorikeshiIchiranSource> {

    private final KoseitaishoKyuhuzissekiJohoTempEntity entity;
    private final RDateTime 抽出期間開始日時;
    private final RDateTime 抽出期間終了日時;
    private final Association association;
    private final RString 出力順;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param entity KoseitaishoKyuhuzissekiJohoTempEntity
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     * @param association Association
     * @param 出力順 RString
     * @param 連番 int
     */
    public KyufuJissekiTorikeshiIchiranReport(
            KoseitaishoKyuhuzissekiJohoTempEntity entity, RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時, RString 出力順, Association association, int 連番) {
        this.entity = entity;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.出力順 = 出力順;
        this.association = association;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuJissekiTorikeshiIchiranSource> writer) {
        writeLine(writer);
    }

    private void writeLine(ReportSourceWriter<KyufuJissekiTorikeshiIchiranSource> writer) {
        IKyufuJissekiTorikeshiIchiranEditor bodyEditor
                = new KyufuJissekiTorikeshiIchiranEditor(entity, 抽出期間開始日時, 抽出期間終了日時,
                        出力順, association, 連番);
        IKyufuJissekiTorikeshiIchiranBuilder builder
                = new KyufuJissekiTorikeshiIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
