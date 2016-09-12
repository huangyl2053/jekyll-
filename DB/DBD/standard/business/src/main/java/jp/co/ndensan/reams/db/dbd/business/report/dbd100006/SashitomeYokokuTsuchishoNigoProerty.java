/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100006;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100006.SashitomeYokokuTsuchishoNigoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link SashitomeYokokuTsuchishoNigoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-070 b_liuyang2
 */
public class SashitomeYokokuTsuchishoNigoProerty extends ReportPropertyBase<SashitomeYokokuTsuchishoNigoReportSource> {

    /**
     * コンストラクタです。
     */
    public SashitomeYokokuTsuchishoNigoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100006.getReportId());
    }
}
