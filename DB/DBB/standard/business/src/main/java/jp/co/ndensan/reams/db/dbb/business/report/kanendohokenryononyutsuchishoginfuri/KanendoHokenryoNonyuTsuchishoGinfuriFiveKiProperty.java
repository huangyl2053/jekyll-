/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期のプロパティです。
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty
        extends ReportPropertyBase<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> {

    /**
     * コンストラクタです。
     *
     */
    public KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100070.getReportId());
    }

}
