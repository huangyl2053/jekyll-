/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class ShikakushutokuIdoSoshitsuProerty extends ReportPropertyBase<ShikakushutokuIdoSoshitsuReportSource> {
    
    private static final ReportId ID = ReportIdDBA.DBA800001.getReportId();
    
    /**
     * コンストラクタです。
     */
    public ShikakushutokuIdoSoshitsuProerty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}
