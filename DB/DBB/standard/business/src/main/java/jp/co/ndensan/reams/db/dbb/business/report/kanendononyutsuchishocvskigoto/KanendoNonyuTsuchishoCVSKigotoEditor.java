/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】のEditorです。
 *
 * @reamsid_L DBB-9110-190 huangh
 */
public class KanendoNonyuTsuchishoCVSKigotoEditor implements IKanendoNonyuTsuchishoCVSKigotoEditor {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
    private final int renban;

    private static final RString EN = new RString("円");
    private static final RString NOKIGEN = new RString("本状の納期限");
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
    private static final RString HOSHI_22 = new RString("**********************");
    private static final RString HOSHI_28 = new RString("****************************");

    private static final int リストサイズ１ = 1;

    private static final int INT_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HonSanteiNonyuTsuchiShoJoho}
     * @param ninshoshaSource NinshoshaSource
     * @param renban int
     */
    protected KanendoNonyuTsuchishoCVSKigotoEditor(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource,
            int renban) {
        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
        this.renban = renban;
    }

    @Override
    public KanendoNonyuTsuchishoCVSKigotoSource edit(KanendoNonyuTsuchishoCVSKigotoSource source) {
        editSource(source);
        return source;
    }

    private KanendoNonyuTsuchishoCVSKigotoSource editSource(KanendoNonyuTsuchishoCVSKigotoSource source) {

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

    private KanendoNonyuTsuchishoCVSKigotoSource edit宛先(KanendoNonyuTsuchishoCVSKigotoSource source) {

        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = item.get編集後本算定通知書共通情報();

        if (編集後本算定通知書共通情報 != null) {
            if (編集後本算定通知書共通情報.get表示コード() != null) {
                source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
                source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
                source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
                source.hyojicode1 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
                source.hyojicode2 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
                source.hyojicode3 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
            }
            if (編集後本算定通知書共通情報.get調定年度_年度なし() != null) {
                source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
            }
            if (編集後本算定通知書共通情報.get調定年度_年度あり() != null) {
                source.titleNendoBun = 編集後本算定通知書共通情報.get調定年度_年度あり().concat("分");
            }

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

        source.nitsuRenban = NotsuReportEditorUtil.get納通連番(renban);
        this.納入通知書期情報設定(source);

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban1 = new RString(renban);
        }
        source.pageCount1 = new RString(renban + "-1");

        return source;
    }

    private KanendoNonyuTsuchishoCVSKigotoSource edit明細(KanendoNonyuTsuchishoCVSKigotoSource source) {

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
            source.keisanMeisaishoNendoBun = item.get編集後本算定通知書共通情報().get調定年度_年度あり();
            source.keisanMeisaishoNendo3 = RStringUtil.convert半角to全角(item.get編集後本算定通知書共通情報().get調定年度_年度なし());
            if (item.get編集後本算定通知書共通情報().get納付済額_未到来期含む() != null) {
                source.keisanMeisaishoNofuZumiGaku = new RString(item.get編集後本算定通知書共通情報().get納付済額_未到来期含む().toString());
            }
            if (item.get編集後本算定通知書共通情報().get今後納付すべき額() != null) {
                source.keisanMeisaishoKongoNofuSubekiGaku = new RString(item.get編集後本算定通知書共通情報().get今後納付すべき額().toString());
            }

            this.更正後情報相関設定(source);

            source.keisanMeisaishoNofuGaku2 = RString.EMPTY;
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
        source.keisanMeisaishYen2 = RString.EMPTY;
        source.keisanMeisaishoKomokuTitle2 = RString.EMPTY;

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban2 = new RString(renban).padZeroToLeft(INT_6);
        }
        source.pageCount2 = new RString(renban + "-2");
        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.renban = new RString(String.valueOf(renban));
        }

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban3 = new RString(renban).padZeroToLeft(INT_6);
        }
        source.pageCount3 = new RString(renban + "-3");
        return source;
    }

    private void edit納付書(KanendoNonyuTsuchishoCVSKigotoSource source) {

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
                source.detail_tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.detail_tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr1 = HOSHI_22;
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

    private void edit雛形部品(KanendoNonyuTsuchishoCVSKigotoSource source) {

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

    private void editCompSofubutsuAtesaki(KanendoNonyuTsuchishoCVSKigotoSource source) {

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
            source.shimei14 = sofubutsuAtesakiSource.shimei2;
            source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
            source.shimeiText = sofubutsuAtesakiSource.shimeiText;
            source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
            source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
            source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
            source.shimei15 = sofubutsuAtesakiSource.shimei1;
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

    private void 納入通知書期情報設定(KanendoNonyuTsuchishoCVSKigotoSource source) {

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
    }

    private void 編集後個人相関設定(KanendoNonyuTsuchishoCVSKigotoSource source) {

        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get名称() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get名称().getName() != null) {
            source.kaisanMeisaishoHihokenshaName = item.get編集後本算定通知書共通情報().get編集後個人().get名称().getName().value();
        }
        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get世帯主名() != null) {
            source.kaisanMeisaishoHihokenshaName = item.get編集後本算定通知書共通情報().get編集後個人().get世帯主名().value();
        }
        if (item.get編集後本算定通知書共通情報().get編集後個人() != null
                && item.get編集後本算定通知書共通情報().get編集後個人().get世帯コード() != null) {
            source.keisanMeisaishoSetaiCode = item.get編集後本算定通知書共通情報().get編集後個人().get世帯コード().value();
        }
    }

    private void 更正後情報相関設定(KanendoNonyuTsuchishoCVSKigotoSource source) {

        if (item.get編集後本算定通知書共通情報().get更正後() != null) {

            source.keisanMeisaishoShotokuDankai = RStringUtil.convert半角to全角(item.get編集後本算定通知書共通情報().get更正後().get保険料段階());
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
            source.keisanMeisaishoTsukisu = item.get編集後本算定通知書共通情報().get更正後().get月数_ケ月();
            if (item.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額() != null) {
                source.keisanMeisaishoCalHokenryoGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get減免前保険料_年額().toString());
            }
            if (item.get編集後本算定通知書共通情報().get更正後().get確定保険料_年額() != null) {
                source.keisanMeisaishoHokenryoGaku = new RString(item.get編集後本算定通知書共通情報().get更正後().get確定保険料_年額().toString());
            }
        }
    }
}
