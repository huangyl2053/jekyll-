/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151300106;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式1-5）のBuilderクラスです。
 *
 * @reamsid_L DBU-5600-150 lishengli
 */
public class JigyohokokuCompYoshiki151300106Builder implements IJigyohokokuCompYoshiki151300106Builder {

    private final IJigyohokokuCompYoshiki151300106Editor editor;
    private final IJigyohokokuCompYoshiki151300106Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki151300106Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki151300106Editor}
     */
    public JigyohokokuCompYoshiki151300106Builder(IJigyohokokuCompYoshiki151300106Editor editor, IJigyohokokuCompYoshiki151300106Editor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki151300106ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki151300106ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki151300106ReportSource()).join(editor).join(bodyEditor).buildSource();
    }

}
