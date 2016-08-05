/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定取消通知書のReportです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTshuchishoReport extends Report<YokaigoNinteiTorikeshiTshuchishoSource> {

    private final IAtesaki 宛先;
    private final Association 地方公共団体;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final RString bunshoNo;
    private final RString hihokenshaNo;
    private final RString riyu;

    /**
     * インスタンスを生成します。
     *
     * @param 宛先 IAtesaki
     * @param 地方公共団体 Association
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 通知書定型文リスト List<RString>
     * @param 認証者ソースビルダー NinshoshaSource
     * @param bunshoNo RString
     * @param hihokenshaNo RString
     * @param riyu RString
     */
    public YokaigoNinteiTorikeshiTshuchishoReport(IAtesaki 宛先, Association 地方公共団体, ChohyoSeigyoKyotsu 帳票制御共通, List<RString> 通知書定型文リスト,
            NinshoshaSource 認証者ソースビルダー, RString bunshoNo, RString hihokenshaNo, RString riyu) {
        this.宛先 = 宛先;
        this.地方公共団体 = 地方公共団体;
        this.帳票制御共通 = 帳票制御共通;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.bunshoNo = bunshoNo;
        this.hihokenshaNo = hihokenshaNo;
        this.riyu = riyu;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter<YokaigoNinteiTorikeshiTshuchishoSource>
     */
    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiTorikeshiTshuchishoSource> writer) {
        IYokaigoNinteiTorikeshiTshuchishoEditor bodyEditor = new YokaigoNinteiTorikeshiTshuchishoEditor(宛先, 地方公共団体,
                帳票制御共通, 通知書定型文リスト, 認証者ソースビルダー, bunshoNo, hihokenshaNo, riyu);
        IYokaigoNinteiTorikeshiTshuchishoBuilder buider = new YokaigoNinteiTorikeshiTshuchishoBuilder(bodyEditor);
        writer.writeLine(buider);
    }
}
