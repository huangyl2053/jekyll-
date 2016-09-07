/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14300105;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式1-4）Builderクラスです。
 *
 * @reamsid_L DBU-5600-140 lishengli
 */
public class JigyohokokuCompYoshiki14300105Builder implements IJigyohokokuCompYoshiki14300105Builder {

    private final IJigyohokokuCompYoshiki14300105Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki14300105Editor}
     */
    public JigyohokokuCompYoshiki14300105Builder(IJigyohokokuCompYoshiki14300105Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki14300105ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki14300105ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki14300105ReportSource()).join(editor).buildSource();
    }
}
