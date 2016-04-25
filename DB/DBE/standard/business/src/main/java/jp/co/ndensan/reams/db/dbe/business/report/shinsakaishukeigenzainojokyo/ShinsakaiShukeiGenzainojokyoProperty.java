/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査会集計表（現在の状況別）のプロパティです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoProperty extends ReportPropertyBase<ShinsakaiShukeiGenzainojokyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiShukeiGenzainojokyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE701009.getReportId());
    }
}
