/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki300104;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式1-3）Builderクラスです。
 *
 * @reamsid_L DBU-5600-130 lishengli
 */
class JigyohokokuCompYoshiki300104Builder implements IJigyohokokuCompYoshiki300104Builder {

    private final IJigyohokokuCompYoshiki300104Editor editor;
    private final IJigyohokokuCompYoshiki300104Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki300104Editor}
     */
    public JigyohokokuCompYoshiki300104Builder(IJigyohokokuCompYoshiki300104Editor editor,
            IJigyohokokuCompYoshiki300104Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki300103ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki300103ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki300103ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
