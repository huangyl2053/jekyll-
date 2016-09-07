/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho2111;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho2111.JigyohokokuCompYoshikinenho2111ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-200 zhaoran
 */
public class JigyohokokuCompYoshikinenho2111Builder implements IJigyohokokuCompYoshikinenho2111Builder {

    private final IJigyohokokuCompYoshikinenho2111Editor editor;
    private final IJigyohokokuCompYoshikinenho2111Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshikinenho2111Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshikinenho2111Editor}
     */
    public JigyohokokuCompYoshikinenho2111Builder(IJigyohokokuCompYoshikinenho2111Editor editor,
            IJigyohokokuCompYoshikinenho2111Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshikinenho2111ReportSource}
     */
    @Override
    public JigyohokokuCompYoshikinenho2111ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshikinenho2111ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
