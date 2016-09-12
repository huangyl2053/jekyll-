/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険特定負担限度額申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-688 houtianpeng
 */
public class TokuteiFutangendogakuShinseishoProperty
        extends ReportPropertyBase<TokuteiFutangendogakuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public TokuteiFutangendogakuShinseishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBA.DBD800004.getReportId());
    }
}
