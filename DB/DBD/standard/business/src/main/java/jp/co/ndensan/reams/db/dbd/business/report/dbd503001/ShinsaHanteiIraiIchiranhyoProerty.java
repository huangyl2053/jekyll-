/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd503001;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShinsaHanteiIraiIchiranhyoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
public class ShinsaHanteiIraiIchiranhyoProerty extends ReportPropertyBase<ShinsaHanteiIraiIchiranhyoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShinsaHanteiIraiIchiranhyoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD503001.getReportId());
    }

}
