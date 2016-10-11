/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200003_振込明細一覧表（高額合算） Reportクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranReport extends Report<FurikomiMeisaiIchiranSource> {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;
    private final IOutputOrder 出力順情報;
    private final int 番号;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     * @param 出力順情報 IOutputOrder
     * @param 番号 int
     */
    public FurikomiMeisaiIchiranReport(FurikaeGoMeisaiEntity 振込明細一覧Entity, IOutputOrder 出力順情報, int 番号) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
        this.出力順情報 = 出力順情報;
        this.番号 = 番号;
    }

    @Override
    public void writeBy(ReportSourceWriter<FurikomiMeisaiIchiranSource> writer) {

        IFurikomiMeisaiIchiranEditor headerEditor = new FurikomiMeisaiIchiranHeaderEditor(振込明細一覧Entity, 出力順情報);
        IFurikomiMeisaiIchiranEditor bodyEditor = new FurikomiMeisaiIchiranBodyEditor(振込明細一覧Entity, 番号);
        IFurikomiMeisaiIchiranBuilder builder = new FurikomiMeisaiIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);

    }

}
