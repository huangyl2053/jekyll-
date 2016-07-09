/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のChosaHoshuShiharaiPropertyです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
public class ChosaHoshuShiharaiProperty extends ReportPropertyBase<ChosaHoshuShiharaiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosaHoshuShiharaiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE621003.getReportId());
    }

}
