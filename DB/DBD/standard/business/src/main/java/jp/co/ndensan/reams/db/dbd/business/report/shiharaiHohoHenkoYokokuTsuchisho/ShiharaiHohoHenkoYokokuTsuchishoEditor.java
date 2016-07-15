/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.shiharaiHohoHenkoYokokuTsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.report.shiharaiHohoHenkoYokokuTsuchisho.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更予告通知書Editorです。
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public class ShiharaiHohoHenkoYokokuTsuchishoEditor implements IShiharaiHohoHenkoYokokuTsuchishoEditor {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final FlexibleDate 発行日;
    private final RString 文書番号;
    private final List<RString> 通知書定型文;
    private final RString 帳票分類ID;
    private final Ninshosha 認証者;
    private final RString 帳票情報;
    private final RString イメージファイルパス;

    /**
     * インスタンスを生成します。
     *
     * @param 個人情報 IKojin
     * @param 宛先 IAtesaki
     * @param 帳票制御汎用リスト List<ChohyoSeigyoHanyo>
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 通知書定型文 List<RString>
     * @param 帳票分類ID RString
     * @param 認証者 Ninshosha
     * @param 帳票情報 RString
     * @param イメージファイルパス RString
     */
    public ShiharaiHohoHenkoYokokuTsuchishoEditor(IKojin 個人情報, IAtesaki 宛先, List<ChohyoSeigyoHanyo> 帳票制御汎用リスト, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文, RString 帳票分類ID, Ninshosha 認証者,
            RString 帳票情報, RString イメージファイルパス) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御汎用リスト = 帳票制御汎用リスト;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.発行日 = 発行日;
        this.文書番号 = 文書番号;
        this.通知書定型文 = 通知書定型文;
        this.帳票分類ID = 帳票分類ID;
        this.認証者 = 認証者;
        this.帳票情報 = 帳票情報;
        this.イメージファイルパス = イメージファイルパス;
    }

    @Override
    public ShiharaiHohoHenkoYokokuTsuchishoReportSource edit(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {

        setCompSofubutsuAtesaki(source);
        setCompNinshosha(source);
        setLayer1(source);
        return source;
    }

    private void setCompSofubutsuAtesaki(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.宛先, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        // TODO帳票情報が知らない
        //source.jusho4 = sofubutsuAtesakiSource.j;
        //source.jusho5 = RString.EMPTY;
        //source.jusho6 = RString.EMPTY;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        // source.katagaki3 = RString.EMPTY;
        // source.katagaki4 = RString.EMPTY;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        // source.shimei3 = RString.EMPTY;
        // source.shimei4 = RString.EMPTY;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
    }

    private void setCompNinshosha(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
        NinshoshaSource ninshoshaSource = getCompNinshosha();
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
    }

    private NinshoshaSource getCompNinshosha() {
        RDate 発行日RDate = new RDate(this.発行日.toString());
        return NinshoshaSourceBuilderFactory.createInstance(
                this.認証者, this.地方公共団体, this.イメージファイルパス, 発行日RDate).buildSource();
    }

    private void setLayer1(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
        source.bunshoNo = this.文書番号;
        EditedKojin 編集後個人 = getEditedKojin(this.個人情報, this.帳票制御共通);
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        //TODO  帳票情報が知らない
        //source.hihokenshaNo1 = ;
        //source.hihokenshaNo2 = ;
        //source.hihokenshaNo3 = ;
        //source.hihokenshaNo4 = ;
        //source.hihokenshaNo5 = ;
        //source.hihokenshaNo6 = ;
        //source.hihokenshaNo7 = ;
        //source.hihokenshaNo8 = ;
        //source.hihokenshaNo9 = ;
        //source.hihokenshaNo10 = ;
        //source.nendoTitle1 = ;
        //source.nendoTitle2 = ;
        //source.nendoTitle3 = ;
        //source.listTainoJokyo_1(15) = ;
        //source.listTainoJokyo_2(15) = ;
        //source.listTainoJokyo_3(15) = ;
        //source.listTainoJokyo_4(15) = ;
        //source.listTainoJokyo_5(15) = ;
        //source.listTainoJokyo_6(15) = ;
        //source.listTainoJokyo_7(15) = ;
        //source.listTainoJokyo_8(15) = ;
        //source.listTainoJokyo_9(15) = ;
        //source.hokenGokei1 =;
        //source.entaiGokei1 =;
        //source.hokenGokei2 =;
        //source.entaiGokei2 =;
        //source.hokenGokei3 =;
        //source.entaiGokei3 =;
        //source.hanteiYMD =;
        //source.izen_hokenryo =;

        if (null != 通知書定型文 && !通知書定型文.isEmpty()) {
            source.tsuchibun1 = 通知書定型文.get(0);
        }
        if (null != 通知書定型文 && 通知書定型文.size() >= 2) {
            source.tsuchibun2 = 通知書定型文.get(1);
        }
        source.shikibetsuCode = new RString(this.個人情報.get識別コード().toString());
        //TODO  帳票情報が知らない
        //source.hihokenshaNo = new RString(item.get負担限度額認定().get被保険者番号().toString());

    }

    private static EditedKojin getEditedKojin(IKojin 個人情報, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(個人情報, 帳票制御共通);
    }

}
