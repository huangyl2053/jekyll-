/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link KoikinaiTenkyoKekkaIchiranhyoReportSource}のプロパティです。
 *
 * @reamsid_L DBU-1150-070 zhangguopeng
 */
public class KoikinaiTenkyoKekkaIchiranhyoProperty extends ReportPropertyBase<KoikinaiTenkyoKekkaIchiranhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KoikinaiTenkyoKekkaIchiranhyoProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU200004.getReportId());
    }
}
