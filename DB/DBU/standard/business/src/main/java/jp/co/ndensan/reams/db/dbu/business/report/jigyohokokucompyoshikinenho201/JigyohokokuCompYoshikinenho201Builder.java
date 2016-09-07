/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho201;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho201.JigyohokokuCompYoshikinenho201ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-180 zhaoran
 */
public class JigyohokokuCompYoshikinenho201Builder implements IJigyohokokuCompYoshikinenho201Builder {

    private final IJigyohokokuCompYoshikinenho201Editor editor;
    private final IJigyohokokuCompYoshikinenho201Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshikinenho201Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshikinenho201Editor}
     */
    public JigyohokokuCompYoshikinenho201Builder(IJigyohokokuCompYoshikinenho201Editor editor,
            IJigyohokokuCompYoshikinenho201Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshikinenho201ReportSource}
     */
    @Override
    public JigyohokokuCompYoshikinenho201ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshikinenho201ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
