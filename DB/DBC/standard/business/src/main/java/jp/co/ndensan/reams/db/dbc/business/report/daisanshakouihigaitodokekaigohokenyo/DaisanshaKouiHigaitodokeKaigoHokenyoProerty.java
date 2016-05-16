/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link DaisanshaKouiHigaitodokeKaigoHokenyoProerty}のプロパティです。
 *
 * @reamsid_L DBA-0540-699 suguangjun
 */
public class DaisanshaKouiHigaitodokeKaigoHokenyoProerty extends ReportPropertyBase<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> {

    /**
     * コンストラクタです。
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC800020.getReportId());
    }
}
