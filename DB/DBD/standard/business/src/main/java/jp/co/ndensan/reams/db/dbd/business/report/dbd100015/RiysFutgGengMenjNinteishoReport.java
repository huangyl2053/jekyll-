/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 利用者負担額減額・免除等認定証のReportです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public final class RiysFutgGengMenjNinteishoReport extends Report<RiysFutgGengMenjNinteishoReportSource> {

    private final RiyoshaFutangakuGengaku 利用者負担額減額情報;
    private final IKojin iKojin;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RDate 交付日;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 利用者負担額減額情報 利用者負担額減額情報
     * @param iKojin iKojin
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 交付日 交付日
     * @param ninshoshaSource NinshoshaSource
     * @return 利用者負担額減額・免除等認定証
     */
    public static RiysFutgGengMenjNinteishoReport createReport(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RDate 交付日, NinshoshaSource ninshoshaSource) {
        return new RiysFutgGengMenjNinteishoReport(利用者負担額減額情報, iKojin, 帳票制御共通, 帳票制御汎用List, 地方公共団体,
                交付日, ninshoshaSource);
    }

    private RiysFutgGengMenjNinteishoReport(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RDate 交付日, NinshoshaSource ninshoshaSource) {
        this.利用者負担額減額情報 = 利用者負担額減額情報;
        this.iKojin = iKojin;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.交付日 = 交付日;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiysFutgGengMenjNinteishoReportSource> writer) {
        IRiysFutgGengMenjNinteishoEditor bodyEditor = new RiysFutgGengMenjNinteishoBodyEditor(利用者負担額減額情報, iKojin, 帳票制御共通,
                帳票制御汎用List, 地方公共団体, 交付日, ninshoshaSource);
        IRiysFutgGengMenjNinteishoBuider builder = new RiysFutgGengMenjNinteishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
