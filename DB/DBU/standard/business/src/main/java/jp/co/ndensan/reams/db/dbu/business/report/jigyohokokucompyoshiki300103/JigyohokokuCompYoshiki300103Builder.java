/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki300103;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式1-2）Builderクラスです。
 *
 * @reamsid_L DBU-5600-120 lishengli
 */
class JigyohokokuCompYoshiki300103Builder implements IJigyohokokuCompYoshiki300103Builder {

    private final IJigyohokokuCompYoshiki300103Editor editor;
    private final IJigyohokokuCompYoshiki300103Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki300103Editor}
     */
    public JigyohokokuCompYoshiki300103Builder(IJigyohokokuCompYoshiki300103Editor editor,
            IJigyohokokuCompYoshiki300103Editor bodyEditor) {
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
