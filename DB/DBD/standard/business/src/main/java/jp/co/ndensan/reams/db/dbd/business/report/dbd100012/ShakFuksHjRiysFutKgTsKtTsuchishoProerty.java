/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100012;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100012.ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-110 wangchao
 */
public class ShakFuksHjRiysFutKgTsKtTsuchishoProerty extends ReportPropertyBase<ShakFuksHojRiysFutKeigTsKetTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShakFuksHjRiysFutKgTsKtTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100012.getReportId());
    }
}
