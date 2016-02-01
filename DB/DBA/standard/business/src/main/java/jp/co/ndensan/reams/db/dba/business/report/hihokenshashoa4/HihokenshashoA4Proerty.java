/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoA4ReportSource}のプロパティです。
 */
public class HihokenshashoA4Proerty extends ReportPropertyBase<HihokenshashoA4ReportSource> {
    
    private static final ReportId ID = ReportIdDBA.DBA100002.getReportId();
    
    /**
     * コンストラクタです。
     */
    public HihokenshashoA4Proerty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}
