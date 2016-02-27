/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulticover;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiCoverSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのEditorです。
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiCoverEditor implements IKarisanteiNonyuTsuchishoCVSMultiCoverEditor {

    private final KariSanteiNonyuTsuchiShoJoho item;
//    private final RString HOKENRYO_RITU = new RString("保険料率");
//    private final RString NENGAKU_HOKENRYO = new RString("年額保険料");
//    private final RString EN = new RString("円");
//    private final RString TSUGIKI_IKOU = new RString("次期以降");
//    private final RString SAISYUUKI_HOKENRYO_GAKU = new RString("最終期保険料額");
//    private final RString NOKIGEN = new RString("納期限");
//    private final RString HANKAKU_X = new RString("X");
//    private final RString HOSHI_2 = new RString("**");
//    private final RString HOSHI_4 = new RString("****");
//    private final RString HOSHI_11 = new RString("***********");
//    private final RString HOSHI_13 = new RString("*************");
//    private final RString HOSHI_16 = new RString("****************");
//    private final RString HOSHI_28 = new RString("****************************");

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
    protected KarisanteiNonyuTsuchishoCVSMultiCoverEditor(KariSanteiNonyuTsuchiShoJoho item) {
        this.item = item;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSMultiCoverSource edit(KarisanteiNonyuTsuchishoCVSMultiCoverSource source) {
        return editSource(source);
    }

    private KarisanteiNonyuTsuchishoCVSMultiCoverSource editSource(KarisanteiNonyuTsuchishoCVSMultiCoverSource source) {

        // 宛先
        source.hyojicodeName1 = item.get編集後仮算定通知書共通情報().get表示コード１名();
        source.hyojicodeName2 = item.get編集後仮算定通知書共通情報().get表示コード２名();
        source.hyojicodeName3 = item.get編集後仮算定通知書共通情報().get表示コード３名();
        source.titleNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
        source.hyojicode1 = item.get編集後仮算定通知書共通情報().get表示コード1();
        source.hyojicode2 = item.get編集後仮算定通知書共通情報().get表示コード２();
        source.hyojicode3 = item.get編集後仮算定通知書共通情報().get表示コード３();
        // TODO世帯コード
        source.tsuchishoNo = item.get編集後仮算定通知書共通情報().get通知書番号().value();
        // TODO金融機関コードタイトル
        // TODO口座種類タイトル
        // TODO口座番号タイトル
        // TODO金融機関コード
        // TODO口座種類
        // TODO口座番号
        // TODO金融機関名称タイトル
        // TODO金融機関名称
        // TODO口座名義人タイトル
        // TODO口座名義人
        source.noutsu_renban = new RString("*" + "TODO連番(6桁0埋め)" + "#");
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ１) {
            source.ki1 = item.get納入通知書期情報リスト().get(0).get期表記();
            source.tsuki1 = item.get納入通知書期情報リスト().get(0).get月表記();
            source.nofuGaku1 = item.get納入通知書期情報リスト().get(0).get納付額表記();
            source.nokigen1 = item.get納入通知書期情報リスト().get(0).get納期限表記();
        }
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ２) {
            source.ki2 = item.get納入通知書期情報リスト().get(リストサイズ１).get期表記();
            source.tsuki2 = item.get納入通知書期情報リスト().get(リストサイズ１).get月表記();
            source.nofuGaku2 = item.get納入通知書期情報リスト().get(リストサイズ１).get納付額表記();
            source.nokigen2 = item.get納入通知書期情報リスト().get(リストサイズ１).get納期限表記();
        }
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ３) {
            source.ki3 = item.get納入通知書期情報リスト().get(リストサイズ２).get期表記();
            source.tsuki3 = item.get納入通知書期情報リスト().get(リストサイズ２).get月表記();
            source.nofuGaku3 = item.get納入通知書期情報リスト().get(リストサイズ２).get納付額表記();
            source.nokigen3 = item.get納入通知書期情報リスト().get(リストサイズ２).get納期限表記();
        }
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ４) {
            source.ki4 = item.get納入通知書期情報リスト().get(リストサイズ３).get期表記();
            source.tsuki4 = item.get納入通知書期情報リスト().get(リストサイズ３).get月表記();
            source.nofuGaku4 = item.get納入通知書期情報リスト().get(リストサイズ３).get納付額表記();
            source.nokigen4 = item.get納入通知書期情報リスト().get(リストサイズ３).get納期限表記();
        }
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ５) {
            source.ki5 = item.get納入通知書期情報リスト().get(リストサイズ４).get期表記();
            source.tsuki5 = item.get納入通知書期情報リスト().get(リストサイズ４).get月表記();
            source.nofuGaku5 = item.get納入通知書期情報リスト().get(リストサイズ４).get納付額表記();
            source.nokigen5 = item.get納入通知書期情報リスト().get(リストサイズ４).get納期限表記();
        }
        if (!item.get納入通知書期情報リスト().isEmpty()
                && item.get納入通知書期情報リスト().size() >= リストサイズ６) {
            source.ki6 = item.get納入通知書期情報リスト().get(リストサイズ５).get期表記();
            source.tsuki6 = item.get納入通知書期情報リスト().get(リストサイズ５).get月表記();
            source.nofuGaku6 = item.get納入通知書期情報リスト().get(リストサイズ５).get納付額表記();
            source.nokigen6 = item.get納入通知書期情報リスト().get(リストサイズ５).get納期限表記();
        }

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.notsuRenban1 = new RString("TODO連番(6桁0埋め)");
        }
        source.pageCount1 = new RString("TODO連番　＋　\"-1\"　を設定する。");

        // 明細
        source.keisanMeisaishoNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
        // TODO計算明細書被保険者名
        // TODO計算明細書世帯主名
        // TODO計算明細書世帯コード
        source.keisanMeisaishoTsuchishoNo = item.get編集後仮算定通知書共通情報().get通知書番号().value();
        source.keisanMeisaishoNendo1 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
        source.keisanMeisaishoShotokuDankai = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度保険料段階();
        source.keisanMeisaishoGenmenGaku = new RString(item.get編集後仮算定通知書共通情報().get増減額().toString());
        source.keisanMeisaishoNendo2 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
        source.keisanMeisaishoKingaku1 = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度保険料率().toString());
        source.kaisanMeisaishoTokuchoGokei = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額01()
                .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02())
                .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02())
                .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02())
                .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02())
                .add(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度特徴期別金額02()).toString());

        return source;
    }

