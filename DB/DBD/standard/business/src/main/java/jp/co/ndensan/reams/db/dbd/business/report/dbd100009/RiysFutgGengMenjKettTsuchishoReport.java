/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 利用者負担額減額･免除認定決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public final class RiysFutgGengMenjKettTsuchishoReport extends Report<RiysFutgGengMenjKettTsuchishoReportSource> {

    private final RiyoshaFutangakuGengaku 利用者負担額減額情報;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 利用者負担額減額情報 利用者負担額減額情報
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 文書番号 文書番号
     * @param 通知書定型文List 通知書定型文List
     * @param ninshoshaSource NinshoshaSource
     * @return 利用者負担額減額･免除認定決定通知書
     */
    public static RiysFutgGengMenjKettTsuchishoReport createReport(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RString 文書番号,
            List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        return new RiysFutgGengMenjKettTsuchishoReport(利用者負担額減額情報, iKojin, iAtesaki,
                帳票制御共通, 帳票制御汎用List, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
    }

    private RiysFutgGengMenjKettTsuchishoReport(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RString 文書番号, List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        this.利用者負担額減額情報 = 利用者負担額減額情報;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiysFutgGengMenjKettTsuchishoReportSource> writer) {
        IRiysFutgGengMenjKettTsuchishoEditor bodyEditor = new RiysFutgGengMenjKettTsuchishoBodyEditor(利用者負担額減額情報, iKojin, iAtesaki,
                帳票制御共通, 帳票制御汎用List, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
        IRiysFutgGengMenjKettTsuchishoBuider builder = new RiysFutgGengMenjKettTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
