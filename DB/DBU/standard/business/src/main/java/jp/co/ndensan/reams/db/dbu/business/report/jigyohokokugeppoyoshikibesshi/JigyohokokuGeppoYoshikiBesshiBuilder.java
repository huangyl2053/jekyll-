/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（別紙） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiBuilder implements IJigyohokokuGeppoYoshikiBesshiBuilder {

    private final IJigyohokokuGeppoYoshikiBesshiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuGeppoYoshikiBesshiEditor}
     */
    public JigyohokokuGeppoYoshikiBesshiBuilder(IJigyohokokuGeppoYoshikiBesshiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuGeppoYoshikiBesshiReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshikiBesshiReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshikiBesshiReportSource()).join(editor).buildSource();
    }

}