//    source.keisanMeisaishoKomokuTitle2 = this.HOKENRYO_RITU;
//        source.keisanMeisaishoYen1 = this.EN;
//        source.keisanMeisaishoNendo3 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
//        source.keisanMeisaishoKiTitle1 = new RString("第" + item.get出力期リスト().get(0).get期() + "期");
//        source.kaisanMeisaishoKingaku2 = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度確定介護保険料_年額().toString());
//        source.keisanMeisaishoKiNofuGaku1 = new RString(item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(0).get収入額().toString());
//        source.keisanMeisaishoKomokuTitle3 = this.NENGAKU_HOKENRYO;
//        source.keisanMeisaishoYen2 = this.EN;
//        source.keisanMeisaishoNendo4 = item.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度();
//        source.keisanMeisaishoKiTitle2 = this.TSUGIKI_IKOU;
//        source.keisanMeisaishoKingaku3 = new RString(item.get編集後仮算定通知書共通情報().get前年度情報().get前年度最終期普徴期別介護保険料().toString());
//        source.keisanMeisaishoKiNofuGaku2 = new RString(item.get編集後仮算定通知書共通情報().get普徴収入情報リスト().get(1).get収入額().toString());
//        source.keisanMeisaishoKomokuTitle4 = this.SAISYUUKI_HOKENRYO_GAKU;
//        source.keisanMeisaishoYen3 = this.EN;
//        source.keisanMeisaishoKarisanteiNendo = item.get編集後仮算定通知書共通情報().get調定年度().toDateString();
//        source.keisanMeisaishoKisu = new RString(String.valueOf(item.get編集後仮算定通知書共通情報().get普徴期数()));
//        source.keisanMeisaishoHokenryoGaku = new RString(item.get編集後仮算定通知書共通情報().get更正後().get更正後普徴期別金額合計().toString());
//        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
//            source.notsuRenban2 = new RString("TODO連番(6桁0埋め)");
//        }
//        source.pageCount2 = new RString("TODO連番　＋　\"-2\"　を設定する。");
//        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
//            source.renban = new RString("TODO連番(6桁0埋め)");
//        }
//        source.hokenshaName = new RString(item.get編集後仮算定通知書共通情報().get保険者名().toString());
//        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
//            source.notsuRenban3 = new RString("TODO連番(6桁0埋め)");
//        }
//        source.pageCount3 = new RString("TODO連番　＋　\"-3\"　を設定する。");
//
//        // 納付書
//        source.kamokumei = item.get納付書共通().get科目名称();
//        source.shunoKikanBango = item.get納入通知書期情報リスト().get(0).get収納機関番号表示用();
//        source.nofuBango = item.get納入通知書期情報リスト().get(0).get納付番号();
//        source.kakuninBango = item.get納入通知書期情報リスト().get(0).get確認番号();
//        source.nofuKubun = item.get納入通知書期情報リスト().get(0).get納付区分();
//        source.nokigenTitle = this.NOKIGEN;
//        source.tokusokuTesuryo = RString.EMPTY;
//        source.ocrId = item.get納入通知書期情報リスト().get(0).getOCRID();
//        source.ocrCut = this.HANKAKU_X;
//        source.entaikin = RString.EMPTY;
//        source.shimei = item.get納付書共通().get納付者氏名();
//        source.biko1 = RString.EMPTY;
//        source.biko2 = RString.EMPTY;
//        source.gimushaShimei = item.get納付書共通().get被代納人氏名();
//        source.barcodeCvsBarcode = item.get納入通知書期情報リスト().get(0).getバーコード情報();
//        source.cvsBarcodeNaiyo1 = item.get納入通知書期情報リスト().get(0).getバーコード情報上段();
//        source.cvsBarcodeNaiyo2 = item.get納入通知書期情報リスト().get(0).getバーコード情報下段();
//        source.funyuFukanBango = RString.EMPTY;
//
//        if (item.get納入通知書期情報リスト().isEmpty()) {
//
//            source.ryoshushoNendo = this.HOSHI_4;
//            source.nendoNenbun = this.HOSHI_4;
//            source.kibetsu = this.HOSHI_2;
//            source.ryoshushoNenbun = this.HOSHI_4;
//            source.tsuchishoNo = this.HOSHI_16;
//            source.nokigenYmd = this.HOSHI_11;
//            source.hakkoYmd = this.HOSHI_11;
//            source.honzei = this.HOSHI_13;
//            source.ocr1 = this.HOSHI_28;
//            source.ocr2 = this.HOSHI_28;
//            source.cvsToriatsukaikigen = this.HOSHI_16;
//        } else {
//            source.ryoshushoNendo = item.get納付書共通().get調定年度表記();
//            source.nendoNenbun = item.get納付書共通().get年度年分表記();
//            source.kibetsu = item.get納入通知書期情報リスト().get(0).get期表記();
//            source.ryoshushoNenbun = item.get納付書共通().get賦課年度表記();
//            source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
//            source.nokigenYmd = item.get納入通知書期情報リスト().get(0).get納期限表記();
//            source.hakkoYmd = item.get納付書共通().get発行日表記();
//            source.honzei = item.get納入通知書期情報リスト().get(0).get納付額表記();
//            source.ocr1 = item.get納入通知書期情報リスト().get(0).getOCR().get(1);
//            source.ocr2 = item.get納入通知書期情報リスト().get(0).getOCR().get(2);
//            source.cvsToriatsukaikigen = item.get納入通知書期情報リスト().get(0).getコンビニ支払期限().toDateString();
//        }
}
