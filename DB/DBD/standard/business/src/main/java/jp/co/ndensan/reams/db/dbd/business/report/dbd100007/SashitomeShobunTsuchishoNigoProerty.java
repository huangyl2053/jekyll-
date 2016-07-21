/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100007;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100007.SashitomeShobunTsuchishoNigoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link SashitomeShobunTsuchishoNigoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3640-080 b_liuyang2
 */
public class SashitomeShobunTsuchishoNigoProerty extends ReportPropertyBase<SashitomeShobunTsuchishoNigoReportSource> {

    /**
     * コンストラクタです。
     */
    public SashitomeShobunTsuchishoNigoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100007.getReportId());
    }
}
