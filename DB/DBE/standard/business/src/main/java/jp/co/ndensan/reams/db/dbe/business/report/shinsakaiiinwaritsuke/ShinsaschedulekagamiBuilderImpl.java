/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会スケジュール表かがみBuilderのクラスです。
 */
public class ShinsaschedulekagamiBuilderImpl implements IShinsaschedulekagamiBuilder {

    private final IShinsaschedulekagamiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsaschedulekagamiEditor}
     */
    public ShinsaschedulekagamiBuilderImpl(IShinsaschedulekagamiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaschedulekagamiReportSource}
     */
    @Override
    public ShinsaschedulekagamiReportSource build() {
        return ReportEditorJoiner.from(new ShinsaschedulekagamiReportSource()).join(editor).buildSource();
    }

}
