/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会スケジュール表（年間）Builderのクラスです。
 *
 * @reamsid_L DBE-0130-081 duanzhanli
 */
public class ShinsaschedulehyoBuilder implements IShinsaschedulehyoBuilder {

    private final IShinsaschedulehyoEditor editor;
    private final IShinsaschedulehyoHeadEditor headEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsaschedulehyoEditor}
     * @param headEditor {@link IShinsaschedulehyoHeadEditor}
     */
    public ShinsaschedulehyoBuilder(IShinsaschedulehyoHeadEditor headEditor, IShinsaschedulehyoEditor editor) {
        this.headEditor = headEditor;
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaschedulehyoReportSource}
     */
    @Override
    public ShinsaschedulehyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsaschedulehyoReportSource()).join(headEditor).join(editor).buildSource();
    }

}
