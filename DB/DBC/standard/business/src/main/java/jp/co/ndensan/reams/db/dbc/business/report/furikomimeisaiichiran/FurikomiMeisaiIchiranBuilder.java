/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括） Builderクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranBuilder implements IFurikomiMeisaiIchiranBuilder {

    private final IFurikomiMeisaiIchiranEditor headerEditor;
    private final IFurikomiMeisaiIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IFurikomiMeisaiIchiranEditor
     * @param bodyEditor IFurikomiMeisaiIchiranEditor
     */
    public FurikomiMeisaiIchiranBuilder(
            IFurikomiMeisaiIchiranEditor headerEditor,
            IFurikomiMeisaiIchiranEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FurikomiMeisaiIchiranSource}
     */
    @Override
    public FurikomiMeisaiIchiranSource build() {
        return ReportEditorJoiner.from(new FurikomiMeisaiIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
