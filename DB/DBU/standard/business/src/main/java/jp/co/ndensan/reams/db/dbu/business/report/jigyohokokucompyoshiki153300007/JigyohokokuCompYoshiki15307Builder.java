/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）Builderクラスです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
public class JigyohokokuCompYoshiki15307Builder implements IJigyohokokuCompYoshiki15307Builder {

    private final IJigyohokokuCompYoshiki15307Editor editor;
    private final IJigyohokokuCompYoshiki15307Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki15307Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki15307Editor}
     */
    public JigyohokokuCompYoshiki15307Builder(IJigyohokokuCompYoshiki15307Editor editor, IJigyohokokuCompYoshiki15307Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki15307ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki15307ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki15307ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
