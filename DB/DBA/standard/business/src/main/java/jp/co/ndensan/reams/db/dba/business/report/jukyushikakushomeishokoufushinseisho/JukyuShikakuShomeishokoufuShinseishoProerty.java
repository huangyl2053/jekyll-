/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class JukyuShikakuShomeishokoufuShinseishoProerty extends ReportPropertyBase<ShikakushutokuIdoSoshitsuReportSource> {
    
    
    /**
     * コンストラクタです。
     */
    public JukyuShikakuShomeishokoufuShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800011.getReportId());
    }
}
