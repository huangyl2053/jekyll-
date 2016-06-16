/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 特記事項Builderクラスです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
class NinteiChosaTokkiImageBuilder implements INinteiChosaTokkiImageBuilder {

    private final INinteiChosaTokkiImageEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INinteiChosaTokkiImageEditor}
     */
    public NinteiChosaTokkiImageBuilder(INinteiChosaTokkiImageEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NinteiChosaTokkiImageReportSource}
     */
    @Override
    public NinteiChosaTokkiImageReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaTokkiImageReportSource()).join(editor).buildSource();
    }

}
