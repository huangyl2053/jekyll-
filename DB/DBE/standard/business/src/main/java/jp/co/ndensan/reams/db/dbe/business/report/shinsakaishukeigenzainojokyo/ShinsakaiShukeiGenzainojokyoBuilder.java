/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会集計表（現在の状況別）のBuilderクラスです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
class ShinsakaiShukeiGenzainojokyoBuilder implements IShinsakaiShukeiGenzainojokyoBuilder {

    private final IShinsakaiShukeiGenzainojokyoEditor editor;
    private final IShinsakaiShukeiGenzainojokyoHeadEditor headEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IShinsakaiShukeiGenzainojokyoHeadEditor}
     * @param editor {@link IShinsakaiShukeiGenzainojokyoEditor}
     */
    public ShinsakaiShukeiGenzainojokyoBuilder(IShinsakaiShukeiGenzainojokyoHeadEditor headEditor,
            IShinsakaiShukeiGenzainojokyoEditor editor) {
        this.headEditor = headEditor;
        this.editor = editor;

    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaiShukeiGenzainojokyoReportSource}
     */
    @Override
    public ShinsakaiShukeiGenzainojokyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaiShukeiGenzainojokyoReportSource()).join(headEditor).join(editor).buildSource();
    }
}
