/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訪問介護等利用者負担額減額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public final class HomKaigRiysFutgGengKettTsuchishoReport extends Report<HomKaigRiysFutgGengKettTsuchishoReportSource> {

    private final HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額;
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
     * @param 訪問介護利用者負担額減額 訪問介護利用者負担額減額
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param 文書番号 文書番号
     * @param 通知書定型文List List<RString>
     * @param ninshoshaSource NinshoshaSource
     * @return 訪問介護等利用者負担額減額決定通知書
     */
    public static HomKaigRiysFutgGengKettTsuchishoReport createReport(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額, IKojin iKojin,
            IAtesaki iAtesaki, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文List,
            NinshoshaSource ninshoshaSource) {
        return new HomKaigRiysFutgGengKettTsuchishoReport(訪問介護利用者負担額減額, iKojin, iAtesaki, 帳票制御共通, 地方公共団体, 文書番号,
                通知書定型文List, ninshoshaSource);
    }

    private HomKaigRiysFutgGengKettTsuchishoReport(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額, IKojin iKojin,
            IAtesaki iAtesaki, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文List,
            NinshoshaSource ninshoshaSource) {
        this.訪問介護利用者負担額減額 = 訪問介護利用者負担額減額;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomKaigRiysFutgGengKettTsuchishoReportSource> writer) {
        IHomKaigRiysFutgGengKettTsuchishoEditor bodyEditor = new HomKaigRiysFutgGengKettTsuchishoBodyEditor(訪問介護利用者負担額減額, iKojin,
                iAtesaki, 帳票制御共通, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
        IHomKaigRiysFutgGengKettTsuchishoBuider builder = new HomKaigRiysFutgGengKettTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
