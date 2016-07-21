/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki222016;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki222016.JigyohokokuGeppoYoshiki222016ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-110 lishengli
 */
public class JigyohokokuGeppoYoshiki222016Builder implements IJigyohokokuGeppoYoshiki222016Builder {

    private final IJigyohokokuGeppoYoshiki222016Editor editor;
    private final IJigyohokokuGeppoYoshiki222016Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuGeppoYoshiki222016Editor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshiki222016Editor}
     */
    public JigyohokokuGeppoYoshiki222016Builder(IJigyohokokuGeppoYoshiki222016Editor editor,
            IJigyohokokuGeppoYoshiki222016Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuGeppoYoshiki222016ReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshiki222016ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshiki222016ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
