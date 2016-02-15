/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書督促対象者一覧表のプロパティです。
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoProperty extends ReportPropertyBase<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE223002.getReportId());
    }

}
