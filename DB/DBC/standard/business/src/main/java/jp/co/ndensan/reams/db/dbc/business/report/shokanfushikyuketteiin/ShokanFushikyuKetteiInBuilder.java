/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInBuilder
 */
public class ShokanFushikyuKetteiInBuilder implements IShokanFushikyuKetteiInBuilder {

    private final IShokanFushikyuKetteiInEditor headerEditor;
    private final IShokanFushikyuKetteiInEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor headerEditor
     * @param bodyEditor bodyEditor
     */
    public ShokanFushikyuKetteiInBuilder(IShokanFushikyuKetteiInEditor headerEditor, IShokanFushikyuKetteiInEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public ShokanbaraiFushikyuKetteishaIchiranSource build() {
        return ReportEditorJoiner.from(new ShokanbaraiFushikyuKetteishaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
