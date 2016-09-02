/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijiari.JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 新総合事業・事業高額決定通知書（単）(支払予定日あり)帳票のReport
 *
 * @reamsid_L DBC-4760-040 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiAriReport extends Report<JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource> {

    private final JigyouKetteiTutisyoResult entity;
    private final ChohyoSeigyoKyotsu kyotsu;
    private final NinshoshaSource 認証者情報;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param entity 決定通知書Entity
     * @param 認証者情報 NinshoshaSource
     * @param kyotsu 帳票制御共通
     * @return 新総合事業・事業高額決定通知書（単）帳票のReport
     */
    public static JigyoKogakuKetteiTsuchishoYoteiBiYijiAriReport createFrom(
            JigyouKetteiTutisyoResult entity, NinshoshaSource 認証者情報, ChohyoSeigyoKyotsu kyotsu) {
        return new JigyoKogakuKetteiTsuchishoYoteiBiYijiAriReport(entity, 認証者情報, kyotsu);
    }

    /**
     * インスタンスを生成するメソッド。
     *
     * @param entity 決定通知書Entity
     * @param 認証者情報 NinshoshaSource
     * @param kyotsu 帳票制御共通
     */
    protected JigyoKogakuKetteiTsuchishoYoteiBiYijiAriReport(
            JigyouKetteiTutisyoResult entity, NinshoshaSource 認証者情報, ChohyoSeigyoKyotsu kyotsu) {
        this.entity = entity;
        this.kyotsu = kyotsu;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoKogakuKetteiTsuchishoYoteiBiYijiAriSource> reportSourceWriter) {
        IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor editor = new JigyoKogakuKetteiTsuchishoYoteiBiYijiAriEditor(
                entity, 認証者情報, kyotsu);
        IJigyoKogakuKetteiTsuchishoYoteiBiYijiAriBuilder builder = new JigyoKogakuKetteiTsuchishoYoteiBiYijiAriBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
