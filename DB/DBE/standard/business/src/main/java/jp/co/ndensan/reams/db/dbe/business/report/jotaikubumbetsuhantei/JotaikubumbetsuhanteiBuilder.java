/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護状態区分別判定件数Builderクラスです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
class JotaikubumbetsuhanteiBuilder implements IJotaikubumbetsuhanteiBuilder {

    private final IJotaikubumbetsuhanteiEditor editor;
    private final IJotaikubumbetsuhanteiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJohoTeikyoShiryoEditor}
     */
    public JotaikubumbetsuhanteiBuilder(IJotaikubumbetsuhanteiEditor editor,
            IJotaikubumbetsuhanteiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JotaikubumbetsuhanteiReportSource}
     */
    @Override
    public JotaikubumbetsuhanteiReportSource build() {
        return ReportEditorJoiner.from(new JotaikubumbetsuhanteiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
