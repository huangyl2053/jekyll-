/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho2112;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho2112.JigyohokokuCompYoshikiNenho2112ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-210 zhaoran
 */
public class JigyohokokuCompYoshikiNenho2112Builder implements IJigyohokokuCompYoshikiNenho2112Builder {

    private final IJigyohokokuCompYoshikiNenho2112Editor editor;
    private final IJigyohokokuCompYoshikiNenho2112Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshikiNenho2112Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshikiNenho2112Editor}
     */
    public JigyohokokuCompYoshikiNenho2112Builder(IJigyohokokuCompYoshikiNenho2112Editor editor,
            IJigyohokokuCompYoshikiNenho2112Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshikiNenho2112ReportSource}
     */
    @Override
    public JigyohokokuCompYoshikiNenho2112ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshikiNenho2112ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
