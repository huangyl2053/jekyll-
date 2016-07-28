/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100014;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100014.HomKaigRiysFutGenmKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HomKaigRiysFutGenmKettTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-130 wangchao
 */
public class HomKaigRiysFutGenmKettTsuchishoProerty extends ReportPropertyBase<HomKaigRiysFutGenmKettTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HomKaigRiysFutGenmKettTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100014.getReportId());
    }
}
