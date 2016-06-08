package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 仮算定額変更【B5横タイプ】のプロパティです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenkoTsuchishoB5YokoProperty extends ReportPropertyBase<KarisanteiHenkoTsuchishoB5YokoReportSource> {

    /**
     * コンストラクタです。
     */
    public KarisanteiHenkoTsuchishoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100010.getReportId());
    }

}
