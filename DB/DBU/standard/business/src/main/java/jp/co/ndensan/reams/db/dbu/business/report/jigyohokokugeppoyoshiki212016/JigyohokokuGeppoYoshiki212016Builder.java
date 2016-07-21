/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki212016;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki212016.JigyohokokuGeppoYoshiki212016ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-100 lishengli
 */
public class JigyohokokuGeppoYoshiki212016Builder implements IJigyohokokuGeppoYoshiki212016Builder {

    private final IJigyohokokuGeppoYoshiki212016Editor editor;
    private final IJigyohokokuGeppoYoshiki212016Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuGeppoYoshiki212016Editor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshiki212016Editor}
     */
    public JigyohokokuGeppoYoshiki212016Builder(IJigyohokokuGeppoYoshiki212016Editor editor,
            IJigyohokokuGeppoYoshiki212016Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuGeppoYoshiki212016ReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshiki212016ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshiki212016ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
