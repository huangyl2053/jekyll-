/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 新総合事業・事業高額決定通知書（単）帳票のReport
 *
 * @reamsid_L DBC-4760-030 yebangqiang
 */
public class JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport extends Report<JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource> {

    private final JigyouKetteiTutisyoResult entity;
    private final ChohyoSeigyoKyotsu kyotsu;
    private final NinshoshaSource 認証者情報;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param entity 決定通知書Entity
     * @param kyotsu 帳票制御共通
     * @param 認証者情報 NinshoshaSource
     * @return 新総合事業・事業高額決定通知書（単）帳票のReport
     */
    public static JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport createFrom(
            JigyouKetteiTutisyoResult entity, ChohyoSeigyoKyotsu kyotsu, NinshoshaSource 認証者情報) {
        return new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport(entity, kyotsu, 認証者情報);
    }

    /**
     * インスタンスを生成するメソッド。
     *
     * @param entity 決定通知書Entity
     * @param kyotsu 帳票制御共通
     * @param 認証者情報 NinshoshaSource
     */
    protected JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiReport(
            JigyouKetteiTutisyoResult entity, ChohyoSeigyoKyotsu kyotsu, NinshoshaSource 認証者情報) {
        this.entity = entity;
        this.kyotsu = kyotsu;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiSource> reportSourceWriter) {
        IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiEditor editor = new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiEditor(
                entity, 認証者情報, kyotsu);
        IJigyoKogakuKetteiTsuchishoYoteiBiYijiNashiBuilder builder = new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
