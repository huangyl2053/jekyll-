/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 障がい者控除対象者認定証のReportです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoReport extends Report<NinteishoJohoReportSource> {

    private final NinteishoJohoEntity target;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param target NinteishoJohoEntity
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param ninshoshaSource 認証者
     * @param 通知書定型文List 通知書定型文List
     * @param 文書番号 文書番号
     * @return 障がい者控除対象者認定書
     */
    public static ShogaishaKojoNinteishoReport createReport(NinteishoJohoEntity target, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文List,
            NinshoshaSource ninshoshaSource) {
        return new ShogaishaKojoNinteishoReport(target, iKojin, iAtesaki,
                帳票制御共通, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
    }

    /**
     * インスタンスを生成します。
     *
     * @param target NinteishoJohoEntity
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param ninshoshaSource 認証者
     * @param 通知書定型文List 通知書定型文List
     * @param 文書番号 文書番号
     */
    public ShogaishaKojoNinteishoReport(NinteishoJohoEntity target, IKojin iKojin, IAtesaki iAtesaki, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        this.target = target;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteishoJohoReportSource> writer) {
        IShogaishaKojoNinteishoEditor editor = new ShogaishaKojoNinteishoEditorImpl(target, iKojin, iAtesaki,
                帳票制御共通, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
        IShogaishaKojoNinteishoBuilder builder = new ShogaishaKojoNinteishoBuilderImpl(editor);
        writer.writeLine(builder);

    }
}
