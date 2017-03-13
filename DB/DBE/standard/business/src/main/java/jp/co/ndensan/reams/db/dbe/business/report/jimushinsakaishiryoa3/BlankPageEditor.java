/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.JimuShinsakaiShiryoA3Layouts;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;

/**
 *
 * @author n3423
 */
public class BlankPageEditor implements IJimuShinsakaishiryoA3Editor {
    
    /**
     * インスタンスを生成します。
     *
     */
    protected BlankPageEditor() {
    }

    @Override
    public JimuShinsakaishiryoA3ReportSource edit(JimuShinsakaishiryoA3ReportSource source) {
        return editSource(source);
    }

    private JimuShinsakaishiryoA3ReportSource editSource(JimuShinsakaishiryoA3ReportSource source) {
        source.layout = JimuShinsakaiShiryoA3Layouts.余白ページ.index();
        return source;
    }
}
