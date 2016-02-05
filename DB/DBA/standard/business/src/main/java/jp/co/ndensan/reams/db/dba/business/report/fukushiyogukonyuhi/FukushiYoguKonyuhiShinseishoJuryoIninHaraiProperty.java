/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.fukushiyogukonyuhi;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.fukushiyogukonyuhi.FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のプロパティです。
 */
public class FukushiYoguKonyuhiShinseishoJuryoIninHaraiProperty
        extends ReportPropertyBase<FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource> {

    private static final ReportId ID = ReportIdDBA.DBC800013.getReportId();

    /**
     * インスタンスを生成します。
     */
    public FukushiYoguKonyuhiShinseishoJuryoIninHaraiProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}
