/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会集計表（申請区分別）Builderクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
class ShinsakaishukeihyoShinseiBuilder implements IShinsakaishukeihyoShinseiBuilder {

    private final IShinsakaishukeihyoShinseiEditor editor;
    private final IShinsakaishukeihyoShinseiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaishukeihyoShinseiEditor}
     */
    public ShinsakaishukeihyoShinseiBuilder(IShinsakaishukeihyoShinseiEditor editor,
            IShinsakaishukeihyoShinseiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaiShukeihyoShinseiReportSource}
     */
    @Override
    public ShinsakaiShukeihyoShinseiReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiShukeihyoShinseiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
