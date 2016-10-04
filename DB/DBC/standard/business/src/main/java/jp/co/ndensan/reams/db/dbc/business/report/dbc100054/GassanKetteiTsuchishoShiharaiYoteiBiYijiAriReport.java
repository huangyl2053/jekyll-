/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100054;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchisho;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanketteitsuchishoshiharaiyoteibiyijiari.GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN63004_高額合算支給決定通知書（一括）Report
 *
 * @reamsid_L DBC-2300-050 jiangxiaolong
 */
public class GassanKetteiTsuchishoShiharaiYoteiBiYijiAriReport
        extends Report<GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource> {

    private final KogakugassanShikyuKetteitsuchisho 帳票出力対象データ;
    private final NinshoshaSource ninshoshaSource;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用キー;

    /**
     *
     * @param 帳票出力対象データ KogakugassanShikyuKetteitsuchisho
     * @param ninshoshaSource NinshoshaSource
     * @param 帳票制御汎用キー List<ChohyoSeigyoHanyo>
     */
    public GassanKetteiTsuchishoShiharaiYoteiBiYijiAriReport(
            KogakugassanShikyuKetteitsuchisho 帳票出力対象データ,
            NinshoshaSource ninshoshaSource, List<ChohyoSeigyoHanyo> 帳票制御汎用キー) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.ninshoshaSource = ninshoshaSource;
        this.帳票制御汎用キー = 帳票制御汎用キー;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<GassanKetteiTsuchishoShiharaiYoteiBiYijiAriSource> writer,
            KogakugassanShikyuKetteitsuchisho 帳票出力対象データ) {
        IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriEditor bodyEditor
                = new GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBodyEditor(帳票出力対象データ, ninshoshaSource, 帳票制御汎用キー);
        IGassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder builder
                = new GassanKetteiTsuchishoShiharaiYoteiBiYijiAriBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
