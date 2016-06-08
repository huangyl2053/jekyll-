/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】連帳のプロパティです。
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty
        extends ReportPropertyBase<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100019.getReportId());
    }

}
