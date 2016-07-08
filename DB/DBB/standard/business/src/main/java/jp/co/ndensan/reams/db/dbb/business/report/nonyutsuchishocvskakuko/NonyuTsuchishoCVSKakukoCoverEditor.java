/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】CoverのEditorです。
 *
 * @reamsid_L DBB-9110-120 huangh
 */
public class NonyuTsuchishoCVSKakukoCoverEditor implements INonyuTsuchishoCVSKakukoCoverEditor {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
    private final int renban;

    private static final RString EN = new RString("円");
    private static final RString TSUGIKI_IKOU = new RString("次期以降");
    private static final RString NOKIGEN = new RString("納期限");
    private static final RString BANK_CODE_TITLE = new RString("金融機関コード");
    private static final RString KOZA_SHURUI_TITLE = new RString("種別");
    private static final RString BANK_NAME_TITLE = new RString("金融機関");
    private static final RString KOZA_MEIGININ_TITLE = new RString("`名義人");
    private static final RString HANKAKU_X = new RString("X");
    private static final RString HOSHI_2 = new RString("**");
    private static final RString HOSHI_4 = new RString("****");
    private static final RString HOSHI_11 = new RString("***********");
    private static final RString HOSHI_13 = new RString("*************");
    private static final RString HOSHI_16 = new RString("****************");
    private static final RString HOSHI_28 = new RString("****************************");

    private static final int リストサイズ１ = 1;
    private static final int リストサイズ２ = 2;
    private static final int リストサイズ３ = 3;
    private static final int リストサイズ４ = 4;
    private static final int リストサイズ５ = 5;
    private static final int リストサイズ６ = 6;
    private static final int リストサイズ７ = 7;
    private static final int リストサイズ８ = 8;
    private static final int リストサイズ９ = 9;
    private static final int リストサイズ１０ = 10;

