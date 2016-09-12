/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険連絡票_実質負担軽減者用のプロパティです。
 *
 * @reamsid_L DBA-1290-060 wangrenze
 */
public class KaigohokenRenrakuhyoJisshitsuFutanProperty extends ReportPropertyBase<KaigohokenRenrakuhyoJisshitsuFutanReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KaigohokenRenrakuhyoJisshitsuFutanProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU100003.getReportId());
    }
}
