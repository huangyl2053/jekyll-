/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 他市町村住所地特例者台帳のプロパティです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
public class TashichosonJushochitokureishaDaichoProperty extends ReportPropertyBase<TashichosonJushochitokureishaDaichoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public TashichosonJushochitokureishaDaichoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100011.getReportId());
    }
}
