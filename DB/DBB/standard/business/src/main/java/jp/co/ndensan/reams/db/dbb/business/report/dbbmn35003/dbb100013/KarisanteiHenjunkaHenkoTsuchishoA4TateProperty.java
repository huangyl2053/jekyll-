package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収平準化【A4縦タイプ】のプロパティです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenjunkaHenkoTsuchishoA4TateProperty extends ReportPropertyBase<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> {

    /**
     * コンストラクタです。
     */
    public KarisanteiHenjunkaHenkoTsuchishoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100013.getReportId());
    }

}
