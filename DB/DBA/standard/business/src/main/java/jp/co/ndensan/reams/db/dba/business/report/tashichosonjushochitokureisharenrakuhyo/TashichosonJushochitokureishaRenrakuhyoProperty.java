/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険他市町村住所地特例者連絡票ののプロパティです。
 *
 * @reamsid_L DBA-0380-080 duanzhanli
 *
 */
public class TashichosonJushochitokureishaRenrakuhyoProperty extends ReportPropertyBase<TashichosonJushochitokureishaRenrakuhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public TashichosonJushochitokureishaRenrakuhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100007.getReportId());
    }
}
