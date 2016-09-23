/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100030;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書確認書Builderクラスです。
 * 
 * @reamsid_L DBD-5790-030 x_zhaowen
 */
public class ShujiiIkenshoKakuninshoBuilder implements IShugiiIkenshoKakuninshoBuilder {
    
    private final IShugiiIkenshoKakuninshoEditor editor;

    /**
     * インスタンスを生成します。
     * 
     * @param editor IShugiiIkenshoKakuninshoEditor
     */
    ShujiiIkenshoKakuninshoBuilder(IShugiiIkenshoKakuninshoEditor editor) {
        this.editor = editor;
    }
    
    @Override
    public ShujiiIkenshoKakuninshoReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoKakuninshoReportSource()).join(editor).buildSource();
    }
    
}
