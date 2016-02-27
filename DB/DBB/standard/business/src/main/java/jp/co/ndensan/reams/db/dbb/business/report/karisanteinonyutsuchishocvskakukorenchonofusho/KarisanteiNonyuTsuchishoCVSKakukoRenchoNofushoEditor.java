/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukorenchonofusho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のEditorです。
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor implements IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor {

    private final KariSanteiNonyuTsuchiShoJoho item;
//    private final int index;
//    private final RString NOKIGEN = new RString("納期限");
//    private final RString HANKAKU_X = new RString("X");
//    private final RString HOSHI_2 = new RString("**");
//    private final RString HOSHI_4 = new RString("****");
//    private final RString HOSHI_11 = new RString("***********");
//    private final RString HOSHI_13 = new RString("*************");
//    private final RString HOSHI_16 = new RString("****************");
//    private final RString HOSHI_28 = new RString("****************************");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KariSanteiNonyuTsuchiShoJoho}
     */
    protected KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor(KariSanteiNonyuTsuchiShoJoho item) {
        this.item = item;
//        this.index = index;
    }

    @Override
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource edit(KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource source) {
        return editSource(source);
    }

    private KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource editSource(KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoSource source) {

        //checkstyle
        item.get仮算定納入通知書制御情報();
//        source.kamokumei = item.get納付書共通().get科目名称();
//        source.shunoKikanBango1 = item.get納入通知書期情報リスト().get(index).get収納機関番号表示用();
//        source.nofuBango = item.get納入通知書期情報リスト().get(index).get納付番号();
//        source.kakuninBango1 = item.get納入通知書期情報リスト().get(index).get確認番号();
//        source.nofuKubun1 = item.get納入通知書期情報リスト().get(index).get納付区分();
//        source.nokigenTitle = this.NOKIGEN;
//        source.tokusokuTesuryo = RString.EMPTY;
//        source.ocrId1 = item.get納入通知書期情報リスト().get(index).getOCRID();
//        source.ocrCut1 = this.HANKAKU_X;
//        source.entaikin = RString.EMPTY;
//        source.shimei = item.get納付書共通().get納付者氏名();
//        source.biko11 = RString.EMPTY;
//        source.biko21 = RString.EMPTY;
//        source.gimushaShimei = item.get納付書共通().get被代納人氏名();
//        source.barcodeCvsBarcode1 = item.get納入通知書期情報リスト().get(index).getバーコード情報();
//        source.cvsBarcodeNaiyo11 = item.get納入通知書期情報リスト().get(index).getバーコード情報上段();
//        source.cvsBarcodeNaiyo21 = item.get納入通知書期情報リスト().get(index).getバーコード情報下段();
//        source.funyuFukanBango1 = RString.EMPTY;
//
//        if (item.get納入通知書期情報リスト().isEmpty()) {
//
//            source.ryoshushoNendo1 = this.HOSHI_4;
//            source.nendoNenbun = this.HOSHI_4;
//            source.kibetsu = this.HOSHI_2;
//            source.ryoshushoNenbun1 = this.HOSHI_4;
//            source.tsuchishoNo = this.HOSHI_16;
//            source.nokigenYmd = this.HOSHI_11;
//            source.hakkoYmd = this.HOSHI_11;
//            source.honzei = this.HOSHI_13;
//            source.ocr11 = this.HOSHI_28;
//            source.ocr21 = this.HOSHI_28;
//            source.cvsToriatsukaikigen1 = this.HOSHI_16;
//        } else {
//            source.ryoshushoNendo1 = item.get納付書共通().get調定年度表記();
//            source.nendoNenbun = item.get納付書共通().get年度年分表記();
//            source.kibetsu = item.get納入通知書期情報リスト().get(index).get期表記();
//            source.ryoshushoNenbun1 = item.get納付書共通().get賦課年度表記();
//            source.tsuchishoNo = item.get納付書共通().get通知書番号().value();
//            source.nokigenYmd = item.get納入通知書期情報リスト().get(index).get納期限表記();
//            source.hakkoYmd = item.get納付書共通().get発行日表記();
//            source.honzei = item.get納入通知書期情報リスト().get(index).get納付額表記();
//            source.ocr11 = item.get納入通知書期情報リスト().get(index).getOCR().get(1);
//            source.ocr21 = item.get納入通知書期情報リスト().get(index).getOCR().get(2);
//            source.cvsToriatsukaikigen1 = item.get納入通知書期情報リスト().get(index).getコンビニ支払期限().toDateString();
//        }
        return source;
    }
}
