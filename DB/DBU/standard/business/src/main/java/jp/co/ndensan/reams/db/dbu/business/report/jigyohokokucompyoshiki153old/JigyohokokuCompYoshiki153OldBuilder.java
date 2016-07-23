/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153old;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153OldBuilder implements IJigyohokokuCompYoshiki153OldBuilder {

    private final IJigyohokokuCompYoshiki153OldEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki153OldEditor}
     */
    public JigyohokokuCompYoshiki153OldBuilder(IJigyohokokuCompYoshiki153OldEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki153OldReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki153OldReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki153OldReportSource()).join(editor).buildSource();
    }
}
