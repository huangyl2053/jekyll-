/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinhoshushiharai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai.IinhoshushiharaiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査会委員報酬支払通知書のプロパティです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
public class IinhoshushiharaiProperty extends ReportPropertyBase<IinhoshushiharaiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public IinhoshushiharaiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE621001.getReportId());
    }
}