    private static final int INT_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KariSanteiNonyuTsuchiShoJoho}
     * @param ninshoshaSource NinshoshaSource
     * @param renban int
     */
    protected NonyuTsuchishoCVSKakukoCoverEditor(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource,
            int renban) {
        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
        this.renban = renban;
    }

    @Override
    public NonyuTsuchishoCVSKakukoSource edit(NonyuTsuchishoCVSKakukoSource source) {
        editSource(source);
        source.layoutBreakItem = 1;
        return source;
    }

    private NonyuTsuchishoCVSKakukoSource editSource(NonyuTsuchishoCVSKakukoSource source) {

        this.edit宛先(source);

        if (item.get本算定納入通知書制御情報() != null
                && item.get本算定納入通知書制御情報().get納入通知書制御情報() != null
                && !HyojiUmu.表示しない.equals(item.get本算定納入通知書制御情報().get納入通知書制御情報().getコンビニ明細書表示())) {
            this.edit明細(source);
        }

        this.edit納付書(source);

        this.edit雛形部品(source);

        this.editCompSofubutsuAtesaki(source);

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit宛先(NonyuTsuchishoCVSKakukoSource source) {

        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = item.get編集後本算定通知書共通情報();

        if (編集後本算定通知書共通情報 != null) {
            source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
            source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
            source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
            if (編集後本算定通知書共通情報.get調定年度() != null) {
                source.titleNendo = 編集後本算定通知書共通情報.get調定年度_年度なし();
            }
            source.hyojicode1 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
            source.hyojicode2 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
            source.hyojicode3 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
            if (編集後本算定通知書共通情報.get編集後個人() != null
                    && 編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
            }
            if (編集後本算定通知書共通情報.get通知書番号() != null) {
                source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
            }
            if (編集後本算定通知書共通情報.get編集後口座() != null) {
                source.bankCodeTitle = 編集後本算定通知書共通情報.get編集後口座().isPresent() ? BANK_CODE_TITLE : RString.EMPTY;
                source.kozaShuruiTitle = 編集後本算定通知書共通情報.get編集後口座().isPresent() ? KOZA_SHURUI_TITLE : RString.EMPTY;
                source.kozaNoTitle = 編集後本算定通知書共通情報.get編集後口座().get番号名称();
                source.bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
                source.kozaShurui = 編集後本算定通知書共通情報.get編集後口座().get口座種別略称();
                source.kozaNo = 編集後本算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
                source.bankNameTitle = 編集後本算定通知書共通情報.get編集後口座().isPresent() ? BANK_NAME_TITLE : RString.EMPTY;
                source.bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
                source.kozaMeigininTitle = 編集後本算定通知書共通情報.get編集後口座().isPresent() ? KOZA_MEIGININ_TITLE : RString.EMPTY;
                source.kozaMeiginin = 編集後本算定通知書共通情報.get編集後口座().get口座名義人優先();
            }
        }

        source.notsuRenban = NotsuReportEditorUtil.get納通連番(renban);

        this.納入通知書期情報設定(source);

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban1 = new RString(renban);
        }
        source.pageCount1 = new RString(renban + "-1");

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit明細(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後本算定通知書共通情報() != null) {

            this.編集後個人相関設定(source);

            if (item.get編集後本算定通知書共通情報().get通知書番号() != null) {
                source.keisanMeisaishoTsuchishoNo = item.get編集後本算定通知書共通情報().get通知書番号().value();
            }
            if (item.get編集後本算定通知書共通情報().get更正後() != null
                    && item.get編集後本算定通知書共通情報().get更正後().get減免額() != null) {
                source.keisanMeisaishoGenmenGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get減免額().toString());
            }
            source.keisanMeisaishoNendo = item.get編集後本算定通知書共通情報().get調定年度_年度なし();
            source.keisanMeisaishoNendo3 = item.get編集後本算定通知書共通情報().get調定年度_年度なし();

            this.更正後情報相関設定(source);

            if (item.get編集後本算定通知書共通情報().get普徴収入情報リスト() != null
                    && item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(1) != null
                    && item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(1).get収入額() != null) {
                source.keisanMeisaishoNofuGaku2
                        = new RString(item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(1).get収入額().toString());
            }
            if (item.get編集後本算定通知書共通情報().get保険者名() != null) {
                source.hokenshaName = new RString(item.get編集後本算定通知書共通情報().get保険者名().toString());
            }
            if (item.get編集後本算定通知書共通情報().get普徴収入情報リスト() != null
                    && item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(0) != null
                    && item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(0).get収入額() != null) {
                source.keisanMeisaishoNofuGaku1 = new RString(item.get編集後本算定通知書共通情報().get普徴収入情報リスト().get(0).get収入額().toString());
            }
        }

        source.keisanMeisaishYen1 = EN;
        if (item.get出力期リスト() != null
                && item.get出力期リスト().get(0) != null) {
            source.keisanMeisaishoKomokuTitle1 = new RString("第" + item.get出力期リスト().get(0).get期() + "期");
        } else {
            source.keisanMeisaishoKomokuTitle1 = new RString("第　期");
        }

        source.keisanMeisaishYen2 = EN;
        source.keisanMeisaishoKomokuTitle2 = TSUGIKI_IKOU;

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban2 = new RString(renban).padZeroToLeft(INT_6);
        }
        source.pageCount2 = new RString(renban + "-2");
        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.renban = new RString(renban).padZeroToLeft(INT_6);
        }

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban3 = new RString(renban).padZeroToLeft(INT_6);
        }
        source.pageCount3 = new RString(renban + "-3");
        return source;
    }

    private void edit納付書(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        NonyuTsuchiShoKiJoho 印字位置1の納付書 = null;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.getコンビニカット印字位置() == 1) {
                印字位置1の納付書 = 納入通知書期情報;
            }
        }

        if (印字位置1の納付書 != null) {
            source.shunoKikanBango = 印字位置1の納付書.get収納機関番号表示用();
            //TODO
            source.nofuBango = 印字位置1の納付書.get納付番号();
            source.kakuninBango = 印字位置1の納付書.get確認番号();
            source.nofuKubun = 印字位置1の納付書.get納付区分();
            source.ocrId1 = 印字位置1の納付書.getOcrid();
            source.barcodeCvsBarcode1 = 印字位置1の納付書.getバーコード情報();
            source.cvsBarcodeNaiyo3 = 印字位置1の納付書.getバーコード情報上段();
            source.cvsBarcodeNaiyo4 = 印字位置1の納付書.getバーコード情報下段();
            source.kibetsu = 印字位置1の納付書.get期表記();
            source.gokeigaku = 印字位置1の納付書.get納付額表記();
            source.nokigenYmd = 印字位置1の納付書.get納期限表記();
            source.honzei = 印字位置1の納付書.get納付額表記();
            source.ocr1 = 印字位置1の納付書.getOcr().get(1);
            source.ocr2 = 印字位置1の納付書.getOcr().get(2);
            if (印字位置1の納付書.getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen = 印字位置1の納付書.getコンビニ支払期限().toDateString();
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

    private void edit雛形部品(NonyuTsuchishoCVSKakukoSource source) {

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

    private void editCompSofubutsuAtesaki(NonyuTsuchishoCVSKakukoSource source) {

        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;

        if (item.get編集後本算定通知書共通情報() != null
                && item.get編集後本算定通知書共通情報().get編集後宛先() != null) {
            kaigoSofubutsuAtesakiSource = item.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource();
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
            source.shimei15 = sofubutsuAtesakiSource.shimei2;
            source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
            source.shimeiText = sofubutsuAtesakiSource.shimeiText;
            source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
            source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
            source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
            source.shimei14 = sofubutsuAtesakiSource.shimei1;
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

    private void 納入通知書期情報設定(NonyuTsuchishoCVSKakukoSource source) {

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        if (納入通知書期情報リスト == null) {
            return;
        }

        if (納入通知書期情報リスト.size() >= リストサイズ１) {
            source.ki1 = 納入通知書期情報リスト.get(0).get期表記();
            source.tsuki1 = 納入通知書期情報リスト.get(0).get月表記();
            source.nofuGaku1 = 納入通知書期情報リスト.get(0).get納付額表記();
            source.nokigen1 = 納入通知書期情報リスト.get(0).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ２) {
            source.ki2 = 納入通知書期情報リスト.get(リストサイズ１).get期表記();
            source.tsuki2 = 納入通知書期情報リスト.get(リストサイズ１).get月表記();
            source.nofuGaku2 = 納入通知書期情報リスト.get(リストサイズ１).get納付額表記();
            source.nokigen2 = 納入通知書期情報リスト.get(リストサイズ１).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ３) {
            source.ki3 = 納入通知書期情報リスト.get(リストサイズ２).get期表記();
            source.tsuki3 = 納入通知書期情報リスト.get(リストサイズ２).get月表記();
            source.nofuGaku3 = 納入通知書期情報リスト.get(リストサイズ２).get納付額表記();
            source.nokigen3 = 納入通知書期情報リスト.get(リストサイズ２).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ４) {
            source.ki4 = 納入通知書期情報リスト.get(リストサイズ３).get期表記();
            source.tsuki4 = 納入通知書期情報リスト.get(リストサイズ３).get月表記();
            source.nofuGaku4 = 納入通知書期情報リスト.get(リストサイズ３).get納付額表記();
            source.nokigen4 = 納入通知書期情報リスト.get(リストサイズ３).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ５) {
            source.ki5 = 納入通知書期情報リスト.get(リストサイズ４).get期表記();
            source.tsuki5 = 納入通知書期情報リスト.get(リストサイズ４).get月表記();
            source.nofuGaku5 = 納入通知書期情報リスト.get(リストサイズ４).get納付額表記();
            source.nokigen5 = 納入通知書期情報リスト.get(リストサイズ４).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ６) {
            source.ki6 = 納入通知書期情報リスト.get(リストサイズ５).get期表記();
            source.tsuki6 = 納入通知書期情報リスト.get(リストサイズ５).get月表記();
            source.nofuGaku6 = 納入通知書期情報リスト.get(リストサイズ５).get納付額表記();
            source.nokigen6 = 納入通知書期情報リスト.get(リストサイズ５).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ７) {
            source.ki7 = 納入通知書期情報リスト.get(リストサイズ６).get期表記();
            source.tsuki7 = 納入通知書期情報リスト.get(リストサイズ６).get月表記();
            source.nofuGaku7 = 納入通知書期情報リスト.get(リストサイズ６).get納付額表記();
            source.nokigen7 = 納入通知書期情報リスト.get(リストサイズ６).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ８) {
            source.ki8 = 納入通知書期情報リスト.get(リストサイズ７).get期表記();
            source.tsuki8 = 納入通知書期情報リスト.get(リストサイズ７).get月表記();
            source.nofuGaku8 = 納入通知書期情報リスト.get(リストサイズ７).get納付額表記();
            source.nokigen8 = 納入通知書期情報リスト.get(リストサイズ７).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ９) {
            source.ki9 = 納入通知書期情報リスト.get(リストサイズ８).get期表記();
            source.tsuki9 = 納入通知書期情報リスト.get(リストサイズ８).get月表記();
            source.nofuGaku9 = 納入通知書期情報リスト.get(リストサイズ８).get納付額表記();
            source.nokigen9 = 納入通知書期情報リスト.get(リストサイズ８).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= リストサイズ１０) {
            source.ki10 = 納入通知書期情報リスト.get(リストサイズ９).get期表記();
            source.tsuki10 = 納入通知書期情報リスト.get(リストサイズ９).get月表記();
            source.nofuGaku10 = 納入通知書期情報リスト.get(リストサイズ９).get納付額表記();
            source.nokigen10 = 納入通知書期情報リスト.get(リストサイズ９).get納期限表記();
        }
    }

    private void 編集後個人相関設定(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get名称() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get名称().getName() != null) {
            source.kaisanMeisaishoHihokenshaName = item.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().value();
        }
        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get世帯主名() != null) {
            source.kaisanMeisaishoHihokenshaName1 = item.get編集後本算定通知書共通情報().get編集後個人().get世帯主名().value();
        }
        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get世帯コード() != null) {
            source.keisanMeisaishoSetaiCode = item.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().value();
        }
    }

    private void 更正後情報相関設定(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get編集後本算定通知書共通情報().get更正後() != null) {

            source.keisanMeisaishoShotokuDankai = item.get編集後本算定通知書共通情報().get更正後().get保険料段階();
            if (item.get編集後本算定通知書共通情報().get更正後().get保険料率() != null) {
                source.keisanMeisaishoHokenryoRitsu = new RString(item.get編集後本算定通知書共通情報().get更正後().get保険料率().toString());
            }
            if (item.get編集後本算定通知書共通情報().get更正後().get特別徴収額合計() != null) {
                source.kaisanMeisaishoTokuchoGokeiGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get特別徴収額合計().toString());
            }
            source.keisanMeisaishoKikanKaishi = item.get編集後本算定通知書共通情報().get更正後().get期間_自();
            if (item.get編集後本算定通知書共通情報().get更正後().get普通徴収額合計() != null) {
                source.kaisanMeisaishoFuchoGokeiGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get普通徴収額合計().toString());
            }
            source.keisanMeisaishoKikanShuryo = item.get編集後本算定通知書共通情報().get更正後().get期間_至();
            source.keisanMeisaishoTsukisu = new RString(item.get編集後本算定通知書共通情報().get更正後().get月数());
            if (item.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額() != null) {
                source.keisanMeisaishoHokenryoGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額().toString());
            }
        }
    }
}
