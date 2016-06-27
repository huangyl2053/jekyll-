/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定申請モニタリストBuilderクラスです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorBuilder implements IShinseiMonitorBuilder {

    private final IShinseiMonitorEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinseiMonitorEditor}
     */
    public ShinseiMonitorBuilder(IShinseiMonitorEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinseiMonitorReportSource}
     */
    @Override
    public ShinseiMonitorReportSource build() {
        return ReportEditorJoiner.from(new ShinseiMonitorReportSource()).join(editor).buildSource();
    }
}
