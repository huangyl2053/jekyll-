/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200090_負担割合証発行一覧表のBuilderです。
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranBuilder implements IFutanWariaiShoHakkoIchiranBuilder {

    private final IFutanWariaiShoHakkoIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IFutanWariaiShoHakkoIchiranEditor}
     */
    FutanWariaiShoHakkoIchiranBuilder(IFutanWariaiShoHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutanWariaiShoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new FutanWariaiShoHakkoIchiranSource()).join(editor).buildSource();
    }

}
