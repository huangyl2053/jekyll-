/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100017.HomKaigRiysFutgGengNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HomKaigRiysFutgGengNinteishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNinteishoProerty extends ReportPropertyBase<HomKaigRiysFutgGengNinteishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HomKaigRiysFutgGengNinteishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100017.getReportId());
    }
}
