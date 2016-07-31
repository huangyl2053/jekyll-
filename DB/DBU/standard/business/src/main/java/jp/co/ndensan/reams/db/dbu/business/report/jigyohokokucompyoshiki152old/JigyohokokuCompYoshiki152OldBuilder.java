/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） Builderクラスです。
 *
 * @reamsid_L DBU-5550-040 dangjingjing
 */
public class JigyohokokuCompYoshiki152OldBuilder implements IJigyohokokuCompYoshiki152OldBuilder {

    private final IJigyohokokuCompYoshiki152OldEditor bodyEditor;
    private final IJigyohokokuCompYoshiki152OldEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki152OldEditor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki152OldEditor}
     */
    public JigyohokokuCompYoshiki152OldBuilder(IJigyohokokuCompYoshiki152OldEditor bodyEditor, IJigyohokokuCompYoshiki152OldEditor editor) {
        this.bodyEditor = bodyEditor;
        this.editor = editor;
    }

    /**
     * /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki152OldReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki152OldReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki152OldReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
