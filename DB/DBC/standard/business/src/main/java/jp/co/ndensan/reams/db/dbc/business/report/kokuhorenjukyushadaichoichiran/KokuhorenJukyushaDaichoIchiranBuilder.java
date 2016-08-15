/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200006_受給者台帳（一覧表）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaDaichoIchiranBuilder implements IKokuhorenJukyushaDaichoIchiranBuilder {

    private final IKokuhoernJukyushaDaichoIchiranEditor headerEditor;
    private final IKokuhoernJukyushaDaichoIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IKokuhoernJukyushaDaichoIchiranEditor
     * @param bodyEditor IKokuhoernJukyushaDaichoIchiranEditor
     */
    public KokuhorenJukyushaDaichoIchiranBuilder(
            IKokuhoernJukyushaDaichoIchiranEditor headerEditor,
            IKokuhoernJukyushaDaichoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaKoshinkekkaIchiranSource}
     */
    @Override
    public JukyushaKoshinkekkaIchiranSource build() {
        return ReportEditorJoiner.from(new JukyushaKoshinkekkaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
