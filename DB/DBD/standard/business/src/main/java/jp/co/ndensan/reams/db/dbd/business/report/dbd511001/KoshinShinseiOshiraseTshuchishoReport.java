/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseCommonEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定更新お知らせ通知書ReportSourceです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public final class KoshinShinseiOshiraseTshuchishoReport extends Report<KoshinShinseiOshiraseTshuchishoReportSource> {

    private final NinshoshaSource ninshoshaSource;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private final KoshinOshiraseCommonEntity 認定更新お知らせ通知書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaSource NinshoshaSource
     * @param 宛先 IAtesaki
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 帳票制御汎用 List<DbT7067ChohyoSeigyoHanyoEntity>
     * @param 認定更新お知らせ通知書Entity KoshinOshiraseCommonEntity
     */
    public KoshinShinseiOshiraseTshuchishoReport(NinshoshaSource ninshoshaSource, IAtesaki 宛先,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用,
            KoshinOshiraseCommonEntity 認定更新お知らせ通知書Entity) {
        this.ninshoshaSource = ninshoshaSource;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.帳票制御汎用 = 帳票制御汎用;
        this.認定更新お知らせ通知書Entity = 認定更新お知らせ通知書Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<KoshinShinseiOshiraseTshuchishoReportSource> writer) {
        IKoshinShinseiOshiraseTshuchishoEditor editor = new KoshinShinseiOshiraseTshuchishoEditor(
                ninshoshaSource, 宛先, 帳票制御共通, 地方公共団体, 帳票制御汎用, 認定更新お知らせ通知書Entity);
        IKoshinShinseiOshiraseTshuchishoBuilder builder = new KoshinShinseiOshiraseTshuchishoBuilder(editor);
        writer.writeLine(builder);
    }

}
