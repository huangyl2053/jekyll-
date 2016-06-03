package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 仮算定額変更【A4縦タイプ】のプロパティです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenkoTsuchishoA4TateProperty extends ReportPropertyBase<KarisanteiHenkoTsuchishoA4TateReportSource> {

    /**
     * コンストラクタです。
     */
    public KarisanteiHenkoTsuchishoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100011.getReportId());
    }

}
