/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・一般状況（様式1-4） Builderクラスです。
 *
 * @reamsid_L DBU-5530-070 dangjingjing
 */
public class JigyohokokuCompYoshiki14Builder implements IJigyohokokuCompYoshiki14Builder {

    private final IJigyohokokuCompYoshiki14Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki14Editor}
     */
    public JigyohokokuCompYoshiki14Builder(IJigyohokokuCompYoshiki14Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki14ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki14ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki14ReportSource()).join(editor).buildSource();
    }
}
