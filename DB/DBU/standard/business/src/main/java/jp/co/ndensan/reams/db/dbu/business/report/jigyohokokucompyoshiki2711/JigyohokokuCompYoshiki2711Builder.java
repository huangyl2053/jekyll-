/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2711;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護事業状況報告年報（様式2-7）のBuilderです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
public class JigyohokokuCompYoshiki2711Builder implements IJigyohokokuCompYoshiki2711Builder {

    private final IJigyohokokuCompYoshiki2711Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki2711Editor}
     */
    public JigyohokokuCompYoshiki2711Builder(IJigyohokokuCompYoshiki2711Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki2711ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki2711ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki2711ReportSource()).join(editor).buildSource();

    }

}
