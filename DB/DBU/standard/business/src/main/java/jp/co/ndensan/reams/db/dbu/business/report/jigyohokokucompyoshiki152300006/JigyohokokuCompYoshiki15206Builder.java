/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152300006;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）Builderクラスです。
 *
 * @reamsid_L DBU-5600-160 wangrenze
 */
public class JigyohokokuCompYoshiki15206Builder implements IJigyohokokuCompYoshiki15206Builder {

    private final IJigyohokokuCompYoshiki15206Editor editor;
    private final IJigyohokokuCompYoshiki15206Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki15206Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki15206Editor}
     */
    public JigyohokokuCompYoshiki15206Builder(IJigyohokokuCompYoshiki15206Editor editor, IJigyohokokuCompYoshiki15206Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki15206ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki15206ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki15206ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
