/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN63003_高額合算支給決定通知書（単）Reportクラスです。
 *
 * @reamsid_L DBC-2310-035 chenyadong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiReport extends
        Report<GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> {

    private final KogakuGassanShikyuKetteiTsuchishoEntity entity;
    private final NinshoshaSource ninshoshaSource;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用キー;

    /**
     * インスタンスを生成します。
     *
     * @param entity KogakuGassanShikyuKetteiTsuchishoEntity
     * @param ninshoshaSource NinshoshaSource
     * @param 帳票制御汎用キー List<ChohyoSeigyoHanyo>
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiReport(KogakuGassanShikyuKetteiTsuchishoEntity entity,
            NinshoshaSource ninshoshaSource, List<ChohyoSeigyoHanyo> 帳票制御汎用キー) {
        this.entity = entity;
        this.ninshoshaSource = ninshoshaSource;
        this.帳票制御汎用キー = 帳票制御汎用キー;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> writer) {

        IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor editor
                = new GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiEditor(entity, ninshoshaSource, 帳票制御汎用キー);
        IGassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder builder
                = new GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiBuilder(editor);
        writer.writeLine(builder);

    }

}
