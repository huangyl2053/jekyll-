/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（基本調査）のプロパティです。
 *
 * @reamsid_L DBE-0080-020 zuotao
 */
public class ChosahyoKihonchosaKatamenProperty extends ReportPropertyBase<ChosahyoKihonchosaKatamenReportSource> {

    /**
     * コンストラクタです。
     */
    public ChosahyoKihonchosaKatamenProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE221012.getReportId());
    }
}
