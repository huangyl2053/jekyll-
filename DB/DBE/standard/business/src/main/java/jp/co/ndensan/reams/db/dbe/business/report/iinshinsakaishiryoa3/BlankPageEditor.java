/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.IinShinsakaiShiryoA3Layouts;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;

/**
 *
 * @author n3423
 */
public class BlankPageEditor implements IIinShinsakaishiryoA3Editor {
    
    /**
     * インスタンスを生成します。
     *
     */
    protected BlankPageEditor() {
    }

    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private IinShinsakaishiryoA3ReportSource editSource(IinShinsakaishiryoA3ReportSource source) {
        source.layout = IinShinsakaiShiryoA3Layouts.余白ページ.index();
        return source;
    }
}
