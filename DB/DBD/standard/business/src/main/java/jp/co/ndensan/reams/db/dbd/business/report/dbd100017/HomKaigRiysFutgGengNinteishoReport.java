/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100017.HomKaigRiysFutgGengNinteishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訪問介護等利用者負担額減額認定証のReportです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public final class HomKaigRiysFutgGengNinteishoReport extends Report<HomKaigRiysFutgGengNinteishoReportSource> {

    private final HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額;
    private final IKojin iKojin;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RDate 交付日;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 訪問介護利用者負担額減額 訪問介護利用者負担額減額
     * @param iKojin iKojin
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 交付日 交付日
     * @param ninshoshaSource NinshoshaSource
     * @return 訪問介護等利用者負担額減額認定証
     */
    public static HomKaigRiysFutgGengNinteishoReport createReport(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            NinshoshaSource ninshoshaSource) {
        return new HomKaigRiysFutgGengNinteishoReport(訪問介護利用者負担額減額, iKojin,
                帳票制御共通, 帳票制御汎用List, 地方公共団体, 交付日, ninshoshaSource);
    }

    private HomKaigRiysFutgGengNinteishoReport(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            NinshoshaSource ninshoshaSource) {
        this.訪問介護利用者負担額減額 = 訪問介護利用者負担額減額;
        this.iKojin = iKojin;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.交付日 = 交付日;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<HomKaigRiysFutgGengNinteishoReportSource> writer) {
        IHomKaigRiysFutgGengNinteishoEditor bodyEditor = new HomKaigRiysFutgGengNinteishoBodyEditor(訪問介護利用者負担額減額, iKojin, 帳票制御共通,
                帳票制御汎用List, 地方公共団体, 交付日, ninshoshaSource);
        IHomKaigRiysFutgGengNinteishoBuider builder = new HomKaigRiysFutgGengNinteishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
