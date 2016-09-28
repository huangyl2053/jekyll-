/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 一次判定データ出力Propertyです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijihanteikekkahyoProperty extends ReportPropertyBase<IchijihanteikekkahyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public IchijihanteikekkahyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517181.getReportId());
    }
}
