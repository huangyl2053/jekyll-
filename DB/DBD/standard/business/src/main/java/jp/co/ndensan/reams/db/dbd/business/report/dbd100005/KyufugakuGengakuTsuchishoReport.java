/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100005.KyufugakuGengakuTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付額減額通知書のReportです。
 *
 * @reamsid_L DBD-3640-060 b_liuyang2
 */
public final class KyufugakuGengakuTsuchishoReport extends Report<KyufugakuGengakuTsuchishoReportSource> {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final ShiharaiHohoHenko 帳票情報;

    /**
     * インスタンスを生成します。
     *
     * @param 個人情報 IKojin
     * @param 宛先 IAtesaki
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 文書番号 RString
     * @param 通知書定型文リスト List<RString>
     * @param 認証者ソースビルダー NinshoshaSource
     * @param 帳票情報 ShiharaiHohoHenko
     * @return 給付額減額通知書
     */
    public static KyufugakuGengakuTsuchishoReport createReport(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー,
            ShiharaiHohoHenko 帳票情報) {
        return new KyufugakuGengakuTsuchishoReport(個人情報, 宛先, 帳票制御共通, 地方公共団体, 文書番号, 通知書定型文リスト,
                認証者ソースビルダー, 帳票情報);
    }

    private KyufugakuGengakuTsuchishoReport(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー,
            ShiharaiHohoHenko 帳票情報) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.帳票情報 = 帳票情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufugakuGengakuTsuchishoReportSource> writer) {
        for (int index = 0; index < this.帳票情報.getShiharaiHohoHenkoGengakuList().get(index).getShiharaiHohoHenkoGengakuMeisaiList().size(); index++) {
            IKyufugakuGengakuTsuchishoEditor bodyEditor = new KyufugakuGengakuTsuchishoEditor(個人情報, 宛先, 帳票制御共通,
                    地方公共団体, 文書番号, 通知書定型文リスト, 認証者ソースビルダー, 帳票情報, index);
            IKyufugakuGengakuTsuchishoBuilder builder = new KyufugakuGengakuTsuchishoBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }

}
