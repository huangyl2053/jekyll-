/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JukyuShikakuShomeishoReportSource}のプロパティです。
 * 
 * @reamsid_L DBU-0490-090  suguangjun 
 */
public class JukyuShikakuShomeishoProerty extends ReportPropertyBase<JukyuShikakuShomeishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyuShikakuShomeishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100004.getReportId());
    }
}
