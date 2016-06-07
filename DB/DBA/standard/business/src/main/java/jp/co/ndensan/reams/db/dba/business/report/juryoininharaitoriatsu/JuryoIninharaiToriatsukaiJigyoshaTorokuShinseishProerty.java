/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 *
 * @reamsid_L DBA-0540-684 dongyabin
 */
public class JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishProerty extends
        ReportPropertyBase<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800001.getReportId());
    }
}
