/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyumeisai;

import jp.co.ndensan.reams.db.dbc.entity.report.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 請求明細・給付管理票返戻（保留）一覧表Builderクラスです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranBuilder implements ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranBuilder {

    private final ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor}
     */
    public SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranBuilder(ISeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource}
     */
    @Override
    public SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource build() {
        return ReportEditorJoiner.from(new SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource()).join(editor).buildSource();
    }

}
