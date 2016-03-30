/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;

/**
 * 特別徴収開始通知書（仮算定）帳票 A4縦・オーバーレイタイプEditor
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor implements
        ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor {

    private final TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateItem item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateItem
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource edit(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource source) {
        source.titleNendo = item.getタイトル年度();
        source.hyojicodeName1 = item.get表示コード名称１();
        source.hyojicodeName2 = item.get表示コード名称２();
        source.hyojicodeName3 = item.get表示コード名称３();
        source.hyojicodeCode1 = item.get表示コード１();
        source.hyojicodeCode2 = item.get表示コード２();
        source.hyojicodeCode3 = item.get表示コード３();
        source.hihokenshaNo = item.get被保険者番号();
        source.tuchishoNo = item.get通知書番号();
        source.setaiCode = item.get世帯コード();
        source.shikibetsuCode = item.get識別コード();
        source.hihokenshaName = item.get被保険者氏名();
        source.setainushiName = item.get世帯主名();
        source.hihokenshaJusho = item.get被保険者住所();
        source.hihokenshaKatagaki = item.get被保険者方書();
        source.birthYYYY = item.get生年度();
        source.birthMM = item.get生月();
        source.birthDD = item.get生日();
        source.seibetsu = item.get性別();
        source.tokuchoGimushaName = item.get特徴義務者名称();
        source.tokuchoTaishoNenkinName = item.get特徴対象年金名称();
        source.hokenryoGakuNendo1 = item.get保険料額年度１();
        source.hokenryoGakuNendo2 = item.get保険料額年度２();
        source.karisanteiGakuGokei = item.get仮算定額合計();
        source.hokenryoGaku4Gatsu1 = item.get保険料額4月1();
        source.hokenryoGaku6Gatsu1 = item.get保険料額6月1();
        source.hokenryoGaku8Gatsu1 = item.get保険料額8月1();
        source.SanteiKisoNendo1 = item.get算定基礎年度１();
        source.SanteiKisoNendo2 = item.get算定基礎年度２();
        source.SanteiKisoNendo3 = item.get算定基礎年度３();
        source.shotokuDankai = item.get取得段階();
        source.karisanteiGakuGokei1 = item.get仮算定額合計１();
        source.hokenryoGaku10Gatsu = item.get保険料額10月前();
        source.hokenryoGaku4Gatsu2 = item.get保険料額4月2前();
        source.hokenryoGaku12Gatsu = item.get保険料額12月前();
        source.hokenryoGaku6Gatsu2 = item.get保険料額6月2前();
        source.hokenryoGaku2Gatsu = item.get保険料額2月前();
        source.hokenryoGaku8Gatsu2 = item.get保険料額8月2前();
        source.tsuchibun = item.get通知文();
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
