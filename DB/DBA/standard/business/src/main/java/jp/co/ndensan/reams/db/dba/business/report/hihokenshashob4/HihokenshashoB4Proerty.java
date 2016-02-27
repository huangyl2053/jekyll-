/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class HihokenshashoB4Proerty extends ReportPropertyBase<HihokenshashoB4ReportSource> {
    
    /**
     * コンストラクタです。
     */
    public HihokenshashoB4Proerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100001.getReportId());
    }
}
