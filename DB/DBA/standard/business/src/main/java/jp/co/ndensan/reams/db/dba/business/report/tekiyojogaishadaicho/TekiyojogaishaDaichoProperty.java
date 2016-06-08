/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TekiyojogaishaDaichoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
public class TekiyojogaishaDaichoProperty extends ReportPropertyBase<TekiyojogaishaDaichoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public TekiyojogaishaDaichoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100010.getReportId());
    }
}
