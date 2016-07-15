/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinhoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai.IinhoshushiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会委員報酬支払通知書Builderクラスです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
class IinhoshushiharaiBuilder implements IIinhoshushiharaiBuilder {

    private final IIinhoshushiharaiEditor editor;
    private final IIinhoshushiharaiBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinhoshushiharaiEditor}
     */
    public IinhoshushiharaiBuilder(IIinhoshushiharaiEditor editor,
            IIinhoshushiharaiBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IinhoshushiharaiReportSource}
     */
    @Override
    public IinhoshushiharaiReportSource build() {
        return ReportEditorJoiner.from(new IinhoshushiharaiReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
