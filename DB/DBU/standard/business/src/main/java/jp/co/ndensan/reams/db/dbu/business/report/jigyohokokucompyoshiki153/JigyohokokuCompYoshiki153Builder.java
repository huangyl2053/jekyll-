/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 のReportSourceクラスです。
 *
 * @reamsid_L DBU-5540-060 dangjingjing
 */
public class JigyohokokuCompYoshiki153Builder implements IJigyohokokuCompYoshiki153Builder {

    private final IJigyohokokuCompYoshiki153Editor editor;
    private final IJigyohokokuCompYoshiki153Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki153Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki153Editor}
     */
    public JigyohokokuCompYoshiki153Builder(IJigyohokokuCompYoshiki153Editor editor,
            IJigyohokokuCompYoshiki153Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki153ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki153ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki153ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
