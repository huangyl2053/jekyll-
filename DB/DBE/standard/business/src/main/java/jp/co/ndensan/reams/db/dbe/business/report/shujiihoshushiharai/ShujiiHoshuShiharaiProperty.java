/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshushiharai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshushiharai.ShujiiHoshuShiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBE621002_主治医意見書作成報酬支払通知書のShujiiHoshuShiharaiPropertyです。
 *
 * @reamsid_L DBE-1980-040 xuyongchao
 */
public class ShujiiHoshuShiharaiProperty extends ReportPropertyBase<ShujiiHoshuShiharaiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiHoshuShiharaiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE621002.getReportId());
    }
}
