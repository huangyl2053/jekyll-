/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100002.ShiharaiHohoHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 支払方法変更通知書のReportです。
 *
 * @reamsid_L DBD-3640-090 b_liuyang2
 */
public final class ShiharaiHohoHenkoTsuchishoReport extends Report<ShiharaiHohoHenkoTsuchishoReportSource> {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final ShiharaiHohoHenko 帳票情報;
    private final List<ShiharaiHohoHenkoTaino> 年度1リスト = new ArrayList<>();
    private final List<ShiharaiHohoHenkoTaino> 年度2リスト = new ArrayList<>();
    private final List<ShiharaiHohoHenkoTaino> 年度3リスト = new ArrayList<>();

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
     *
     * @return 支払方法変更通知書
     */
    public static ShiharaiHohoHenkoTsuchishoReport createReport(IKojin 個人情報, IAtesaki 宛先,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, RString 文書番号,
            List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー, ShiharaiHohoHenko 帳票情報) {
        return new ShiharaiHohoHenkoTsuchishoReport(個人情報, 宛先, 帳票制御共通, 地方公共団体, 文書番号,
                通知書定型文リスト, 認証者ソースビルダー, 帳票情報);
    }

    private ShiharaiHohoHenkoTsuchishoReport(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文リスト,
            NinshoshaSource 認証者ソースビルダー, ShiharaiHohoHenko 帳票情報) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.帳票情報 = 帳票情報;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShiharaiHohoHenkoTsuchishoReportSource> writer) {
        FlexibleYear 最新賦課年度 = get最新賦課年度();
        get年度リスト(最新賦課年度);
        for (int index = 0; index < 年度1リスト.size() || index < 年度2リスト.size() || index < 年度3リスト.size(); index++) {
            IShiharaiHohoHenkoTsuchishoEditor bodyEditor = new ShiharaiHohoHenkoTsuchishoEditor(個人情報, 宛先,
                    帳票制御共通, 地方公共団体, 文書番号, 通知書定型文リスト, 認証者ソースビルダー, 帳票情報,
                    最新賦課年度, 年度1リスト, 年度2リスト, 年度3リスト, index);
            IShiharaiHohoHenkoTsuchishoBuilder builder = new ShiharaiHohoHenkoTsuchishoBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }

    private FlexibleYear get最新賦課年度() {
        FlexibleYear year = FlexibleYear.EMPTY;
        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : 帳票情報.getShiharaiHohoHenkoTainoList()) {
            if (year.isEmpty() || year.compareTo(支払方法変更滞納.get賦課年度()) < 0) {
                year = 支払方法変更滞納.get賦課年度();
            }
        }
        return year;
    }

    private void get年度リスト(FlexibleYear 最新賦課年度) {
        if (最新賦課年度.isEmpty()) {
            return;
        }

        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : 帳票情報.getShiharaiHohoHenkoTainoList()) {
            if (最新賦課年度.minusYear(2).equals(支払方法変更滞納.get賦課年度())) {
                年度1リスト.add(支払方法変更滞納);
            } else if (最新賦課年度.minusYear(1).equals(支払方法変更滞納.get賦課年度())) {
                年度2リスト.add(支払方法変更滞納);
            } else if (最新賦課年度.equals(支払方法変更滞納.get賦課年度())) {
                年度3リスト.add(支払方法変更滞納);
            }
        }
    }
}
