/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokankihonjiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100004.TainoHokenryoKojoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 滞納保険料控除通知書のReportです。
 *
 * @reamsid_L DBD-3640-050 b_liuyang2
 */
public final class TainoHokenryoKojoTsuchishoReport extends Report<TainoHokenryoKojoTsuchishoReportSource> {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final ShiharaiHohoHenko 帳票情報;
    private final List<ShokanKihonJihoEntiy> 償還払集計情報リスト;

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
     * @param 償還払集計情報リスト List<ShokanKihonJihoEntiy>
     * @return 滞納保険料控除通知書
     */
    public static TainoHokenryoKojoTsuchishoReport createReport(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー,
            ShiharaiHohoHenko 帳票情報, List<ShokanKihonJihoEntiy> 償還払集計情報リスト) {
        return new TainoHokenryoKojoTsuchishoReport(個人情報, 宛先, 帳票制御共通, 地方公共団体,
                文書番号, 通知書定型文リスト, 認証者ソースビルダー, 帳票情報, 償還払集計情報リスト);
    }

    private TainoHokenryoKojoTsuchishoReport(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー,
            ShiharaiHohoHenko 帳票情報, List<ShokanKihonJihoEntiy> 償還払集計情報リスト) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.帳票情報 = 帳票情報;
        this.償還払集計情報リスト = 償還払集計情報リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<TainoHokenryoKojoTsuchishoReportSource> writer) {

        for (int index = 0; index < 償還払集計情報リスト.size() || index < this.帳票情報.getShiharaiHohoHenkoTainoList().size(); index++) {
            ITainoHokenryoKojoTsuchishoEditor bodyEditor = new TainoHokenryoKojoTsuchishoEditor(個人情報, 宛先, 帳票制御共通,
                    地方公共団体, 文書番号, 通知書定型文リスト, 認証者ソースビルダー, 帳票情報, 償還払集計情報リスト, index);
            ITainoHokenryoKojoTsuchishoBuilder builder = new TainoHokenryoKojoTsuchishoBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }

}
