/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定実施状況統計Builderクラスです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
class JisshiJokyoTokeiBuilder implements IJisshiJokyoTokeiBuilder {

    private final IJisshiJokyoTokeiEditor editor;
    private final IJisshiJokyoTokeiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJohoTeikyoShiryoEditor}
     */
    public JisshiJokyoTokeiBuilder(IJisshiJokyoTokeiEditor editor,
            IJisshiJokyoTokeiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JisshiJokyoTokeiReportSource}
     */
    @Override
    public JisshiJokyoTokeiReportSource build() {
        return ReportEditorJoiner.from(new JisshiJokyoTokeiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
