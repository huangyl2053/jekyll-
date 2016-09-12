/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki12;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-2）Builderクラスです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
class JigyohokokuCompYoshiki12Builder implements IJigyohokokuCompYoshiki12Builder {

    private final IJigyohokokuCompYoshiki12Editor editor;
    private final IJigyohokokuCompYoshiki12Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki12Editor}
     */
    public JigyohokokuCompYoshiki12Builder(IJigyohokokuCompYoshiki12Editor editor,
            IJigyohokokuCompYoshiki12Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki12ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki12ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki12ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
