/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7-1）のBuilderクラスです。
 *
 * @reamsid_L DBU-5580-040　wanghuafeng
 */
public class JigyohokokuCompYoshiki271Builder implements IJigyohokokuCompYoshiki271Builder {

    private final IJigyohokokuCompYoshiki271Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki271Editor}
     */
    public JigyohokokuCompYoshiki271Builder(IJigyohokokuCompYoshiki271Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki271ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki271ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki271ReportSource()).join(editor).buildSource();
    }

}
