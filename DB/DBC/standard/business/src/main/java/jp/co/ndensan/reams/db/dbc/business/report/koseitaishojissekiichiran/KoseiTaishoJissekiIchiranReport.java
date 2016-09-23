/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.koseitaishojissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200097_更正対象給付実績一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-4960-040 qinzhen
 */
public class KoseiTaishoJissekiIchiranReport extends Report<KoseiTaishoJissekiIchiranSource> {

    private final RDateTime 開始日時;
    private final RDateTime 終了日時;

    private final int 連番;
    private final KoseiTaishoJissekiIchiranEntity entity;
    private final IOutputOrder 出力順情報;

    /**
     * コンストラクタです
     *
     * @param entity KoseiTaishoJissekiIchiranEntity
     * @param 開始日時 RDateTime
     * @param 終了日時 RDateTime
     * @param 連番 int
     */
    public KoseiTaishoJissekiIchiranReport(KoseiTaishoJissekiIchiranEntity entity,
            RDateTime 開始日時, RDateTime 終了日時, IOutputOrder 出力順情報, int 連番) {
        this.entity = entity;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.出力順情報 = 出力順情報;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KoseiTaishoJissekiIchiranSource> writer) {

        IKoseiTaishoJissekiIchiranEditor editor = new KoseiTaishoJissekiIchiranEditor(entity, 開始日時, 終了日時, 出力順情報, 連番);

        IKoseiTaishoJissekiIchiranBuilder builder = new KoseiTaishoJissekiIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
