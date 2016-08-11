/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表Builder
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
public class KogakuJigyoShinseishoHakkoIchiranBuilder implements IKogakuJigyoShinseishoHakkoIchiranBuilder {

    private final IKogakuJigyoShinseishoHakkoIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuJigyoShinseishoHakkoIchiranEditor
     */
    public KogakuJigyoShinseishoHakkoIchiranBuilder(
            IKogakuJigyoShinseishoHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KogakuJigyoShinseishoHakkoIchiranSource}
     */
    @Override
    public KogakuJigyoShinseishoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuJigyoShinseishoHakkoIchiranSource()).join(editor).buildSource();
    }

}
