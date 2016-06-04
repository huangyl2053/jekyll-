/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書のEditorです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiNofushoEditor implements IKarisanteiNonyuTsuchishoCVSMultiNofushoEditor {

    private final KariSanteiNonyuTsuchiShoJoho item;
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
     * @param item {@link KariSanteiNonyuTsuchiShoJoho}
     * @param map Map<Integer, NonyuTsuchiShoKiJoho>
     */
    protected KarisanteiNonyuTsuchishoCVSMultiNofushoEditor(
            KariSanteiNonyuTsuchiShoJoho item,
            Map<Integer, NonyuTsuchiShoKiJoho> map) {
        this.item = item;
        this.map = map;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSMultiSource edit(KarisanteiNonyuTsuchishoCVSMultiSource source) {
        editSource(source);
        source.layoutBreakItem = 2;
        return source;
    }

    private KarisanteiNonyuTsuchishoCVSMultiSource editSource(KarisanteiNonyuTsuchishoCVSMultiSource source) {

        this.edit納付書1(source);

        this.edit納付書2(source);

        this.edit納付書3(source);

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSMultiSource edit納付書1(KarisanteiNonyuTsuchishoCVSMultiSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei = item.get納付書共通().get科目名称();
            source.detail_shimei = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei = item.get納付書共通().get被代納人氏名();
        }
        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(2)) {
            納入通知書期情報 = map.get(2);
        } else if (map.containsKey(INT_5)) {
            納入通知書期情報 = map.get(INT_5);
        } else if (map.containsKey(INT_8)) {
            納入通知書期情報 = map.get(INT_8);
        }

        if (納入通知書期情報 != null) {
            source.detail_shunoKikanBango1 = 納入通知書期情報.get収納機関番号表示用();
            source.detail_nofuBango = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango1 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun1 = 納入通知書期情報.get納付区分();
            source.detail_ocrId1 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode1 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo11 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo21 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu = 納入通知書期情報.get期表記();
            source.detail_gokeigaku = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd = 納入通知書期情報.get納期限表記();
            source.detail_honzei = 納入通知書期情報.get納付額表記();
            source.detail_ocr11 = 納入通知書期情報.getOcr().get(1);
            source.detail_ocr21 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen1 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo1 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun1 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo1 = HOSHI_4;
            source.detail_nendoNenbun = HOSHI_4;
            source.detail_kibetsu = HOSHI_2;
            source.detail_ryoshushoNenbun1 = HOSHI_4;
            source.detail_gokeigaku = HOSHI_13;
            source.detail_tsuchishoNo = HOSHI_16;
            source.detail_nokigenYmd = HOSHI_11;
            source.detail_hakkoYmd = HOSHI_11;
            source.detail_honzei = HOSHI_13;
            source.detail_ocr11 = HOSHI_28;
            source.detail_ocr21 = HOSHI_28;
            source.detail_cvsToriatsukaikigen1 = HOSHI_16;
        }

        source.detail_nokigenTitle = NOKIGEN;
        source.detail_tokusokuTesuryo = RString.EMPTY;
        source.detail_ocrCut1 = HANKAKU_X;
        source.detail_entaikin = RString.EMPTY;
        source.detail_biko11 = RString.EMPTY;
        source.detail_biko21 = RString.EMPTY;
        source.detail_funyuFukanBango1 = RString.EMPTY;

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSMultiSource edit納付書2(KarisanteiNonyuTsuchishoCVSMultiSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei = item.get納付書共通().get科目名称();
            source.detail_shimei = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_3)) {
            納入通知書期情報 = map.get(INT_3);
        } else if (map.containsKey(INT_6)) {
            納入通知書期情報 = map.get(INT_6);
        } else if (map.containsKey(INT_9)) {
            納入通知書期情報 = map.get(INT_9);
        }

        if (納入通知書期情報 != null) {
            source.detail_shunoKikanBango2 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.detail_nofuBango = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango2 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun2 = 納入通知書期情報.get納付区分();
            source.detail_ocrId2 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode2 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo12 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo22 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu = 納入通知書期情報.get期表記();
            source.detail_gokeigaku = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd = 納入通知書期情報.get納期限表記();
            source.detail_honzei = 納入通知書期情報.get納付額表記();
            source.detail_ocr12 = 納入通知書期情報.getOcr().get(1);
            source.detail_ocr22 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen2 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo2 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun2 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo2 = HOSHI_4;
            source.detail_nendoNenbun = HOSHI_4;
            source.detail_kibetsu = HOSHI_2;
            source.detail_ryoshushoNenbun2 = HOSHI_4;
            source.detail_gokeigaku = HOSHI_13;
            source.detail_tsuchishoNo = HOSHI_16;
            source.detail_nokigenYmd = HOSHI_11;
            source.detail_hakkoYmd = HOSHI_11;
            source.detail_honzei = HOSHI_13;
            source.detail_ocr12 = HOSHI_28;
            source.detail_ocr22 = HOSHI_28;
            source.detail_cvsToriatsukaikigen2 = HOSHI_16;
        }

        source.detail_nokigenTitle = NOKIGEN;
        source.detail_tokusokuTesuryo = RString.EMPTY;
        source.detail_ocrCut2 = HANKAKU_X;
        source.detail_entaikin = RString.EMPTY;
        source.detail_biko12 = RString.EMPTY;
        source.detail_biko22 = RString.EMPTY;
        source.detail_funyuFukanBango2 = RString.EMPTY;

        return source;
    }

    private KarisanteiNonyuTsuchishoCVSMultiSource edit納付書3(KarisanteiNonyuTsuchishoCVSMultiSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei = item.get納付書共通().get科目名称();
            source.detail_shimei = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei = item.get納付書共通().get被代納人氏名();
        }

        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (map.containsKey(INT_4)) {
            納入通知書期情報 = map.get(INT_4);
        } else if (map.containsKey(INT_7)) {
            納入通知書期情報 = map.get(INT_7);
        } else if (map.containsKey(INT_10)) {
            納入通知書期情報 = map.get(INT_10);
        }

        if (納入通知書期情報 != null) {
            source.detail_shunoKikanBango3 = 納入通知書期情報.get収納機関番号表示用();
            //TODO
            source.detail_nofuBango = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango3 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun3 = 納入通知書期情報.get納付区分();
            source.detail_ocrId3 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode3 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo13 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo23 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu = 納入通知書期情報.get期表記();
            source.detail_gokeigaku = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd = 納入通知書期情報.get納期限表記();
            source.detail_honzei = 納入通知書期情報.get納付額表記();
            source.detail_ocr13 = 納入通知書期情報.getOcr().get(1);
            source.detail_ocr23 = 納入通知書期情報.getOcr().get(2);

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen3 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo3 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun3 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo3 = HOSHI_4;
            source.detail_nendoNenbun = HOSHI_4;
            source.detail_kibetsu = HOSHI_2;
            source.detail_ryoshushoNenbun3 = HOSHI_4;
            source.detail_gokeigaku = HOSHI_13;
            source.detail_tsuchishoNo = HOSHI_16;
            source.detail_nokigenYmd = HOSHI_11;
            source.detail_hakkoYmd = HOSHI_11;
            source.detail_honzei = HOSHI_13;
            source.detail_ocr13 = HOSHI_28;
            source.detail_ocr23 = HOSHI_28;
            source.detail_cvsToriatsukaikigen3 = HOSHI_16;
        }

        source.detail_nokigenTitle = NOKIGEN;
        source.detail_tokusokuTesuryo = RString.EMPTY;
        source.detail_ocrCut3 = HANKAKU_X;
        source.detail_entaikin = RString.EMPTY;
        source.detail_biko13 = RString.EMPTY;
        source.detail_biko23 = RString.EMPTY;
        source.detail_funyuFukanBango3 = RString.EMPTY;

        return source;
    }
}
