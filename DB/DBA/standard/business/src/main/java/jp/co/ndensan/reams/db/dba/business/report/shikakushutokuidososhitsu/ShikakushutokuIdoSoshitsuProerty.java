/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 * @reamsid_L DBA-0540-681 dongyabin
 */
public class ShikakushutokuIdoSoshitsuProerty extends ReportPropertyBase<ShikakushutokuIdoSoshitsuReportSource> {
    
    
    /**
     * コンストラクタです。
     */
    public ShikakushutokuIdoSoshitsuProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA800001.getReportId());
    }
}
