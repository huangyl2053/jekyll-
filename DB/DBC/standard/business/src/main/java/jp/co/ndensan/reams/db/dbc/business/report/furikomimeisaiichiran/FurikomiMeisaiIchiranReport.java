/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括） Reportクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranReport extends Report<FurikomiMeisaiIchiranSource> {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     */
    public FurikomiMeisaiIchiranReport(FurikaeGoMeisaiEntity 振込明細一覧Entity) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FurikomiMeisaiIchiranSource> writer) {

        IFurikomiMeisaiIchiranEditor headerEditor = new FurikomiMeisaiIchiranHeaderEditor(振込明細一覧Entity);
        IFurikomiMeisaiIchiranEditor bodyEditor = new FurikomiMeisaiIchiranBodyEditor(振込明細一覧Entity);
        IFurikomiMeisaiIchiranBuilder builder = new FurikomiMeisaiIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);

    }

}
