/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】（連帳）CoverのEditorです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor implements IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor {

    private final KariSanteiNonyuTsuchiShoJoho item;

    private static final RString HOKENRYO_RITU = new RString("保険料率");
    private static final RString NENGAKU_HOKENRYO = new RString("年額保険料");
    private static final RString EN = new RString("円");
    private static final RString TSUGIKI_IKOU = new RString("次期以降");
    private static final RString SAISYUUKI_HOKENRYO_GAKU = new RString("最終期保険料額");
    private static final RString NOKIGEN = new RString("納期限");
    private static final RString HANKAKU_X = new RString("X");
    private static final RString HOSHI_2 = new RString("**");
    private static final RString HOSHI_4 = new RString("****");
    private static final RString HOSHI_11 = new RString("***********");
    private static final RString HOSHI_13 = new RString("*************");
    private static final RString HOSHI_16 = new RString("****************");
    private static final RString HOSHI_28 = new RString("****************************");
    private static final RString BANK_CODE_TITLE = new RString("金融機関コード");
    private static final RString KOZA_SHURUI_TITLE = new RString("種別");
    private static final RString BANK_NAME_TITLE = new RString("金融機関");
    private static final RString KOZA_MEIGININ_TITLE = new RString("`名義人");

    private static final int リストサイズ１ = 1;
    private static final int リストサイズ２ = 2;
    private static final int リストサイズ３ = 3;
    private static final int リストサイズ４ = 4;
    private static final int リストサイズ５ = 5;
    private static final int リストサイズ６ = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KariSanteiNonyuTsuchiShoJoho}
     */
    protected KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor(KariSanteiNonyuTsuchiShoJoho item) {
        this.item = item;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoSource edit(KarisanteiNonyuTsuchishoCVSKakukoSource source) {
        editSource(source);
        source.layout = KarisanteiNonyuTsuchishoCVSKakukoSource.Layouts.DBB100027_KarisanteiNonyuTsuchishoCVSMultiRenchoCover;
        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource editSource(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        this.edit宛先(source);

        if (item.get仮算定納入通知書制御情報() != null
                && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && !HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ明細書表示())) {
            this.edit明細(source);
        }

        this.edit納付書1(source);

        this.edit納付書2(source);
        //TODO
        this.edit雛形部品(source);

        this.editCompSofubutsuAtesaki(source);

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit宛先(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後仮算定通知書共通情報() != null) {
            source.hyojicodeName1 = item.get編集後仮算定通知書共通情報().get表示コード１名();
            source.hyojicodeName2 = item.get編集後仮算定通知書共通情報().get表示コード２名();
            source.hyojicodeName3 = item.get編集後仮算定通知書共通情報().get表示コード３名();
            if (item.get編集後仮算定通知書共通情報().get調定年度() != null) {
                source.titleNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
            }
            source.hyojicode1 = item.get編集後仮算定通知書共通情報().get表示コード1();
            source.hyojicode2 = item.get編集後仮算定通知書共通情報().get表示コード２();
            source.hyojicode3 = item.get編集後仮算定通知書共通情報().get表示コード３();
            if (item.get編集後仮算定通知書共通情報().get編集後個人() != null
                    && item.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード() != null) {
                source.setaiCode = item.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value();
            }
            if (item.get編集後仮算定通知書共通情報().get通知書番号() != null) {
                source.tsuchishoNo = item.get編集後仮算定通知書共通情報().get通知書番号().value();
            }
            if (item.get編集後仮算定通知書共通情報().get編集後口座() != null) {
                source.bankCodeTitle = item.get編集後仮算定通知書共通情報().get編集後口座().isPresent() ? BANK_CODE_TITLE : RString.EMPTY;
                source.kozaShuruiTitle = item.get編集後仮算定通知書共通情報().get編集後口座().isPresent() ? KOZA_SHURUI_TITLE : RString.EMPTY;
                source.kozaNoTitle = item.get編集後仮算定通知書共通情報().get編集後口座().get番号名称();
                source.bankCode = item.get編集後仮算定通知書共通情報().get編集後口座().get金融機関コードCombinedWith支店コード();
                source.kozaShurui = item.get編集後仮算定通知書共通情報().get編集後口座().get口座種別略称();
                source.kozaNo = item.get編集後仮算定通知書共通情報().get編集後口座().get口座番号Or通帳記号番号();
                source.bankNameTitle = item.get編集後仮算定通知書共通情報().get編集後口座().isPresent() ? BANK_NAME_TITLE : RString.EMPTY;
                source.bankName = item.get編集後仮算定通知書共通情報().get編集後口座().get金融機関名CombinedWith支店名();
                source.kozaMeigininTitle = item.get編集後仮算定通知書共通情報().get編集後口座().isPresent() ? KOZA_MEIGININ_TITLE : RString.EMPTY;
                source.kozaMeiginin = item.get編集後仮算定通知書共通情報().get編集後口座().get口座名義人優先();
            }
        }

        source.noutsu_renban = new RString("*" + "TODO連番(6桁0埋め)" + "#");

        this.納入通知書期情報設定(source);

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit明細(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後仮算定通知書共通情報() != null) {
            if (item.get編集後仮算定通知書共通情報().get調定年度() != null) {
                source.keisanMeisaishoNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
                source.keisanMeisaishoKarisanteiNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
            }

            this.編集後個人相関設定(source);

            if (item.get編集後仮算定通知書共通情報().get通知書番号() != null) {
                source.keisanMeisaishoTsuchishoNo = item.get編集後仮算定通知書共通情報().get通知書番号().value();
            }
            if (item.get編集後仮算定通知書共通情報().get増減額() != null) {
                source.keisanMeisaishoGenmenGaku = new RString(item.get編集後仮算定通知書共通情報().get増減額().toString());
            }
            this.前年度情報相関設定(source);

            if (item.get編集後仮算定通知書共通情報().get普徴収入情報リスト() != null
                    && item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(1) != null
                    && item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(1).get収入額() != null) {
                source.keisanMeisaishoKiNofuGaku2
                        = new RString(item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(1).get収入額().toString());
            }
            source.keisanMeisaishoKisu = new RString(String.valueOf(item.get編集後仮算定通知書共通情報().get普徴期数()));
            if (item.get編集後仮算定通知書共通情報().get更正後() != null
                    && item.get編集後仮算定通知書共通情報().get更正後().get更正後普徴期別金額合計() != null) {
                source.keisanMeisaishoHokenryoGaku = new RString(item.get編集後仮算定通知書共通情報().get更正後().get更正後普徴期別金額合計().toString());
            }
//            if (item.get編集後仮算定通知書共通情報().get保険者名() != null) {
//                source.hokenshaName = new RString(item.get編集後仮算定通知書共通情報().get保険者名().toString());
//            }
            if (item.get編集後仮算定通知書共通情報().get普徴収入情報リスト() != null
                    && item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(0) != null
                    && item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(0).get収入額() != null) {
                source.keisanMeisaishoKiNofuGaku1 = new RString(item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(0).get収入額().toString());
            }
        }

        source.keisanMeisaishoKomokuTitle2 = HOKENRYO_RITU;
        source.keisanMeisaishoYen1 = EN;
        if (item.get出力期リスト() != null
                && item.get出力期リスト().get(0) != null) {
            source.keisanMeisaishoKiTitle1 = new RString("第" + item.get出力期リスト().get(0).get期() + "期");
        } else {
            source.keisanMeisaishoKiTitle1 = new RString("第　期");
        }

        source.keisanMeisaishoKomokuTitle3 = NENGAKU_HOKENRYO;
        source.keisanMeisaishoYen2 = EN;
        source.keisanMeisaishoKiTitle2 = TSUGIKI_IKOU;
        source.keisanMeisaishoKomokuTitle4 = SAISYUUKI_HOKENRYO_GAKU;
        source.keisanMeisaishoYen3 = EN;

        source.kikanSt = item.get編集後仮算定通知書共通情報().get更正後().get期間_自();
        source.kikanEd = item.get編集後仮算定通知書共通情報().get更正後().get期間_至();

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuShikibtsuBango = new RString("F+ 連番 + -1");
            source.keisanMeisaishoShikibtsuBango = new RString("F+ 連番 + -2");
        }
        return source;
    }

    private void edit納付書1(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        if (item.get納入通知書期情報リスト() != null) {
            if (item.get納入通知書期情報リスト().get(0) != null) {
                source.shunoKikanBango = item.get納入通知書期情報リスト().get(0).get収納機関番号表示用();
                //TODO
                source.nofuBango = item.get納入通知書期情報リスト().get(0).get納付番号();
                source.kakuninBango = item.get納入通知書期情報リスト().get(0).get確認番号();
                source.nofuKubun = item.get納入通知書期情報リスト().get(0).get納付区分();
                source.ocrId = item.get納入通知書期情報リスト().get(0).getOCRID();
                source.barcodeCvsBarcode = item.get納入通知書期情報リスト().get(0).getバーコード情報();
                source.cvsBarcodeNaiyo1 = item.get納入通知書期情報リスト().get(0).getバーコード情報上段();
                source.cvsBarcodeNaiyo2 = item.get納入通知書期情報リスト().get(0).getバーコード情報下段();
                source.kibetsu = item.get納入通知書期情報リスト().get(0).get期表記();
                source.gokeigaku = item.get納入通知書期情報リスト().get(0).get納付額表記();
                source.nokigenYmd = item.get納入通知書期情報リスト().get(0).get納期限表記();
                source.honzei = item.get納入通知書期情報リスト().get(0).get納付額表記();
                source.ocr1 = item.get納入通知書期情報リスト().get(0).getOCR().get(1);
                source.ocr2 = item.get納入通知書期情報リスト().get(0).getOCR().get(2);
            }
            if (item.get納入通知書期情報リスト().get(0).getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen = item.get納入通知書期情報リスト().get(0).getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.ryoshushoNendo = item.get納付書共通().get調定年度表記();
                source.nendoNenbun = item.get納付書共通().get年度年分表記();
                source.ryoshushoNenbun = item.get納付書共通().get賦課年度表記();
                source.hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr1 = HOSHI_28;
            source.ocr2 = HOSHI_28;
            source.cvsToriatsukaikigen = HOSHI_16;
        }

        source.nokigenTitle = NOKIGEN;
        source.tokusokuTesuryo = RString.EMPTY;
        source.ocrCut = HANKAKU_X;
        source.entaikin = RString.EMPTY;
        source.biko1 = RString.EMPTY;
        source.biko2 = RString.EMPTY;
        source.funyuFukanBango = RString.EMPTY;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit納付書2(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        if (item.get納入通知書期情報リスト() != null) {
            if (item.get納入通知書期情報リスト().get(1) != null) {
                source.shunoKikanBango2 = item.get納入通知書期情報リスト().get(1).get収納機関番号表示用();
                //TODO
                source.nofuBango = item.get納入通知書期情報リスト().get(1).get納付番号();
                source.kakuninBango2 = item.get納入通知書期情報リスト().get(1).get確認番号();
                source.nofuKubun2 = item.get納入通知書期情報リスト().get(1).get納付区分();
                source.ocrId2 = item.get納入通知書期情報リスト().get(1).getOCRID();
                source.barcodeCvsBarcode2 = item.get納入通知書期情報リスト().get(1).getバーコード情報();
                source.cvsBarcodeNaiyo12 = item.get納入通知書期情報リスト().get(1).getバーコード情報上段();
                source.cvsBarcodeNaiyo22 = item.get納入通知書期情報リスト().get(1).getバーコード情報下段();
                source.kibetsu = item.get納入通知書期情報リスト().get(1).get期表記();
                source.gokeigaku = item.get納入通知書期情報リスト().get(1).get納付額表記();
                source.nokigenYmd = item.get納入通知書期情報リスト().get(1).get納期限表記();
                source.honzei = item.get納入通知書期情報リスト().get(1).get納付額表記();
                source.ocr12 = item.get納入通知書期情報リスト().get(1).getOCR().get(1);
                source.ocr22 = item.get納入通知書期情報リスト().get(1).getOCR().get(2);
            }
            if (item.get納入通知書期情報リスト().get(1).getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen2 = item.get納入通知書期情報リスト().get(1).getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.ryoshushoNendo2 = item.get納付書共通().get調定年度表記();
                source.nendoNenbun = item.get納付書共通().get年度年分表記();
                source.ryoshushoNenbun2 = item.get納付書共通().get賦課年度表記();
                source.hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo2 = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun2 = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr12 = HOSHI_28;
            source.ocr22 = HOSHI_28;
            source.cvsToriatsukaikigen2 = HOSHI_16;
        }

        source.nokigenTitle = NOKIGEN;
        source.tokusokuTesuryo = RString.EMPTY;
        source.ocrCut2 = HANKAKU_X;
        source.entaikin = RString.EMPTY;
        source.biko12 = RString.EMPTY;
        source.biko22 = RString.EMPTY;
        source.funyuFukanBango2 = RString.EMPTY;

        return source;
    }

    private void edit雛形部品(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

//        if (item.get発行日() != null) {
//            ChohyoSeigyoKyotsu 帳票制御共通
//                    = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMultiCover"));
//            INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
//            Ninshosha ninshosha = ninshoshaManager.get帳票認証者(
//                    GyomuCode.DB介護保険,
//                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                    item.get発行日());
//            IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
//            Association association = associationFinder.getAssociation();
//            INinshoshaSourceBuilder iNinshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
//                    ninshosha,
//                    association,
//                    reportSourceWriter.getImageFolderPath(),
//                    new RDate(item.get発行日().toString()),
//                    new RString("1").equals(帳票制御共通.get首長名印字位置()),
//                    !帳票制御共通.is電子公印印字有無(),
//                    KenmeiFuyoKubunType.付与なし);
//            NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();
//
//            if (ninshoshaSource != null) {
//                source.denshiKoin = ninshoshaSource.denshiKoin;
//                source.hakkoYMD = ninshoshaSource.hakkoYMD;
//                source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
//                source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
//                source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
//                source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
//                source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
//                source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
//                source.koinShoryaku = ninshoshaSource.koinShoryaku;
//            }
//        }
    }

    private void editCompSofubutsuAtesaki(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;
        if (item.get編集後仮算定通知書共通情報() != null
                && item.get編集後仮算定通知書共通情報().get編集後宛先() != null) {
            kaigoSofubutsuAtesakiSource = item.get編集後仮算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource();
        }
        if (kaigoSofubutsuAtesakiSource != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource.get送付物宛先ソース();

            source.yubinNo = sofubutsuAtesakiSource.yubinNo;
            source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
            source.jusho3 = sofubutsuAtesakiSource.jusho3;
            source.jushoText = sofubutsuAtesakiSource.jushoText;
            source.jusho1 = sofubutsuAtesakiSource.jusho1;
            source.jusho2 = sofubutsuAtesakiSource.jusho2;
            source.katagakiText = sofubutsuAtesakiSource.katagakiText;
            source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
            source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
            source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
            source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
            source.shimei2 = sofubutsuAtesakiSource.shimei2;
            source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
            source.shimeiText = sofubutsuAtesakiSource.shimeiText;
            source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
            source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
            source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
            source.shimei1 = sofubutsuAtesakiSource.shimei1;
            source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
            source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
            source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
            source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
            source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
            source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
            source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
            source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
            source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
            source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
            source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
            source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
            source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        }
    }

    private void 納入通知書期情報設定(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ１) {
            source.ki1 = item.get納入通知書期情報リスト().get(0).get期表記();
            source.tsuki1 = item.get納入通知書期情報リスト().get(0).get月表記();
            source.nofuGaku1 = item.get納入通知書期情報リスト().get(0).get納付額表記();
            source.nokigen1 = item.get納入通知書期情報リスト().get(0).get納期限表記();
        }
        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ２) {
            source.ki2 = item.get納入通知書期情報リスト().get(リストサイズ１).get期表記();
            source.tsuki2 = item.get納入通知書期情報リスト().get(リストサイズ１).get月表記();
            source.nofuGaku2 = item.get納入通知書期情報リスト().get(リストサイズ１).get納付額表記();
            source.nokigen2 = item.get納入通知書期情報リスト().get(リストサイズ１).get納期限表記();
        }
        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ３) {
            source.ki3 = item.get納入通知書期情報リスト().get(リストサイズ２).get期表記();
            source.tsuki3 = item.get納入通知書期情報リスト().get(リストサイズ２).get月表記();
            source.nofuGaku3 = item.get納入通知書期情報リスト().get(リストサイズ２).get納付額表記();
            source.nokigen3 = item.get納入通知書期情報リスト().get(リストサイズ２).get納期限表記();
        }
        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ４) {
            source.ki4 = item.get納入通知書期情報リスト().get(リストサイズ３).get期表記();
            source.tsuki4 = item.get納入通知書期情報リスト().get(リストサイズ３).get月表記();
            source.nofuGaku4 = item.get納入通知書期情報リスト().get(リストサイズ３).get納付額表記();
            source.nokigen4 = item.get納入通知書期情報リスト().get(リストサイズ３).get納期限表記();
        }
        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ５) {
            source.ki5 = item.get納入通知書期情報リスト().get(リストサイズ４).get期表記();
            source.tsuki5 = item.get納入通知書期情報リスト().get(リストサイズ４).get月表記();
            source.nofuGaku5 = item.get納入通知書期情報リスト().get(リストサイズ４).get納付額表記();
            source.nokigen5 = item.get納入通知書期情報リスト().get(リストサイズ４).get納期限表記();
        }
        if (item.get納入通知書期情報リスト() != null
                && item.get納入通知書期情報リスト().size() >= リストサイズ６) {
            source.ki6 = item.get納入通知書期情報リスト().get(リストサイズ５).get期表記();
            source.tsuki6 = item.get納入通知書期情報リスト().get(リストサイズ５).get月表記();
            source.nofuGaku6 = item.get納入通知書期情報リスト().get(リストサイズ５).get納付額表記();
            source.nokigen6 = item.get納入通知書期情報リスト().get(リストサイズ５).get納期限表記();
        }
    }

    private void 編集後個人相関設定(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後仮算定通知書共通情報().get編集後個人() != null
                && item.get編集後仮算定通知書共通情報().get編集後個人().get名称() != null
                && item.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName() != null) {
            source.kaisanMeisaishoHihokenshaName = item.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName().value();
        }
        if (item.get編集後仮算定通知書共通情報().get編集後個人() != null
                && item.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名() != null) {
            source.kaisanMeisaishoSetaiNushiName = item.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名().value();
        }
        if (item.get編集後仮算定通知書共通情報().get編集後個人() != null
                && item.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード() != null) {
            source.keisanMeisaishoSetaiCode = item.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value();
        }
    }

    private void 前年度情報相関設定(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後仮算定通知書共通情報().get前年度情報() != null) {
            source.keisanMeisaishoNendo1 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
            source.keisanMeisaishoShotokuDankai = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度保険料段階();
            source.keisanMeisaishoNendo2 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
            source.keisanMeisaishoKingaku1 = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度保険料率().toString());
            source.kaisanMeisaishoTokuchoGokei = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額01()
                    .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02())
                    .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額03())
                    .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額04())
                    .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額05()).toString());

            source.keisanMeisaishoNendo3 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
            if (item.get編集後仮算定通知書共通情報().get前年度情報().get前年度確定介護保険料_年額() != null) {
                source.kaisanMeisaishoKingaku2 = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度確定介護保険料_年額().toString());
            }
            source.keisanMeisaishoNendo4 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
            if (item.get編集後仮算定通知書共通情報().get前年度情報().get前年度最終期普徴期別介護保険料() != null) {
                source.keisanMeisaishoKingaku3
                        = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度最終期普徴期別介護保険料().toString());
            }
        }
    }

}
