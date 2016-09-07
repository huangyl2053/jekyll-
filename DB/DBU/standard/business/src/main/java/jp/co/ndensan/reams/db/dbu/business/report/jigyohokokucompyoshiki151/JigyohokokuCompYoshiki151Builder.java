/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151.JigyohokokuCompYoshiki151ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） Builderクラスです。
 *
 * @reamsid_L DBU-5530-080 dangjingjing
 */
public class JigyohokokuCompYoshiki151Builder implements IJigyohokokuCompYoshiki151Builder {

    private final IJigyohokokuCompYoshiki151Editor editor;
    private final IJigyohokokuCompYoshiki151Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki151Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki151Editor}
     */
    public JigyohokokuCompYoshiki151Builder(IJigyohokokuCompYoshiki151Editor editor, IJigyohokokuCompYoshiki151Editor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki151ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki151ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki151ReportSource()).join(editor).join(bodyEditor).buildSource();
    }

}
