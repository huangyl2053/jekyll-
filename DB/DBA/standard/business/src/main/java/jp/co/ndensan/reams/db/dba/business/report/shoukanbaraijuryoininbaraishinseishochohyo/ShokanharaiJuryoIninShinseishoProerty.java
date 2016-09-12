/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険償還払受領委任払申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-707 xuyannan
 */
public class ShokanharaiJuryoIninShinseishoProerty extends
        ReportPropertyBase<ShokanharaiJuryoIninShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShokanharaiJuryoIninShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800010.getReportId());
    }
}
