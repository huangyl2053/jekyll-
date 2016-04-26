/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定事業状況報告Builderクラスです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
class JigyoJokyoHokokuBuilder implements IJigyoJokyoHokokuBuilder {

    private final IJigyoJokyoHokokuEditor editor;
    private final IJigyoJokyoHokokuBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJohoTeikyoShiryoEditor}
     */
    public JigyoJokyoHokokuBuilder(IJigyoJokyoHokokuEditor editor,
            IJigyoJokyoHokokuBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyoJokyoHokokuReportSource}
     */
    @Override
    public JigyoJokyoHokokuReportSource build() {
        return ReportEditorJoiner.from(new JigyoJokyoHokokuReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
