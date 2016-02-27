/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link ShikakushashoReportSource}のプロパティです。
 */
public class ShikakushashoProerty extends ReportPropertyBase<ShikakushashoReportSource> {
    
    /**
     * コンストラクタです。
     */
    public ShikakushashoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100003.getReportId());
    }
}
