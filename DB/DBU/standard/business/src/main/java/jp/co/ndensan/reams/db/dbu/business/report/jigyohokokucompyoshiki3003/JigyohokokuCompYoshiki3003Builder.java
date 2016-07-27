/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki3003;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-3） Builderクラスです。
 *
 * @reamsid_L DBU-5530-060 dangjingjing
 */
public class JigyohokokuCompYoshiki3003Builder implements IJigyohokokuCompYoshiki3003Builder {

    private final IJigyohokokuCompYoshiki3003Editor editor;
    private final IJigyohokokuCompYoshiki3003Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki3003Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki3003Editor}
     */
    protected JigyohokokuCompYoshiki3003Builder(IJigyohokokuCompYoshiki3003Editor editor,
            IJigyohokokuCompYoshiki3003Editor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki3003ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki3003ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki3003ReportSource()).join(bodyEditor).join(editor).buildSource();
    }
}
