/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書 Property
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty extends ReportPropertyBase<JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource> {

    /**
     * インスタンスを生成します。
     */
    public JyuryoItakuAtukaiJigyoshaTorokuTsuchishoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100032.getReportId());
    }
}
