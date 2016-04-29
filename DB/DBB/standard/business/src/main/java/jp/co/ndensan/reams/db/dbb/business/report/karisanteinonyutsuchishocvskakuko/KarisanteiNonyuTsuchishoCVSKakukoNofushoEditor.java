/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のEditorです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoNofushoEditor implements IKarisanteiNonyuTsuchishoCVSKakukoNofushoEditor {

    private final KariSanteiNonyuTsuchiShoJoho item;
    private final int index;
    private static final RString NOKIGEN = new RString("納期限");
    private static final RString HANKAKU_X = new RString("X");
    private static final RString HOSHI_2 = new RString("**");
    private static final RString HOSHI_4 = new RString("****");
    private static final RString HOSHI_11 = new RString("***********");
    private static final RString HOSHI_13 = new RString("*************");
    private static final RString HOSHI_16 = new RString("****************");
    private static final RString HOSHI_28 = new RString("****************************");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KariSanteiNonyuTsuchiShoJoho}
     * @param index index
     */
    protected KarisanteiNonyuTsuchishoCVSKakukoNofushoEditor(KariSanteiNonyuTsuchiShoJoho item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoSource edit(KarisanteiNonyuTsuchishoCVSKakukoSource source) {
        editSource(source);
        source.layout = KarisanteiNonyuTsuchishoCVSKakukoSource.Layouts.DBB100026_NonyuTsuchishoCVSMultiNofusho;
        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource editSource(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        this.edit納付書1(source);

        this.edit納付書2(source);

        this.edit納付書3(source);

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit納付書1(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        if (item.get納入通知書期情報リスト() != null) {
            if (item.get納入通知書期情報リスト().get(index) != null) {
                source.shunoKikanBango1 = item.get納入通知書期情報リスト().get(index).get収納機関番号表示用();
                //TODO
                source.nofuBango = item.get納入通知書期情報リスト().get(index).get納付番号();
                source.kakuninBango1 = item.get納入通知書期情報リスト().get(index).get確認番号();
                source.nofuKubun1 = item.get納入通知書期情報リスト().get(index).get納付区分();
                source.ocrId1 = item.get納入通知書期情報リスト().get(index).getOcrid();
                source.barcodeCvsBarcode1 = item.get納入通知書期情報リスト().get(index).getバーコード情報();
                source.cvsBarcodeNaiyo11 = item.get納入通知書期情報リスト().get(index).getバーコード情報上段();
                source.cvsBarcodeNaiyo21 = item.get納入通知書期情報リスト().get(index).getバーコード情報下段();
                source.kibetsu = item.get納入通知書期情報リスト().get(index).get期表記();
                source.gokeigaku = item.get納入通知書期情報リスト().get(index).get納付額表記();
                source.nokigenYmd = item.get納入通知書期情報リスト().get(index).get納期限表記();
                source.honzei = item.get納入通知書期情報リスト().get(index).get納付額表記();
                source.ocr11 = item.get納入通知書期情報リスト().get(index).getOcr().get(1);
                source.ocr21 = item.get納入通知書期情報リスト().get(index).getOcr().get(2);
            }
            if (item.get納入通知書期情報リスト().get(index).getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen1 = item.get納入通知書期情報リスト().get(index).getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.ryoshushoNendo1 = item.get納付書共通().get調定年度表記();
                source.nendoNenbun = item.get納付書共通().get年度年分表記();
                source.ryoshushoNenbun1 = item.get納付書共通().get賦課年度表記();
                source.hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo1 = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun1 = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr11 = HOSHI_28;
            source.ocr21 = HOSHI_28;
            source.cvsToriatsukaikigen1 = HOSHI_16;
        }

        source.nokigenTitle = NOKIGEN;
        source.tokusokuTesuryo = RString.EMPTY;
        source.ocrCut1 = HANKAKU_X;
        source.entaikin = RString.EMPTY;
        source.biko11 = RString.EMPTY;
        source.biko21 = RString.EMPTY;
        source.funyuFukanBango1 = RString.EMPTY;

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit納付書2(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        if (item.get納入通知書期情報リスト() != null) {
            if (item.get納入通知書期情報リスト().get(index + 1) != null) {
                source.shunoKikanBango2 = item.get納入通知書期情報リスト().get(index + 1).get収納機関番号表示用();
                //TODO
                source.nofuBango = item.get納入通知書期情報リスト().get(index + 1).get納付番号();
                source.kakuninBango2 = item.get納入通知書期情報リスト().get(index + 1).get確認番号();
                source.nofuKubun2 = item.get納入通知書期情報リスト().get(index + 1).get納付区分();
                source.ocrId2 = item.get納入通知書期情報リスト().get(index + 1).getOcrid();
                source.barcodeCvsBarcode2 = item.get納入通知書期情報リスト().get(index + 1).getバーコード情報();
                source.cvsBarcodeNaiyo12 = item.get納入通知書期情報リスト().get(index + 1).getバーコード情報上段();
                source.cvsBarcodeNaiyo22 = item.get納入通知書期情報リスト().get(index + 1).getバーコード情報下段();
                source.kibetsu = item.get納入通知書期情報リスト().get(index + 1).get期表記();
                source.gokeigaku = item.get納入通知書期情報リスト().get(index + 1).get納付額表記();
                source.nokigenYmd = item.get納入通知書期情報リスト().get(index + 1).get納期限表記();
                source.honzei = item.get納入通知書期情報リスト().get(index + 1).get納付額表記();
                source.ocr12 = item.get納入通知書期情報リスト().get(index + 1).getOcr().get(1);
                source.ocr22 = item.get納入通知書期情報リスト().get(index + 1).getOcr().get(2);
            }
            if (item.get納入通知書期情報リスト().get(index + 1).getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen2 = item.get納入通知書期情報リスト().get(index + 1).getコンビニ支払期限().toDateString();
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

    private KarisanteiNonyuTsuchishoCVSKakukoSource edit納付書3(KarisanteiNonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        if (item.get納入通知書期情報リスト() != null) {
            if (item.get納入通知書期情報リスト().get(index + 1) != null) {
                source.shunoKikanBango3 = item.get納入通知書期情報リスト().get(index + 2).get収納機関番号表示用();
                //TODO
                source.nofuBango = item.get納入通知書期情報リスト().get(index + 2).get納付番号();
                source.kakuninBango3 = item.get納入通知書期情報リスト().get(index + 2).get確認番号();
                source.nofuKubun3 = item.get納入通知書期情報リスト().get(index + 2).get納付区分();
                source.ocrId3 = item.get納入通知書期情報リスト().get(index + 2).getOcrid();
                source.barcodeCvsBarcode3 = item.get納入通知書期情報リスト().get(index + 2).getバーコード情報();
                source.cvsBarcodeNaiyo13 = item.get納入通知書期情報リスト().get(index + 2).getバーコード情報上段();
                source.cvsBarcodeNaiyo23 = item.get納入通知書期情報リスト().get(index + 2).getバーコード情報下段();
                source.kibetsu = item.get納入通知書期情報リスト().get(index + 2).get期表記();
                source.gokeigaku = item.get納入通知書期情報リスト().get(index + 2).get納付額表記();
                source.nokigenYmd = item.get納入通知書期情報リスト().get(index + 2).get納期限表記();
                source.honzei = item.get納入通知書期情報リスト().get(index + 2).get納付額表記();
                source.ocr13 = item.get納入通知書期情報リスト().get(index + 2).getOcr().get(1);
                source.ocr23 = item.get納入通知書期情報リスト().get(index + 2).getOcr().get(2);
            }
            if (item.get納入通知書期情報リスト().get(index + 2).getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen3 = item.get納入通知書期情報リスト().get(index + 2).getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.ryoshushoNendo3 = item.get納付書共通().get調定年度表記();
                source.nendoNenbun = item.get納付書共通().get年度年分表記();
                source.ryoshushoNenbun3 = item.get納付書共通().get賦課年度表記();
                source.hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo3 = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun3 = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr13 = HOSHI_28;
            source.ocr23 = HOSHI_28;
            source.cvsToriatsukaikigen3 = HOSHI_16;
        }

        source.nokigenTitle = NOKIGEN;
        source.tokusokuTesuryo = RString.EMPTY;
        source.ocrCut3 = HANKAKU_X;
        source.entaikin = RString.EMPTY;
        source.biko13 = RString.EMPTY;
        source.biko23 = RString.EMPTY;
        source.funyuFukanBango3 = RString.EMPTY;

        return source;
    }
}
