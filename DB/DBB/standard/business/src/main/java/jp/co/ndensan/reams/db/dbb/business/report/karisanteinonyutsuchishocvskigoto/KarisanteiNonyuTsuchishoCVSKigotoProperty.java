/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP00007_7_保険料納入通知書（仮算定）【コンビニ期毎タイプ】のプロパティです。
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSKigotoProperty extends ReportPropertyBase<KarisanteiNonyuTsuchishoCVSKigotoSource> {

    /**
     * コンストラクタです。
     *
     */
    public KarisanteiNonyuTsuchishoCVSKigotoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100028.getReportId());
    }

}
