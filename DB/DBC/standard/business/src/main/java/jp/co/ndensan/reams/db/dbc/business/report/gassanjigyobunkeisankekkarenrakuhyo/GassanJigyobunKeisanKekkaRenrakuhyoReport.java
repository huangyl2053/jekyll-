/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業分計算結果連絡票Propertyクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoReport extends Report<GassanJigyobunKeisanKekkaRenrakuhyoSource> {

    private final RString 通知書定型文1;
    private final RString 通知書定型文2;
    private final JigyobunShikyugakuKeisanResultEntity dataEntity;
    private final NinshoshaSource 認証者;
    private final IShikibetsuTaisho 宛名データ;
    private final RString 通知書定型文3;
    private final boolean flag;
    private final boolean isBreak;
    private final int count;

    /**
     * コンストラクタです
     *
     * @param 通知書定型文1 RString
     * @param 通知書定型文2 RString
     * @param dataEntity JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity
     * @param 認証者 NinshoshaSource
     * @param 宛名データ IShikibetsuTaisho
     * @param 通知書定型文3 RString
     * @param flag boolean
     * @param isBreak boolean
     * @param count int
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoReport(RString 通知書定型文1, RString 通知書定型文2,
            JigyobunShikyugakuKeisanResultEntity dataEntity, NinshoshaSource 認証者,
            IShikibetsuTaisho 宛名データ, RString 通知書定型文3,
            boolean flag,
            boolean isBreak,
            int count
    ) {
        this.通知書定型文1 = 通知書定型文1;
        this.通知書定型文2 = 通知書定型文2;
        this.dataEntity = dataEntity;
        this.認証者 = 認証者;
        this.宛名データ = 宛名データ;
        this.通知書定型文3 = 通知書定型文3;
        this.flag = flag;
        this.isBreak = isBreak;
        this.count = count;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJigyobunKeisanKekkaRenrakuhyoSource> writer) {

        IGassanJigyobunKeisanKekkaRenrakuhyoEditor editor
                = new GassanJigyobunKeisanKekkaRenrakuhyoEditor(通知書定型文1, 通知書定型文2,
                        dataEntity, 認証者,
                        宛名データ, 通知書定型文3, flag, isBreak, count);

        IGassanJigyobunKeisanKekkaRenrakuhyoBuilder builder = new GassanJigyobunKeisanKekkaRenrakuhyoBuilder(editor);

        writer.writeLine(builder);

    }

}
