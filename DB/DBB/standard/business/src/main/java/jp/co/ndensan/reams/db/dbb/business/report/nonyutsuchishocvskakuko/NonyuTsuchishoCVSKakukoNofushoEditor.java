/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のEditorです。
 *
 * @reamsid_L DBB-9110-120 huangh
 */
public class NonyuTsuchishoCVSKakukoNofushoEditor implements INonyuTsuchishoCVSKakukoNofushoEditor {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final Map<Integer, NonyuTsuchiShoKiJoho> map;

    private static final RString NOKIGEN = new RString("納期限");
    private static final RString HANKAKU_X = new RString("X");
    private static final RString HOSHI_2 = new RString("**");
    private static final RString HOSHI_4 = new RString("****");
    private static final RString HOSHI_11 = new RString("***********");
    private static final RString HOSHI_13 = new RString("*************");
    private static final RString HOSHI_16 = new RString("****************");
    private static final RString HOSHI_22 = new RString("**********************");
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
    public NonyuTsuchishoCVSKakukoNofushoEditor(
            HonSanteiNonyuTsuchiShoJoho item,
            Map<Integer, NonyuTsuchiShoKiJoho> map) {
        this.item = item;
        this.map = map;
    }

    @Override
    public NonyuTsuchishoCVSKakukoSource edit(NonyuTsuchishoCVSKakukoSource source) {
        editSource(source);
        source.layoutBreakItem = 2;
        return source;
    }

