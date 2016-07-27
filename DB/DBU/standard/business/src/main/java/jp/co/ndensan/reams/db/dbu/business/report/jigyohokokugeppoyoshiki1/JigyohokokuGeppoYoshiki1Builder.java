/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki1.JigyohokokuGeppoYoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1） のパラメータクラスです。
 *
 * @reamsid_L DBU-5530-040 dangjingjing
 */
public class JigyohokokuGeppoYoshiki1Builder implements IJigyohokokuGeppoYoshiki1Builder {

    private final IJigyohokokuGeppoYoshiki1Editor editor;
    private final IJigyohokokuGeppoYoshiki1Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuGeppoYoshiki1Editor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshiki1Editor}
     */
    protected JigyohokokuGeppoYoshiki1Builder(IJigyohokokuGeppoYoshiki1Editor editor, IJigyohokokuGeppoYoshiki1Editor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuGeppoYoshiki1ReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshiki1ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshiki1ReportSource()).join(bodyEditor).join(editor).buildSource();
    }
}
