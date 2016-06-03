/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会集計表（判定別）Builderクラスです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
class ShinsakaishukeihyoBuilder implements IShinsakaishukeihyoBuilder {

    private final IShinsakaishukeihyoEditor editor;
    private final IShinsakaishukeihyoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaishukeihyoEditor}
     */
    public ShinsakaishukeihyoBuilder(IShinsakaishukeihyoEditor editor,
            IShinsakaishukeihyoBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaishukeihyoReportSource}
     */
    @Override
    public ShinsakaishukeihyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaishukeihyoReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
