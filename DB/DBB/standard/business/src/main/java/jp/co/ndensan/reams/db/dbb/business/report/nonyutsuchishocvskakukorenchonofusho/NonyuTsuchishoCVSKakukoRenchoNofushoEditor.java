/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のEditorです。
 *
 * @reamsid_L DBB-9110-120 huangh
 */
public class NonyuTsuchishoCVSKakukoRenchoNofushoEditor implements INonyuTsuchishoCVSKakukoRenchoNofushoEditor {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final Map<Integer, NonyuTsuchiShoKiJoho> map;

    private static final RString NOKIGEN = new RString("納期限");
    private static final RString HANKAKU_X = new RString("X");
    private static final RString HOSHI_2 = new RString("**");
    private static final RString HOSHI_4 = new RString("****");
    private static final RString HOSHI_11 = new RString("***********");
    private static final RString HOSHI_13 = new RString("*************");
    private static final RString HOSHI_16 = new RString("****************");
    private static final RString HOSHI_28 = new RString("****************************");

    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HonSanteiNonyuTsuchiShoJoho}
     * @param map Map<Integer, NonyuTsuchiShoKiJoho>
     */
    public NonyuTsuchishoCVSKakukoRenchoNofushoEditor(
            HonSanteiNonyuTsuchiShoJoho item,
            Map<Integer, NonyuTsuchiShoKiJoho> map) {
        this.item = item;
        this.map = map;
    }

    @Override
    public NonyuTsuchishoCVSKakukoSource edit(NonyuTsuchishoCVSKakukoSource source) {
        editSource(source);
        source.layout = NonyuTsuchishoCVSKakukoSource.Layouts.DBB100027_NonyuTsuchishoCVSMultiRenchoNofusho;
        return source;
    }

    private NonyuTsuchishoCVSKakukoSource editSource(NonyuTsuchishoCVSKakukoSource source) {

        this.edit納付書1(source);

        this.edit納付書2(source);

        this.edit納付書3(source);

        this.edit納付書4(source);

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit納付書1(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_3)) {
            納入通知書期情報 = map.get(INT_3);
        } else if (map.containsKey(INT_7)) {
            納入通知書期情報 = map.get(INT_7);
        }

        if (納入通知書期情報 != null) {
            source.shunoKikanBango1 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.nofuBango = 納入通知書期情報.get納付番号();
            source.kakuninBango1 = 納入通知書期情報.get確認番号();
            source.nofuKubun1 = 納入通知書期情報.get納付区分();
            source.ocrId1 = 納入通知書期情報.getOcrid();
            source.barcodeCvsBarcode1 = 納入通知書期情報.getバーコード情報();
            source.cvsBarcodeNaiyo11 = 納入通知書期情報.getバーコード情報上段();
            source.cvsBarcodeNaiyo21 = 納入通知書期情報.getバーコード情報下段();
            source.kibetsu = 納入通知書期情報.get期表記();
            source.gokeigaku = 納入通知書期情報.get納付額表記();
            source.nokigenYmd = 納入通知書期情報.get納期限表記();
            source.honzei = 納入通知書期情報.get納付額表記();
            source.ocr11 = 納入通知書期情報.getOcr().get(1);
            source.ocr21 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen1 = 納入通知書期情報.getコンビニ支払期限().toDateString();
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

    private NonyuTsuchishoCVSKakukoSource edit納付書2(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_4)) {
            納入通知書期情報 = map.get(INT_4);
        } else if (map.containsKey(INT_8)) {
            納入通知書期情報 = map.get(INT_8);
        }

        if (納入通知書期情報 != null) {
            source.shunoKikanBango2 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.nofuBango = 納入通知書期情報.get納付番号();
            source.kakuninBango2 = 納入通知書期情報.get確認番号();
            source.nofuKubun2 = 納入通知書期情報.get納付区分();
            source.ocrId2 = 納入通知書期情報.getOcrid();
            source.barcodeCvsBarcode2 = 納入通知書期情報.getバーコード情報();
            source.cvsBarcodeNaiyo12 = 納入通知書期情報.getバーコード情報上段();
            source.cvsBarcodeNaiyo22 = 納入通知書期情報.getバーコード情報下段();
            source.kibetsu = 納入通知書期情報.get期表記();
            source.gokeigaku = 納入通知書期情報.get納付額表記();
            source.nokigenYmd = 納入通知書期情報.get納期限表記();
            source.honzei = 納入通知書期情報.get納付額表記();
            source.ocr12 = 納入通知書期情報.getOcr().get(1);
            source.ocr22 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen2 = 納入通知書期情報.getコンビニ支払期限().toDateString();
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

    private NonyuTsuchishoCVSKakukoSource edit納付書3(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_5)) {
            納入通知書期情報 = map.get(INT_5);
        } else if (map.containsKey(INT_9)) {
            納入通知書期情報 = map.get(INT_9);
        }

        if (納入通知書期情報 != null) {
            source.shunoKikanBango3 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.nofuBango = 納入通知書期情報.get納付番号();
            source.kakuninBango3 = 納入通知書期情報.get確認番号();
            source.nofuKubun3 = 納入通知書期情報.get納付区分();
            source.ocrId3 = 納入通知書期情報.getOcrid();
            source.barcodeCvsBarcode3 = 納入通知書期情報.getバーコード情報();
            source.cvsBarcodeNaiyo13 = 納入通知書期情報.getバーコード情報上段();
            source.cvsBarcodeNaiyo23 = 納入通知書期情報.getバーコード情報下段();
            source.kibetsu = 納入通知書期情報.get期表記();
            source.gokeigaku = 納入通知書期情報.get納付額表記();
            source.nokigenYmd = 納入通知書期情報.get納期限表記();
            source.honzei = 納入通知書期情報.get納付額表記();
            source.ocr13 = 納入通知書期情報.getOcr().get(1);
            source.ocr23 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen3 = 納入通知書期情報.getコンビニ支払期限().toDateString();
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

    private NonyuTsuchishoCVSKakukoSource edit納付書4(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.kamokumei = item.get納付書共通().get科目名称();
            source.shimei = item.get納付書共通().get納付者氏名();
            source.gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_6)) {
            納入通知書期情報 = map.get(INT_6);
        } else if (map.containsKey(INT_10)) {
            納入通知書期情報 = map.get(INT_10);
        }

        if (納入通知書期情報 != null) {
            source.shunoKikanBango4 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.nofuBango = 納入通知書期情報.get納付番号();
            source.kakuninBango4 = 納入通知書期情報.get確認番号();
            source.nofuKubun4 = 納入通知書期情報.get納付区分();
            source.ocrId4 = 納入通知書期情報.getOcrid();
            source.barcodeCvsBarcode4 = 納入通知書期情報.getバーコード情報();
            source.cvsBarcodeNaiyo14 = 納入通知書期情報.getバーコード情報上段();
            source.cvsBarcodeNaiyo24 = 納入通知書期情報.getバーコード情報下段();
            source.kibetsu = 納入通知書期情報.get期表記();
            source.gokeigaku = 納入通知書期情報.get納付額表記();
            source.nokigenYmd = 納入通知書期情報.get納期限表記();
            source.honzei = 納入通知書期情報.get納付額表記();
            source.ocr14 = 納入通知書期情報.getOcr().get(1);
            source.ocr24 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.cvsToriatsukaikigen4 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.ryoshushoNendo4 = item.get納付書共通().get調定年度表記();
                source.nendoNenbun = item.get納付書共通().get年度年分表記();
                source.ryoshushoNenbun4 = item.get納付書共通().get賦課年度表記();
                source.hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.ryoshushoNendo4 = HOSHI_4;
            source.nendoNenbun = HOSHI_4;
            source.kibetsu = HOSHI_2;
            source.ryoshushoNenbun4 = HOSHI_4;
            source.gokeigaku = HOSHI_13;
            source.tsuchishoNo = HOSHI_16;
            source.nokigenYmd = HOSHI_11;
            source.hakkoYmd = HOSHI_11;
            source.honzei = HOSHI_13;
            source.ocr14 = HOSHI_28;
            source.ocr24 = HOSHI_28;
            source.cvsToriatsukaikigen4 = HOSHI_16;
        }

        source.nokigenTitle = NOKIGEN;
        source.tokusokuTesuryo = RString.EMPTY;
        source.ocrCut4 = HANKAKU_X;
        source.entaikin = RString.EMPTY;
        source.biko14 = RString.EMPTY;
        source.biko24 = RString.EMPTY;
        source.funyuFukanBango4 = RString.EMPTY;

        return source;
    }
}
