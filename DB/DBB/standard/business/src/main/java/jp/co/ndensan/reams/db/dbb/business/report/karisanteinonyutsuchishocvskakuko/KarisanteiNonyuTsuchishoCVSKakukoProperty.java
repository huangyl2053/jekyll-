/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】プロパティクラスです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoProperty extends ReportPropertyBase<KarisanteiNonyuTsuchishoCVSKakukoSource> {

    private static final ReportId ID = new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMulti");
    private static final List<RString> LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));

    /**
     * インスタンスを生成します。
     */
    public KarisanteiNonyuTsuchishoCVSKakukoProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    @Override
    public Breakers<KarisanteiNonyuTsuchishoCVSKakukoSource> defineBreakers(
            Breakers<KarisanteiNonyuTsuchishoCVSKakukoSource> breakers,
            BreakerCatalog<KarisanteiNonyuTsuchishoCVSKakukoSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(







            LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoSource> occuredBreak(
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoSource> currentRecord,
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord.equals(ReportLineRecord.LAST_RECORD)) {
                    return currentRecord;
                }
                KarisanteiNonyuTsuchishoCVSKakukoSource.Layouts layout = nextRecord.getSource().layout;
                nextRecord.setFormGroupIndex(layout.index());
                return currentRecord;
            }
        }).fixed();
    }
}
