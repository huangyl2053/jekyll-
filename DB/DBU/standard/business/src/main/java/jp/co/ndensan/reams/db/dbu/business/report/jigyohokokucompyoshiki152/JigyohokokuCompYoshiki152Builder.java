/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 Builderクラスです。
 *
 * @reamsid_L DBU-5540-050 dangjingjing
 */
public class JigyohokokuCompYoshiki152Builder implements IJigyohokokuCompYoshiki152Builder {

    private final IJigyohokokuCompYoshiki152Editor editor;
    private final IJigyohokokuCompYoshiki152Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki152Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki152Editor}
     */
    public JigyohokokuCompYoshiki152Builder(IJigyohokokuCompYoshiki152Editor editor, IJigyohokokuCompYoshiki152Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki152ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki152ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki152ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
