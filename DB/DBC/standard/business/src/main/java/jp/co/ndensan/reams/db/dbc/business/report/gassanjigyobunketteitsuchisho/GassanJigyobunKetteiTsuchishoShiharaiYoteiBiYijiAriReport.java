/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * （高額合算支給（不支給）決定通知書）支払予定日あり Report
 *
 * @reamsid_L DBC-4850-030 chenyadong
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriReport extends
        Report<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource> {

    private final KogakuGassanShikyuKetteiTsuchisho entity;
    private final NinshoshaSource ninshoshaSource;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用キー;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事業高額合算支給不支給決定Entity
     * @param ninshoshaSource NinshoshaSource
     * @param 帳票制御汎用キー List<ChohyoSeigyoHanyo>
     */
    public GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriReport(KogakuGassanShikyuKetteiTsuchisho entity,
            NinshoshaSource ninshoshaSource, List<ChohyoSeigyoHanyo> 帳票制御汎用キー) {
        this.entity = entity;
        this.ninshoshaSource = ninshoshaSource;
        this.帳票制御汎用キー = 帳票制御汎用キー;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource> writer) {

        IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriEditor editor
                = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriEditor(entity, ninshoshaSource, 帳票制御汎用キー);
        IGassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder builder
                = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder(editor);
        writer.writeLine(builder);

    }

}
