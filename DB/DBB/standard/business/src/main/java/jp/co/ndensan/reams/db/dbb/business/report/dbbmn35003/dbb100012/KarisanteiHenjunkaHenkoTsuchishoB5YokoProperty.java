package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収平準化【B5横タイプ】のプロパティです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenjunkaHenkoTsuchishoB5YokoProperty extends ReportPropertyBase<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> {

    /**
     * コンストラクタです。
     */
    public KarisanteiHenjunkaHenkoTsuchishoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100012.getReportId());
    }

}
