/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakuhakkoichiran;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200035_高額合算自己負担額証明書発行一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-2380-040 qinzhen
 */
public class GassanJikofutangakuHakkoIchiranReport extends Report<GassanJikofutangakuHakkoIchiranSource> {

    private final KogakuGassanData entity;
    private final IOutputOrder 出力順情報;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanDataEntity
     * @param 出力順情報 IOutputOrder
     * @param 連番 int
     */
    public GassanJikofutangakuHakkoIchiranReport(KogakuGassanData entity, IOutputOrder 出力順情報, int 連番) {
        this.entity = entity;
        this.出力順情報 = 出力順情報;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJikofutangakuHakkoIchiranSource> writer) {

        IGassanJikofutangakuHakkoIchiranEditor editor = new GassanJikofutangakuHakkoIchiranEditor(entity, 出力順情報, 連番);

        IGassanJikofutangakuHakkoIchiranBuilder builder = new GassanJikofutangakuHakkoIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
