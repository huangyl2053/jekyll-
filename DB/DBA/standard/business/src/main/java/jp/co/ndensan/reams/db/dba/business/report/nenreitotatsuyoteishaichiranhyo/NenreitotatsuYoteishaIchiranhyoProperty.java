/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 年齢到達予定者一覧表のプロパティです。
 *
 * @reamsid_L DBA-0580-070 yaodongsheng
 */
public class NenreitotatsuYoteishaIchiranhyoProperty extends ReportPropertyBase<NenreitotatsuYoteishaIchiranhyoReportSource> {

    /**
     * コンストラクタです。
     */
    public NenreitotatsuYoteishaIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200001.getReportId());
    }
}
