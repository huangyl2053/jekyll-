/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class HihokenshashoHakkoIchiranHyoProerty extends ReportPropertyBase<HihokenshashoHakkoIchiranhyoReportSource> {
    
        private static final ReportId ID = ReportIdDBA.DBA200003.getReportId();
    
    /**
     * コンストラクタです。
     */
    public HihokenshashoHakkoIchiranHyoProerty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
    // TODO Redmine：#73393 (出力順について)
}
