/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料徴収猶予決定通知書帳票B5横タイプKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty
        extends ReportPropertyBase<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100081.getReportId());
    }
}
