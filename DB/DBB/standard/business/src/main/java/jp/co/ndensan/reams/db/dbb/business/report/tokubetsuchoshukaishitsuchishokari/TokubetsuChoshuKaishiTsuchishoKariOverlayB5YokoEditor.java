/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横・オーバレイタイプEditor
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor implements
        ITokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor {

    private final TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoItem item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoItem
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource edit(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource source) {
        source.nendo1 = item.get年度１();
        source.nendo2 = item.get年度２();
        source.tsuchishoNo2 = item.get通知書番号２();
        source.setaiCode2 = item.get世帯コード２();
        source.hihokenshaNo2 = item.get被保険者番号２();
        source.shikibetsuCode2 = item.get識別コード２();
        source.hihokenshaName2 = item.get被保険者名称２();
        source.birthYMD2 = item.get生年月日２();
        source.seibetsu2 = item.get性別２();
        source.tokuchoGimushaName2 = item.get特徴義務者名称２();
        source.tokuchoTaishoNenkinName2 = item.get特徴対象年金名称２();
        source.hokenryoGokei = item.get保険料合計();
        source.nendo3 = item.get年度３();
        source.nendo4 = item.get年度４();
        source.nendo5 = item.get年度５();
        source.shotokuDankai = item.get保険料段階();
        source.tsuchibun1 = item.get通知文1();
        source.hokenryoGaku4Gatsu2 = item.get保険料額4月2();
        source.hokenryoRitsu = item.get保険料率();
        source.tsuchibun2 = item.get通知文2();
        source.hokenryoGaku6Gatsu2 = item.get保険料額6月2();
        source.hokenryoGaku8Gatsu2 = item.get保険料額8月2();
        source.hyojicodeName1 = item.get表示コード名称１();
        source.hyojicodeName2 = item.get表示コード名称２();
        source.hyojicodeName3 = item.get表示コード名称３();
        source.hyojicode1 = item.get表示コード１();
        source.hyojicode2 = item.get表示コード２();
        source.hyojicode3 = item.get表示コード３();
        source.tsuchishoNo1 = item.get通知書番号１();
        source.setaiCode1 = item.get世帯コード１();
        source.hihokenshaNo1 = item.get被保険者番号１();
        source.shikibetsuCode1 = item.get識別コード１();
        source.hihokenshaName1 = item.get被保険者名称１();
        source.birthYMD1 = item.get生年月日１();
        source.seibetsu1 = item.get性別１();
        source.setainushiName1 = item.get世帯主名１();
        source.tokuchoGimushaName1 = item.get特徴義務者名称１();
        source.tokuchoTaishoNenkinName1 = item.get特徴対象年金名称１();
        source.hokenryoGaku4Gatsu1 = item.get保険料額4月1();
        source.hokenryoGaku6Gatsu1 = item.get保険料額6月1();
        source.hokenryoGaku8Gatsu1 = item.get保険料額8月1();
        source.hokenshaName = item.get保険者名();
        source.yubinNo1 = item.get郵便番号１();
        source.gyoseiku1 = item.get行政区１();
        source.jusho3 = item.get住所３();
        source.jushoText = item.get住所();
        source.jusho1 = item.get住所１();
        source.jusho2 = item.get住所２();
        source.katagakiText = item.get方書();
        source.katagaki2 = item.get方書２();
        source.katagakiSmall2 = item.get方書小２();
        source.katagaki1 = item.get方書１();
        source.katagakiSmall1 = item.get方書小１();
        source.shimei2 = item.get氏名２();
        source.shimeiSmall2 = item.get氏名小２();
        source.shimeiText = item.get氏名text();
        source.meishoFuyo2 = item.get名称不要２();
        source.shimeiSmall1 = item.get氏名小1();
        source.dainoKubunMei = item.get代納区分名();
        source.shimei1 = item.get氏名1();
        source.meishoFuyo1 = item.get名称不要1();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.kakkoRight2 = item.getKakkoRight2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samaBun1 = item.getSamaBun1();
        source.kakkoRight1 = item.getKakkoRight1();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.customerBarCode = item.getCustomerBarCode();
        // TODO 世帯主名
        //source.setainusimei = item.get世帯主名();
        // TODO 様方
        //source.samaKata = item.get様方();
        source.yubinBango = item.get郵便番号();
        source.shozaichi = item.get所在地();
        source.choshaBushoName = item.get庁舎部署名();
        source.tantoName = item.get担当名();
        source.telNo = item.get電話番号();
        source.naisenNo = item.get内線番号();
        source.denshiKoin = item.get電子公印();
        source.hakkoYMD = item.get署名発行年月日();
        // TODO 市町村名
//        source.shichosonMei = item.get市町村名();
        // TODO 市長名
        //source.shuchoMei = item.get市長名();
        source.koinShoryaku = item.get公印省略();
        
        return source;
    }

}
