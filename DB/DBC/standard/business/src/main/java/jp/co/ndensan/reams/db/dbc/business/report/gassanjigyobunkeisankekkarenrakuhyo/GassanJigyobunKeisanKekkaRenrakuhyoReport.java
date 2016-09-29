/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
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
    private final JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity dataEntity;
    private final NinshoshaSource 認証者;
    private final Association 地方公共団体;
    private final IShikibetsuTaisho 宛名データ;
    private final ToiawasesakiSource 問い合わせ先;
    private final boolean flag;
    private final boolean isBreak;

    /**
     * コンストラクタです
     *
     * @param 通知書定型文1 RString
     * @param 通知書定型文2 RString
     * @param dataEntity JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity
     * @param 認証者 NinshoshaSource
     * @param 地方公共団体 Association
     * @param 宛名データ IShikibetsuTaisho
     * @param 問い合わせ先 IToiawasesakiSourceBuilder
     * @param flag boolean
     * @param isBreak boolean
     */
    public GassanJigyobunKeisanKekkaRenrakuhyoReport(RString 通知書定型文1, RString 通知書定型文2,
            JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity dataEntity, NinshoshaSource 認証者,
            Association 地方公共団体,
            IShikibetsuTaisho 宛名データ, ToiawasesakiSource 問い合わせ先,
            boolean flag,
            boolean isBreak) {
        this.通知書定型文1 = 通知書定型文1;
        this.通知書定型文2 = 通知書定型文2;
        this.dataEntity = dataEntity;
        this.認証者 = 認証者;
        this.地方公共団体 = 地方公共団体;
        this.宛名データ = 宛名データ;
        this.問い合わせ先 = 問い合わせ先;
        this.flag = flag;
        this.isBreak = isBreak;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJigyobunKeisanKekkaRenrakuhyoSource> writer) {

        IGassanJigyobunKeisanKekkaRenrakuhyoEditor editor
                = new GassanJigyobunKeisanKekkaRenrakuhyoEditor(通知書定型文1, 通知書定型文2,
                        dataEntity, 認証者,
                        地方公共団体, 宛名データ, 問い合わせ先, flag, isBreak);

        IGassanJigyobunKeisanKekkaRenrakuhyoBuilder builder = new GassanJigyobunKeisanKekkaRenrakuhyoBuilder(editor);

        writer.writeLine(builder);

    }

}
