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
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】連帳 KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor implements IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final int 連番;
    private static final int INT_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報 納入通知書期情報
     * @param ninshoshaSource 認証者情報
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
        this.納入通知書期情報 = 納入通知書期情報;
        this.連番 = 仮算定納入通知書情報.get連番();
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource edit(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubetsuAtesaki(source);
        edit納付書1(source);
        return source;
    }

    private void edit納付書1(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source) {
        NofuShoKyotsu 納付書共通 = 仮算定納入通知書情報.get納付書共通();
        if (納付書共通 != null) {
            source.kamokumei1 = 納付書共通.get科目名称();
            source.ryoshushoNendo1 = 納付書共通.get調定年度表記();
            source.nendoNenbun1 = 納付書共通.get年度年分表記();
            source.ryoshushoNenbun1 = 納付書共通.get賦課年度表記();
            if (納付書共通.get通知書番号() != null) {
                source.tsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
            }
            source.hakkoYmd1 = 納付書共通.get発行日表記();
            source.tsuchishoShimei1 = 納付書共通.get納付者氏名();
            source.gimushaShimei1 = 納付書共通.get被代納人氏名();
        }
        source.kibetsu1 = 納入通知書期情報.get期表記();
        source.gokeigaku1 = 納入通知書期情報.get納付額表記();
        source.shunoKikanBango1 = 納入通知書期情報.get収納機関番号表示用();
        source.nofuBango1 = 納入通知書期情報.get納付番号();
        source.kakuninBango1 = 納入通知書期情報.get確認番号();
        source.nofuKubun1 = 納入通知書期情報.get納付区分();
        source.nokigenTitle1 = new RString("本状の納期限");
        source.ocrId1 = 納入通知書期情報.getOcrid();
        source.nokigenYmd1 = 納入通知書期情報.get納期限表記();
        source.honzei1 = 納入通知書期情報.get納付額表記();
        source.tokusokuTesuryo1 = RString.EMPTY;
        source.ocrCut1 = RStringUtil.convert全角to半角(new RString("X"));
        if (納入通知書期情報.getOcr() != null) {
            source.ocr11 = 納入通知書期情報.getOcr().get(1);
            source.ocr21 = 納入通知書期情報.getOcr().get(2);
        }
        source.entaikin1 = RString.EMPTY;
        source.biko11 = RString.EMPTY;
        source.biko21 = RString.EMPTY;
        source.barcodeCvsBarcode1 = 納入通知書期情報.getバーコード情報();
        source.cvsBarcodeNaiyo11 = 納入通知書期情報.getバーコード情報上段();
        source.cvsBarcodeNaiyo21 = 納入通知書期情報.getバーコード情報下段();
        if (納入通知書期情報.getコンビニ支払期限() != null) {
            source.cvsToriatsukaikigen1 = 納入通知書期情報.getコンビニ支払期限().toDateString();
        }
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            source.funyuFukanBango1 = new RString("F-").concat(new RString(連番).padLeft("0", INT_6)).concat("-3");
        }
    }

    private void editCompSofubetsuAtesaki(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source) {
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        if (編集後仮算定通知書共通情報 != null) {
            EditedAtesaki 編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
            if (編集後宛先 != null) {
                SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
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
    }

    private void editCompNinshosha(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source) {
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

    private void editレイヤ１(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source) {
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        if (null == 編集後仮算定通知書共通情報) {
            編集後仮算定通知書共通情報 = new EditedKariSanteiTsuchiShoKyotsu();
        }
        if (編集後仮算定通知書共通情報.get調定年度_年度なし() != null) {
            source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        }
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            source.noutsuRenban = NotsuReportEditorUtil.get納通連番(連番);
            source.notsuShikibtsuBango = new RString("F-").concat(new RString(連番).padLeft("0", INT_6)).concat("-1");
            source.keisanMeisaishoShikibtsuBango = new RString("F-").concat(new RString(連番).padLeft("0", INT_6)).concat("-2");
        } else {
            source.noutsuRenban = RString.EMPTY;
        }
        source.hyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
        source.hyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
        source.hyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
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
            source.kozaShurui = 編集後口座.get口座種別略称();
            source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
            source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.kozaMeiginin = 編集後口座.get口座名義人優先();
        }
        source.ki1 = 納入通知書期情報.get期表記();
        source.tsuki1 = 納入通知書期情報.get月表記();
        source.nofuGaku1 = 仮算定納入通知書情報.get納入通知書期情報リスト().get(0).get納付額表記();
        source.nokigen1 = 仮算定納入通知書情報.get納入通知書期情報リスト().get(0).get納期限表記();
        source.ki2 = RString.EMPTY;
        source.tsuki2 = RString.EMPTY;
        source.nofuGaku2 = RString.EMPTY;
        source.nokigen2 = RString.EMPTY;
        source.ki3 = RString.EMPTY;
        source.tsuki3 = RString.EMPTY;
        source.nofuGaku3 = RString.EMPTY;
        source.nokigen3 = RString.EMPTY;
        source.ki4 = RString.EMPTY;
        source.tsuki4 = RString.EMPTY;
        source.nofuGaku4 = RString.EMPTY;
        source.nokigen4 = RString.EMPTY;
        source.ki5 = RString.EMPTY;
        source.tsuki5 = RString.EMPTY;
        source.nofuGaku5 = RString.EMPTY;
        source.nokigen5 = RString.EMPTY;
        source.ki6 = RString.EMPTY;
        source.tsuki6 = RString.EMPTY;
        source.nofuGaku6 = RString.EMPTY;
        source.nokigen6 = RString.EMPTY;
        source.kikanSt = RString.EMPTY;
        source.kikanEd = RString.EMPTY;
        if (仮算定納入通知書情報.get仮算定納入通知書制御情報() != null
                && 仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && HyojiUmu.表示する.equals(仮算定納入通知書情報.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ明細書表示())) {
            edit明細(source, 編集後仮算定通知書共通情報, 編集後個人);
        }
    }

    private void edit明細(KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報, EditedKojin 編集後個人) {
        source.keisanMeisaishoNendo = 編集後仮算定通知書共通情報.get調定年度_年度なし();
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.keisanMeisaishoTsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
        if (編集後個人 != null) {
            source.kaisanMeisaishoHihokenshaName = 編集後個人.get名称().getName().getColumnValue();
            source.keisanMeisaishoSetaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.kaisanMeisaishoSetaiNushiName = 編集後個人.get世帯主名().getColumnValue();
        }
        PrecedingFiscalYearInformation 前年度情報 = 編集後仮算定通知書共通情報.get前年度情報();
        if (前年度情報 != null) {
            source.keisanMeisaishoNendo1 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoShotokuDankai = 前年度情報.get前年度保険料段階();
            source.keisanMeisaishoNendo2 = 前年度情報.get前年度賦課年度();
            if (前年度情報.get前年度保険料率() != null) {
                source.keisanMeisaishoKingaku1 = new RString(前年度情報.get前年度保険料率().toString());
            }
            source.keisanMeisaishoNendo3 = 前年度情報.get前年度賦課年度();
            source.keisanMeisaishoNendo4 = 前年度情報.get前年度賦課年度();
            if (前年度情報.get前年度確定介護保険料_年額() != null) {
                source.keisanMeisaishoKingaku2 = new RString(前年度情報.get前年度確定介護保険料_年額().toString());
            }
            if (前年度情報.get前年度最終期普徴期別介護保険料() != null) {
                source.keisanMeisaishoKingaku3 = new RString(前年度情報.get前年度最終期普徴期別介護保険料().toString());
            }
        }
        source.keisanMeisaishoKomokuTitle2 = new RString("保険料率");
        source.keisanMeisaishoYen1 = new RString("円");
        source.keisanMeisaishoYen2 = new RString("円");
        source.keisanMeisaishoYen3 = new RString("円");
        source.keisanMeisaishoKomokuTitle3 = new RString("年額保険料");
        source.keisanMeisaishoKomokuTitle4 = new RString("最終期保険料額");
        source.keisanMeisaishoKisu = new RString(編集後仮算定通知書共通情報.get普徴期数());
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (更正後 != null) {
            if (更正後.get更正後介護保険料減免額() != null) {
                source.keisanMeisaishoGenmenGaku = new RString(更正後.get更正後介護保険料減免額().toString());
            }
            if (更正後.get更正後特徴期別金額合計() != null) {
                source.kaisanMeisaishoTokuchoGokeiGaku = new RString(更正後.get更正後特徴期別金額合計().toString());
            }
            if (更正後.get更正後普徴期別金額合計() != null) {
                source.keisanMeisaishoHokenryoGakuGokei = new RString(更正後.get更正後普徴期別金額合計().toString());
            }
        }
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        if (出力期リスト != null && !出力期リスト.isEmpty()) {
            Kitsuki 出力期 = 出力期リスト.get(0);
            source.keisanMeisaishoKiTitle1 = new RString("第").concat(出力期.get期()).concat("期");
            if (更正後 != null) {
                List<UniversalPhase> 更正後普徴期別金額リスト = 更正後.get更正後普徴期別金額リスト();
                source.keisanMeisaishoKiNofuGaku1 = get金額(更正後普徴期別金額リスト, 出力期.get期AsInt());
                source.keisanMeisaishoKiNofuGaku2 = get金額(更正後普徴期別金額リスト, 出力期.get期AsInt() + 1);
            }
        }
        source.keisanMeisaishoKiTitle2 = new RString("次期以降");
        source.keisanMeisaishoKarisanteiNendo = 編集後仮算定通知書共通情報.get調定年度_年度あり();
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
