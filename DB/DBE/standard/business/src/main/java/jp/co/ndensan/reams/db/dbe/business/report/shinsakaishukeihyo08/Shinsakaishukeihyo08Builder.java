/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo08;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo08.ShinsakaiShukeihyo08ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会集計表（申請区分別）Builderクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
class Shinsakaishukeihyo08Builder implements IShinsakaishukeihyo08Builder {

    private final IShinsakaishukeihyo08Editor editor;
    private final IShinsakaishukeihyo08BodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaishukeihyo08Editor}
     */
    public Shinsakaishukeihyo08Builder(IShinsakaishukeihyo08Editor editor,
            IShinsakaishukeihyo08BodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaiShukeihyo08ReportSource}
     */
    @Override
    public ShinsakaiShukeihyo08ReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiShukeihyo08ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
