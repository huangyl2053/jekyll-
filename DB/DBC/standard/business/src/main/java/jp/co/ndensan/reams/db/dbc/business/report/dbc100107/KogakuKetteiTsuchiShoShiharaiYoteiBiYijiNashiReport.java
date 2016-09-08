/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100107;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス等支給（不支給）決定通知書（単）のReportです。
 *
 * @reamsid_L DBC-5160-050 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport extends Report<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> {

    private final JigyouKetteiTutisyoEntity 決定通知書Entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource 認証者情報;

    /**
     * インスタンスを生成します。
     *
     * @param 決定通知書Entity JigyouKetteiTutisyoEntity
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 認証者情報
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource 認証者情報) {
        this.決定通知書Entity = 決定通知書Entity;
        this.帳票制御共通 = 帳票制御共通;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> writer) {
        IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(決定通知書Entity, 帳票制御共通);
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder builder = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder(editor);
        writer.writeLine(builder);
    }

}
