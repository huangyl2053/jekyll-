/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.PrecedingFiscalYearInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】KarisanteiNonyuTsuchishoCVSKigotoEditor
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSKigotoEditor implements IKarisanteiNonyuTsuchishoCVSKigotoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final int 連番;
    private final NinshoshaSource ninshoshaSource;
    private final EditedAtesaki 編集後宛先;
    private static final int INT6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @param 納入通知書期情報 納入通知書期情報
     */
    protected KarisanteiNonyuTsuchishoCVSKigotoEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            NinshoshaSource ninshoshaSource,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.連番 = 仮算定納入通知書情報.get連番();
        this.ninshoshaSource = ninshoshaSource;
        this.編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKigotoSource edit(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        edit納付書(source);
        return source;
    }

    private void edit納付書(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        NofuShoKyotsu 納付書共通 = 仮算定納入通知書情報.get納付書共通();
        if (納付書共通 != null) {
            source.kamokumei = 納付書共通.get科目名称();
            source.ryoshushoNendo = 納付書共通.get調定年度表記();
            source.nendoNenbun = 納付書共通.get年度年分表記();
            source.ryoshushoNenbun = 納付書共通.get賦課年度表記();
            if (納付書共通.get通知書番号() != null) {
                source.tsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
            }
            source.hakkoYmd = 納付書共通.get発行日表記();
            source.shimei = 納付書共通.get納付者氏名();
            source.gimushaShimei = 納付書共通.get被代納人氏名();
        }
        source.kibetsu = 納入通知書期情報.get期表記();
        //TODO 納入通知書期情報.納付額表記 空白
        source.gokeigaku = 納入通知書期情報.get納付額表記();
        source.shunoKikanBango = 納入通知書期情報.get収納機関番号表示用();
        source.nofuBango = 納入通知書期情報.get納付番号();
        source.kakuninBango = 納入通知書期情報.get確認番号();
        source.nofuKubun = 納入通知書期情報.get納付区分();
        //TODO 本状の納期限 納期限
        source.nokigenTitle = new RString("本状の納期限");
        source.ocrId = 納入通知書期情報.getOcrid();
        source.nokigenYmd = 納入通知書期情報.get納期限表記();
        source.honzei = 納入通知書期情報.get納付額表記();
        source.tokusokuTesuryo = RString.EMPTY;
        if (納入通知書期情報.getOcr() != null) {
            source.ocr1 = 納入通知書期情報.getOcr().get(1);
            source.ocr2 = 納入通知書期情報.getOcr().get(2);
        }
        source.ocrCut = RStringUtil.convert全角to半角(new RString("X"));
        source.entaikin = RString.EMPTY;
        source.biko1 = RString.EMPTY;
        source.biko2 = RString.EMPTY;
        source.barcodeCvsBarcode = 納入通知書期情報.getバーコード情報();
        source.cvsBarcodeNaiyo1 = 納入通知書期情報.getバーコード情報上段();
        source.cvsBarcodeNaiyo2 = 納入通知書期情報.getバーコード情報下段();
        if (納入通知書期情報.getコンビニ支払期限() != null) {
            source.cvsToriatsukaikigen = 納入通知書期情報.getコンビニ支払期限().toDateString();
        }
    }

    private void editCompSofubutsuAtesaki(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;
        if (編集後宛先 != null) {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        }
        if (sofubutsuAtesakiSource != null) {
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
    }

    private void editCompNinshosha(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        if (ninshoshaSource != null) {
            source.denshiKoin = ninshoshaSource.denshiKoin;
            source.hakkoYMD = ninshoshaSource.hakkoYMD;
            source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
            source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
            source.koinShoryaku = ninshoshaSource.koinShoryaku;
        }
    }

    private void editレイヤ１(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        boolean isバッチ = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分());
        if (編集後仮算定通知書共通情報.get調定年度_年度なし() != null) {
            source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        }
        source.noutsu_renban = isバッチ ? NotsuReportEditorUtil.get納通連番(連番) : RString.EMPTY;
        source.hyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
        source.hyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
        source.hyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後仮算定通知書共通情報.get編集後口座();
        if (編集後個人 != null) {
            source.setaiCode = 編集後個人.get世帯コード().getColumnValue();
        }
        if (編集後口座 != null) {
            if (編集後口座.isPresent()) {
                source.bankCodeTitle = new RString("金融機関コード");
                source.kozaShuruiTitle = new RString("種別");
                source.bankNameTitle = new RString("金融機関");
                source.kozaMeigininTitle = new RString("名義人");
            }
            source.kozaNoTitle = 編集後口座.get番号名称();
            source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
            source.kozaShurui = 編集後口座.get預金種別略称();
            source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
            source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.kozaMeiginin = 編集後口座.get口座名義人優先();
        }
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNoLay1 = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
        source.ki1 = 納入通知書期情報.get期表記();
        source.tsuki1 = 納入通知書期情報.get月表記();
        source.nofuGaku1 = 仮算定納入通知書情報.get納入通知書期情報リスト().get(0).get納付額表記();
        source.nokigen1 = 仮算定納入通知書情報.get納入通知書期情報リスト().get(0).get納期限表記();
        source.notsuRenban1 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        if (isバッチ) {
            source.pageCount1 = new RString(String.valueOf(連番)).concat("-1");
            source.pageCount2 = new RString(String.valueOf(連番)).concat("-2");
            source.pageCount3 = new RString(String.valueOf(連番)).concat("-3");
        }
        if (仮算定納入通知書情報.get仮算定納入通知書制御情報() != null
                && 仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && HyojiUmu.表示する.equals(仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ明細書表示())) {
            edit明細(source);
        }
        source.notsuRenban2 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.renban = isバッチ ? new RString(String.valueOf(連番)) : RString.EMPTY;
        source.hokenshaName = 編集後仮算定通知書共通情報.get保険者名();
        source.notsuRenban3 = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
    }

    private void edit明細(KarisanteiNonyuTsuchishoCVSKigotoSource source) {
        PrecedingFiscalYearInformation 前年度情報 = 編集後仮算定通知書共通情報.get前年度情報();
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.keisanMeisaishoTsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
        if (null == 前年度情報) {
            前年度情報 = new PrecedingFiscalYearInformation();
        }
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (null == 更正後) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        }
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        source.keisanMeisaishoNendo = 編集後仮算定通知書共通情報.get調定年度_年度なし();
        if (編集後個人 != null) {
            source.kaisanMeisaishoHihokenshaName = 編集後個人.get名称().getName().getColumnValue();
            source.keisanMeisaishoSetaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.kaisanMeisaishoSetaiNushiName = 編集後個人.get世帯主名().getColumnValue();
        }
        source.keisanMeisaishoNendo1 = 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoShotokuDankai = 前年度情報.get前年度保険料段階();
        source.keisanMeisaishoNendo2 = 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoKomokuTitle2 = new RString("保険料率");
        if (前年度情報.get前年度保険料率() != null) {
            source.keisanMeisaishoKingaku1 = new RString(前年度情報.get前年度保険料率().toString());
        }
        source.keisanMeisaishoYen1 = new RString("円");
        source.keisanMeisaishoNendo3 = 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoKomokuTitle3 = new RString("年額保険料");
        if (前年度情報.get前年度確定介護保険料_年額() != null) {
            source.kaisanMeisaishoKingaku2 = new RString(前年度情報.get前年度確定介護保険料_年額().toString());
        }
        source.keisanMeisaishoYen2 = new RString("円");
        source.keisanMeisaishoNendo4 = 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoKomokuTitle4 = new RString("最終期保険料額");
        if (前年度情報.get前年度最終期普徴期別介護保険料() != null) {
            source.keisanMeisaishoKingaku3 = new RString(前年度情報.get前年度最終期普徴期別介護保険料().toString());
        }
        source.kaisanMeisaishoYen3 = new RString("円");
        source.keisanMeisaishoKisu = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
        if (更正後.get更正後介護保険料減免額() != null) {
            source.keisanMeisaishoGenmenGaku = new RString(更正後.get更正後介護保険料減免額().toString());
        }
        if (更正後.get更正後特徴期別金額合計() != null) {
            source.kaisanMeisaishoTokuchoGokeiGaku = new RString(更正後.get更正後特徴期別金額合計().toString());
        }
        if (出力期リスト != null && !出力期リスト.isEmpty()) {
            Kitsuki 出力期 = 出力期リスト.get(0);
            List<UniversalPhase> 更正後普徴期別金額リスト = 更正後.get更正後普徴期別金額リスト();
            source.keisanMeisaishoKiTitle1 = new RString("第").concat(出力期.get期()).concat("期");
            source.keisanMeisaishoKiNofuGaku1 = get金額(更正後普徴期別金額リスト, 出力期.get期AsInt());
            source.keisanMeisaishoKiNofuGaku2 = get金額(更正後普徴期別金額リスト, 出力期.get期AsInt() + 1);
        }
        source.keisanMeisaishoKiTitle2 = new RString("次期以降");
        source.keisanMeisaishoKarisanteiNendo = 編集後仮算定通知書共通情報.get調定年度_年度あり();
        if (更正後.get更正後普徴期別金額合計() != null) {
            source.keisanMeisaishoHokenryoGakuGokei = new RString(更正後.get更正後普徴期別金額合計().toString());
        }
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        if (null == 更正後普徴期別金額リスト) {
            return RString.EMPTY;
        }
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期() && 更正後普徴期別金額.get金額() != null) {
                return new RString(更正後普徴期別金額.get金額().toString());
            }
        }
        return RString.EMPTY;
    }

}
