/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.KarisanteiNonyuTsuchishoCVSKigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.PrecedingFiscalYearInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.KarisanteiNonyuTsuchishoCVSKigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】KarisanteiNonyuTsuchishoCVSKigotoEditor
 */
public class KarisanteiNonyuTsuchishoCVSKigotoEditor implements IKarisanteiNonyuTsuchishoCVSKigotoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    //private final NinshoshaSource ninshoshaSource;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private static final int INT6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KarisanteiNonyuTsuchishoCVSKigotoItem}
     * @param 連番 連番
     * @param sofubutsuAtesakiSource sofubutsuAtesakiSource
     */
    protected KarisanteiNonyuTsuchishoCVSKigotoEditor(
            KarisanteiNonyuTsuchishoCVSKigotoItem item,
            int 連番,
            SofubutsuAtesakiSource sofubutsuAtesakiSource) {
        //NinshoshaSource ninshoshaSource,
        this.仮算定納入通知書情報
                = null == item.get仮算定納入通知書情報() ? new KariSanteiNonyuTsuchiShoJoho() : item.get仮算定納入通知書情報();
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト().isEmpty()
                ? new ArrayList<NonyuTsuchiShoKiJoho>() : 仮算定納入通知書情報.get納入通知書期情報リスト();
        this.連番 = 連番;
        //this.ninshoshaSource = ninshoshaSource;
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKigotoSource edit(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        editレイヤ１(source);
        //editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        source.jusho1 = sofubutsuAtesakiSource.jusho1;
        source.jusho2 = sofubutsuAtesakiSource.jusho2;
        source.jusho3 = sofubutsuAtesakiSource.jusho3;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
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
        source.shimei1 = sofubutsuAtesakiSource.shimei1;
        source.shimei2 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
    }

//    private void editCompNinshosha(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
//        source.denshiKoin = ninshoshaSource.denshiKoin;
//        source.hakkoYMD = ninshoshaSource.hakkoYMD;
//        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
//        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
//        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
//        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
//        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
//        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
//        source.koinShoryaku = ninshoshaSource.koinShoryaku;
//    }
    private void editレイヤ１(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        boolean isバッチ = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分());
        NonyuTsuchiShoKiJoho 納入通知書期情報 = 納入通知書期情報リスト.isEmpty() ? new NonyuTsuchiShoKiJoho() : 納入通知書期情報リスト.get(0);
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        source.noutsu_renban = isバッチ ? new RString("*").concat(new RString(String.valueOf(連番)).padLeft("0", INT6)).concat("#") : RString.EMPTY;
        source.HyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
        source.HyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
        source.HyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
        source.Hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
        source.Hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
        source.Hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
        //編集後個人
        source.SetaiCode = null;
        source.TsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        //if (true) {
        //編集後口座に、口座の情報   isPresent()がtrueの場合
        source.bankCodeTitle = new RString("金融機関コード");
        //}
        //if (true) {
        source.kozaShuruiTitle = new RString("種別");
        //}
        //編集後口座
        source.kozaNoTitle = null;
        source.bankCode = null;
        source.kozaShurui = null;
        source.kozaNo = null;
        //if (true) {
        //編集後口座に、口座の情報   isPresent()がtrueの場合
        source.bankNameTitle = new RString("金融機関");
        //}
        source.bankName = null;
        //if (true) {
        //編集後口座に、口座の情報   isPresent()がtrueの場合
        source.kozaMeigininTitle = new RString("名義人");
        //}
        //編集後口座
        source.kozaMeiginin = null;
        source.ki1 = 納入通知書期情報.get期表記();
        source.tsuki1 = 納入通知書期情報.get月表記();
        source.nofuGaku1 = 納入通知書期情報.get納付額表記();
        source.Nokigen1 = 納入通知書期情報.get納期限表記();
        source.Hyojicode1 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.pageCount1 = new RString(String.valueOf(連番)).concat("-1");
        if (HyojiUmu.表示する.equals(仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ明細書表示())) {
            PrecedingFiscalYearInformation 前年度情報 = 編集後仮算定通知書共通情報.get前年度情報();
            if (null == 前年度情報) {
                前年度情報 = new PrecedingFiscalYearInformation();
            }
            EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
            if (null == 更正後) {
                更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
            }
            List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
            source.keisanMeisaishoNendo = 編集後仮算定通知書共通情報.get調定年度_年度なし();
            source.keisanMeisaishoTsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
            //編集後個人
            source.kaisanMeisaishoHihokenshaName = null;
            source.keisanMeisaishoSetaiCode = null;
            //編集後個人
            source.kaisanMeisaishoSetaiNushiName = null;
            source.keisanMeisaishoNendo1 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoShotokuDankai = 前年度情報.get前年度保険料段階();
            source.keisanMeisaishoNendo2 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoKomokuTitle2 = new RString("保険料率");
            source.keisanMeisaishoKingaku1 = new RString(前年度情報.get前年度保険料率().toString());
            source.keisanMeisaishoYen1 = new RString("円");
            source.keisanMeisaishoNendo3 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoKomokuTitle3 = new RString("年額保険料");
            source.kaisanMeisaishoKingaku2 = new RString(前年度情報.get前年度確定介護保険料_年額().toString());
            source.keisanMeisaishoYen2 = new RString("円");
            source.keisanMeisaishoNendo4 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoKomokuTitle4 = new RString("最終期保険料額");
            source.keisanMeisaishoKingaku3 = new RString(前年度情報.get前年度最終期普徴期別介護保険料().toString());
            source.kaisanMeisaishoYen3 = new RString("円");
            source.keisanMeisaishoKisu = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
            source.keisanMeisaishoGenmenGaku = new RString(更正後.get更正後介護保険料減免額().toString());
            source.kaisanMeisaishoTokuchoGokeiGaku = new RString(更正後.get更正後特徴期別金額合計().toString());
            Kitsuki 出力期 = 出力期リスト.get(0);
            source.keisanMeisaishoKiTitle1 = new RString("第").concat(出力期.get期()).concat("期");
            //TODO
            source.keisanMeisaishoKiNofuGaku1 = new RString(get金額(new ArrayList<UniversalPhase>(), 出力期.get期AsInt()).toString());
            source.keisanMeisaishoKiTitle2 = new RString("次期以降");
            //TODO
            source.keisanMeisaishoKiNofuGaku2 = new RString(get金額(new ArrayList<UniversalPhase>(), 出力期.get期AsInt() + 1).toString());
            source.keisanMeisaishoKarisanteiNendo = 編集後仮算定通知書共通情報.get調定年度_年度あり();
            source.keisanMeisaishoHokenryoGakuGokei = new RString(更正後.get更正後普徴期別金額合計().toString());
        }
        source.notsuRenban2 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.pageCount2 = new RString(String.valueOf(連番)).concat("-2");
        source.renban = isバッチ ? new RString(String.valueOf(連番)) : RString.EMPTY;
        source.hokenshaName = new RString(編集後仮算定通知書共通情報.get保険者名().getText());
        source.notsuRenban3 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.pageCount3 = new RString(String.valueOf(連番)).concat("-3");
    }

    private Decimal get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return 更正後普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

}