    private NonyuTsuchishoCVSKakukoSource editSource(NonyuTsuchishoCVSKakukoSource source) {

        this.editレイヤ１(source);

        this.edit納付書1(source);

        this.edit納付書2(source);

        this.edit納付書3(source);

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource editレイヤ１(NonyuTsuchishoCVSKakukoSource source) {

        if (ShoriKubun.バッチ.equals(item.get処理区分())) {
            source.detail_notsuRenban1 = new RString(item.get連番()).padZeroToLeft(INT_6);
            source.detail_notsuRenban2 = new RString(item.get連番()).padZeroToLeft(INT_6);
            source.detail_notsuRenban3 = new RString(item.get連番()).padZeroToLeft(INT_6);
            source.detail_renban = new RString(item.get連番());
        }

        if (item.get編集後本算定通知書共通情報() != null) {
            source.detail_hokenshaName = item.get編集後本算定通知書共通情報().get保険者名();
        }

        if (map.containsKey(2)
                || map.containsKey(INT_3)
                || map.containsKey(INT_4)) {
            source.detail_pageCount1 = new RString(item.get連番()).concat("-4");
            source.detail_pageCount2 = new RString(item.get連番()).concat("-5");
            source.detail_pageCount3 = new RString(item.get連番()).concat("-6");
        } else if (map.containsKey(INT_5)
                || map.containsKey(INT_6)
                || map.containsKey(INT_7)) {
            source.detail_pageCount1 = new RString(item.get連番()).concat("-7");
            source.detail_pageCount2 = new RString(item.get連番()).concat("-8");
            source.detail_pageCount3 = new RString(item.get連番()).concat("-9");
        } else if (map.containsKey(INT_8)
                || map.containsKey(INT_9)
                || map.containsKey(INT_10)) {
            source.detail_pageCount1 = new RString(item.get連番()).concat("-10");
            source.detail_pageCount2 = new RString(item.get連番()).concat("-11");
            source.detail_pageCount3 = new RString(item.get連番()).concat("-12");
        }

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit納付書1(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei1 = item.get納付書共通().get科目名称();
            source.detail_shimei1 = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei1 = item.get納付書共通().get被代納人氏名();
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
            source.detail_nofuBango1 = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango1 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun1 = 納入通知書期情報.get納付区分();
            source.detail_ocrId1 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode1 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo11 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo21 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu1 = 納入通知書期情報.get期表記();
            source.detail_gokeigaku1 = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd1 = 納入通知書期情報.get納期限表記();
            source.detail_honzei1 = 納入通知書期情報.get納付額表記();
            if (納入通知書期情報.getOcr() != null) {
                source.detail_ocr11 = 納入通知書期情報.getOcr().get(1);
                source.detail_ocr21 = 納入通知書期情報.getOcr().get(2);
            }

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen1 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo1 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun1 = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun1 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd1 = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo1 = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo1 = HOSHI_4;
            source.detail_nendoNenbun1 = HOSHI_4;
            source.detail_kibetsu1 = HOSHI_2;
            source.detail_ryoshushoNenbun1 = HOSHI_4;
            source.detail_gokeigaku1 = HOSHI_13;
            source.detail_tsuchishoNo1 = HOSHI_16;
            source.detail_nokigenYmd1 = HOSHI_11;
            source.detail_hakkoYmd1 = HOSHI_11;
            source.detail_honzei1 = HOSHI_13;
            source.detail_ocr11 = HOSHI_22;
            source.detail_ocr21 = HOSHI_28;
            source.detail_cvsToriatsukaikigen1 = HOSHI_16;
        }

        source.detail_nokigenTitle1 = NOKIGEN;
        source.detail_tokusokuTesuryo1 = RString.EMPTY;
        source.detail_ocrCut1 = HANKAKU_X;
        source.detail_entaikin1 = RString.EMPTY;
        source.detail_biko11 = RString.EMPTY;
        source.detail_biko21 = RString.EMPTY;
        source.detail_funyuFukanBango1 = RString.EMPTY;

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit納付書2(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei2 = item.get納付書共通().get科目名称();
            source.detail_shimei2 = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei2 = item.get納付書共通().get被代納人氏名();
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
            source.detail_nofuBango2 = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango2 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun2 = 納入通知書期情報.get納付区分();
            source.detail_ocrId2 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode2 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo12 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo22 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu2 = 納入通知書期情報.get期表記();
            source.detail_gokeigaku2 = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd2 = 納入通知書期情報.get納期限表記();
            source.detail_honzei2 = 納入通知書期情報.get納付額表記();
            if (納入通知書期情報.getOcr() != null) {
                source.detail_ocr12 = 納入通知書期情報.getOcr().get(1);
                source.detail_ocr22 = 納入通知書期情報.getOcr().get(2);
            }

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen2 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo2 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun2 = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun2 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd2 = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo2 = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo2 = HOSHI_4;
            source.detail_nendoNenbun2 = HOSHI_4;
            source.detail_kibetsu2 = HOSHI_2;
            source.detail_ryoshushoNenbun2 = HOSHI_4;
            source.detail_gokeigaku2 = HOSHI_13;
            source.detail_tsuchishoNo2 = HOSHI_16;
            source.detail_nokigenYmd2 = HOSHI_11;
            source.detail_hakkoYmd2 = HOSHI_11;
            source.detail_honzei2 = HOSHI_13;
            source.detail_ocr12 = HOSHI_22;
            source.detail_ocr22 = HOSHI_28;
            source.detail_cvsToriatsukaikigen2 = HOSHI_16;
        }

        source.detail_nokigenTitle2 = NOKIGEN;
        source.detail_tokusokuTesuryo2 = RString.EMPTY;
        source.detail_ocrCut2 = HANKAKU_X;
        source.detail_entaikin2 = RString.EMPTY;
        source.detail_biko12 = RString.EMPTY;
        source.detail_biko22 = RString.EMPTY;
        source.detail_funyuFukanBango2 = RString.EMPTY;

        return source;
    }

    private NonyuTsuchishoCVSKakukoSource edit納付書3(NonyuTsuchishoCVSKakukoSource source) {

        if (item.get納付書共通() != null) {
            source.detail_kamokumei3 = item.get納付書共通().get科目名称();
            source.detail_shimei3 = item.get納付書共通().get納付者氏名();
            source.detail_gimushaShimei3 = item.get納付書共通().get被代納人氏名();
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
            source.detail_nofuBango3 = 納入通知書期情報.get納付番号();
            source.detail_kakuninBango3 = 納入通知書期情報.get確認番号();
            source.detail_nofuKubun3 = 納入通知書期情報.get納付区分();
            source.detail_ocrId3 = 納入通知書期情報.getOcrid();
            source.detail_barcodeCvsBarcode3 = 納入通知書期情報.getバーコード情報();
            source.detail_cvsBarcodeNaiyo13 = 納入通知書期情報.getバーコード情報上段();
            source.detail_cvsBarcodeNaiyo23 = 納入通知書期情報.getバーコード情報下段();
            source.detail_kibetsu3 = 納入通知書期情報.get期表記();
            source.detail_gokeigaku3 = 納入通知書期情報.get納付額表記();
            source.detail_nokigenYmd3 = 納入通知書期情報.get納期限表記();
            source.detail_honzei3 = 納入通知書期情報.get納付額表記();
            if (納入通知書期情報.getOcr() != null) {
                source.detail_ocr13 = 納入通知書期情報.getOcr().get(1);
                source.detail_ocr23 = 納入通知書期情報.getOcr().get(2);
            }

            if (納入通知書期情報.getコンビニ支払期限() != null) {
                source.detail_cvsToriatsukaikigen3 = 納入通知書期情報.getコンビニ支払期限().toDateString();
            }
            if (item.get納付書共通() != null) {
                source.detail_ryoshushoNendo3 = item.get納付書共通().get調定年度表記();
                source.detail_nendoNenbun3 = item.get納付書共通().get年度年分表記();
                source.detail_ryoshushoNenbun3 = item.get納付書共通().get賦課年度表記();
                source.detail_hakkoYmd3 = item.get納付書共通().get発行日表記();
            }
            if (item.get納付書共通() != null
                    && item.get納付書共通().get通知書番号() != null) {
                source.detail_tsuchishoNo3 = item.get納付書共通().get通知書番号().value();
            }
        } else {
            source.detail_ryoshushoNendo3 = HOSHI_4;
            source.detail_nendoNenbun3 = HOSHI_4;
            source.detail_kibetsu3 = HOSHI_2;
            source.detail_ryoshushoNenbun3 = HOSHI_4;
            source.detail_gokeigaku3 = HOSHI_13;
            source.detail_tsuchishoNo3 = HOSHI_16;
            source.detail_nokigenYmd3 = HOSHI_11;
            source.detail_hakkoYmd3 = HOSHI_11;
            source.detail_honzei3 = HOSHI_13;
            source.detail_ocr13 = HOSHI_22;
            source.detail_ocr23 = HOSHI_28;
            source.detail_cvsToriatsukaikigen3 = HOSHI_16;
        }

        source.detail_nokigenTitle3 = NOKIGEN;
        source.detail_tokusokuTesuryo3 = RString.EMPTY;
        source.detail_ocrCut3 = HANKAKU_X;
        source.detail_entaikin3 = RString.EMPTY;
        source.detail_biko13 = RString.EMPTY;
        source.detail_biko23 = RString.EMPTY;
        source.detail_funyuFukanBango3 = RString.EMPTY;

        return source;
    }
}
