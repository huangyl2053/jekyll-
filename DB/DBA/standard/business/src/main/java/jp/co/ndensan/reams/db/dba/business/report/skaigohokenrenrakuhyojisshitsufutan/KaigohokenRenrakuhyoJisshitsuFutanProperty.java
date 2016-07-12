/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.skaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.skaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource;
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
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100013.getReportId());
    }
}
