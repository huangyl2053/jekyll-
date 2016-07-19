/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 支払方法変更予告通知書のReportです。
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public final class ShiharaiHohoHenkoYokokuTsuchishoReport extends Report<ShiharaiHohoHenkoYokokuTsuchishoReportSource> {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final FlexibleDate 発行日;
    private final RString 文書番号;
    private final List<RString> 通知書定型文リスト;
    private final RString 帳票分類ID;
    private final Ninshosha 認証者;
    private final ShiharaiHohoHenko 帳票情報;

    /**
     * インスタンスを生成します。
     *
     * @param 個人情報 個人情報
     * @param 宛先 宛先
     * @param 帳票制御汎用リスト 帳票制御汎用リスト
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 通知書定型文リスト 通知書定型文リスト
     * @param 帳票分類ID 帳票分類ID
     * @param 認証者 認証者
     * @param 帳票情報 帳票情報
     * @return 支払方法変更予告通知書
     */
    public static ShiharaiHohoHenkoYokokuTsuchishoReport createReport(IKojin 個人情報, IAtesaki 宛先,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体,
            FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文リスト,
            RString 帳票分類ID, Ninshosha 認証者, ShiharaiHohoHenko 帳票情報
    ) {
        return new ShiharaiHohoHenkoYokokuTsuchishoReport(個人情報, 宛先, 帳票制御汎用リスト, 帳票制御共通, 地方公共団体,
                発行日, 文書番号, 通知書定型文リスト, 帳票分類ID, 認証者, 帳票情報);
    }

    private ShiharaiHohoHenkoYokokuTsuchishoReport(IKojin 個人情報, IAtesaki 宛先,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体,
            FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文リスト,
            RString 帳票分類ID, Ninshosha 認証者, ShiharaiHohoHenko 帳票情報) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御汎用リスト = 帳票制御汎用リスト;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.発行日 = 発行日;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.帳票分類ID = 帳票分類ID;
        this.認証者 = 認証者;
        this.帳票情報 = 帳票情報;

    }

    @Override
    public void writeBy(ReportSourceWriter<ShiharaiHohoHenkoYokokuTsuchishoReportSource> writer) {

//        IShiharaiHohoHenkoYokokuTsuchishoEditor bodyEditor
//                = new ShiharaiHohoHenkoYokokuTsuchishoEditor(個人情報, 宛先, 帳票制御汎用リスト, 帳票制御共通, 地方公共団体,
//                        発行日, 文書番号, 通知書定型文リスト, 帳票分類ID, 認証者, 帳票情報, writer.getImageFolderPath());
//        IShiharaiHohoHenkoYokokuTsuchishoBuilder builder = new ShiharaiHohoHenkoYokokuTsuchishoBuilder(bodyEditor);
//        writer.writeLine(builder);
    }
}
