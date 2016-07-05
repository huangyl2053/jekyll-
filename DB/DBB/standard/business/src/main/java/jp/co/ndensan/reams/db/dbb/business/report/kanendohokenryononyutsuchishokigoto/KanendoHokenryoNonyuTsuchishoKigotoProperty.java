/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishokigoto.KanendoHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP00007_14_保険料納入通知書（本算定過年度）【期毎タイプ】のプロパティです。
 *
 * @reamsid_L DBB-9110-140 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoKigotoProperty extends ReportPropertyBase<KanendoHokenryoNonyuTsuchishoKigotoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KanendoHokenryoNonyuTsuchishoKigotoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100066.getReportId());
    }

}
