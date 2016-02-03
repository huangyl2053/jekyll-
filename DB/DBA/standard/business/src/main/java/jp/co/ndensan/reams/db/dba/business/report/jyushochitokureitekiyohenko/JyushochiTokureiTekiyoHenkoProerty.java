/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class JyushochiTokureiTekiyoHenkoProerty extends ReportPropertyBase<JyushochiTokureiTekiyoHenkoReportSource> {
    
    
    /**
     * コンストラクタです。
     */
    public JyushochiTokureiTekiyoHenkoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA800002.getReportId());
    }
}
