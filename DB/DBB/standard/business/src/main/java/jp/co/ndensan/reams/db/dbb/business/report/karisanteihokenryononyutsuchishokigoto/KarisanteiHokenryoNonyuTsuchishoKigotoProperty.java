/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】のプロパティです。
 *
 * @reamsid_L DBB-9110-020 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoProperty
        extends ReportPropertyBase<KarisanteiHokenryoNonyuTsuchishoKigotoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KarisanteiHokenryoNonyuTsuchishoKigotoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100014.getReportId());
    }
}
