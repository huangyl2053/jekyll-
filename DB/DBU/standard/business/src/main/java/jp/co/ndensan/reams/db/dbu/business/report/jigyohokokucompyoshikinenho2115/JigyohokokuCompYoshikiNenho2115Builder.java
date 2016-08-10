/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho2115;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho2115.JigyohokokuCompYoshikiNenho2115ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-4）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-240 zhaoran
 */
public class JigyohokokuCompYoshikiNenho2115Builder implements IJigyohokokuCompYoshikiNenho2115Builder {

    private final IJigyohokokuCompYoshikiNenho2115Editor editor;
    private final IJigyohokokuCompYoshikiNenho2115Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshikiNenho2115Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshikiNenho2115Editor}
     */
    public JigyohokokuCompYoshikiNenho2115Builder(IJigyohokokuCompYoshikiNenho2115Editor editor,
            IJigyohokokuCompYoshikiNenho2115Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshikiNenho2115ReportSource}
     */
    @Override
    public JigyohokokuCompYoshikiNenho2115ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshikiNenho2115ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
