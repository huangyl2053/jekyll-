/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100013;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
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
 * 負担限度額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public final class FutanGendogakuKetteiTsuchishoReport extends Report<FutanGendogakuKetteiTsuchishoReportSource> {

    private final FutanGendogakuNintei 負担限度額認定;
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
     * @param 負担限度額認定 負担限度額認定
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 文書番号 文書番号
     * @param 通知書定型文List 通知書定型文List
     * @param ninshoshaSource NinshoshaSource
     * @return 負担限度額決定通知書
     */
    public static FutanGendogakuKetteiTsuchishoReport createReport(FutanGendogakuNintei 負担限度額認定, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RString 文書番号,
            List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        return new FutanGendogakuKetteiTsuchishoReport(負担限度額認定,
                iKojin,
                iAtesaki,
                帳票制御共通,
                帳票制御汎用List,
                地方公共団体,
                文書番号,
                通知書定型文List,
                ninshoshaSource);
    }

    private FutanGendogakuKetteiTsuchishoReport(FutanGendogakuNintei 負担限度額認定, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RString 文書番号, List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        this.負担限度額認定 = 負担限度額認定;
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
    public void writeBy(ReportSourceWriter<FutanGendogakuKetteiTsuchishoReportSource> writer) {
        IFutanGendogakuKetteiTsuchishoEditor bodyEditor = new FutanGendogakuKetteiTsuchishoBodyEditor(負担限度額認定,
                iKojin,
                iAtesaki,
                帳票制御共通,
                帳票制御汎用List,
                地方公共団体,
                文書番号,
                通知書定型文List,
                ninshoshaSource);
        IFutanGendogakuKetteiTsuchishoBuider builder = new FutanGendogakuKetteiTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
