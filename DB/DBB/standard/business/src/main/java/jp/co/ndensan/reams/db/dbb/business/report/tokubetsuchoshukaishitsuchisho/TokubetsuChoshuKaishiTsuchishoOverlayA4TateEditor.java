/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;

/**
 * 特別徴収開始通知書（本算定） A4縦・オーバレイタイプ帳票Editor
 */
public class TokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor implements ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor {

    private final TokubetsuChoshuKaishiTsuchishoOverlayA4TateItem item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoOverlayA4TateItem
     */
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor(TokubetsuChoshuKaishiTsuchishoOverlayA4TateItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource edit(TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource source) {
        source.titleNendo = item.get年度名();
        source.hyojicodeName1 = item.get表示コード名1();
        source.hyojicodeName2 = item.get表示コード名2();
        source.hyojicodeName3 = item.get表示コード名3();
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
        source.birthYYYY = item.get生年月日の年();
        source.birthMM = item.get生年月日の月();
        source.birthDD = item.get生年月日の日();
        source.seibetsu = item.get性別();
        source.tokuchoGimushaName = item.get特別徴収業務者名();
        source.tokuchoTaishoNenkinName = item.get特別徴収対象年金名();
        source.hokenryoGakuNendo1 = item.get保険料額年度1();
        source.hokenryoGakuNendo2 = item.get保険料額年度2();
        source.karisanteiGakuGokei = item.get仮算定額合計();
        source.hokenryoGaku10Gatsu1 = item.get保険料額10月();
        source.hokenryoGaku2Gatsu1 = item.get保険料額12月();
        source.hokenryoGaku2Gatsu1 = item.get保険料額2月();
        source.SanteiKisoNendo1 = item.get算定期の年度();
        source.santeikisoKikan = item.get算定期の期間();
        source.santeikisoTsukisu = item.get算定期の月数();
        source.shotokuDankai1 = item.get所得段階1();
        source.hokenryoGaku4Gatsu = item.get保険料額4月仮徴収額();
        source.hokenryoGaku10Gatsu2 = item.get保険料額10月本徴収額();
        source.hokenryoGaku6Gatsu = item.get保険料額6月仮徴収額();
        source.hokenryoGaku12Gatsu2 = item.get保険料額12月本徴収額();
        source.hokenryoRitsu = item.get保険料率();
        source.nendoHokenryo = item.get年度保険料();
        source.fuchoNofugaku = item.get普通徴収で納付する額();
        source.hokenryoGaku8Gatsu = item.get保険料額8月仮徴収額();
        source.hokenryoGaku2Gatsu2 = item.get保険料額2月本徴収額();
        source.yokunendoKariTokuchoHokenryogaku = item.get翌年度仮特徴保険料額();
        source.tsuchibun = item.get通知文();
        source.yubinNo1 = item.get郵便番号No();
        source.gyoseiku1 = item.get行政区();
        source.jusho3 = item.get住所3();
        source.jushoText = item.get住所();
        source.jusho1 = item.get住所1();
        source.jusho2 = item.get住所2();
        source.katagakiText = item.get方書();
        source.katagaki2 = item.get方書2();
        source.katagakiSmall2 = item.get方書Small2();
        source.katagaki1 = item.get方書1();
        source.katagakiSmall1 = item.get方書Small1();
        source.shimei2 = item.get氏名2();
        source.shimeiSmall2 = item.get氏名Small2();
        source.shimeiText = item.get氏名();
        source.meishoFuyo2 = item.get名称付与2();
        source.shimeiSmall1 = item.get氏名Small1();
        source.dainoKubunMei = item.get代納区分名();
        source.shimei1 = item.get氏名1();
        source.meishoFuyo1 = item.get名称付与1();
        source.samabunShimeiText = item.get様文氏名();
        source.kakkoLeft2 = item.get左括弧2();
        source.samabunShimei2 = item.get様文氏名2();
        source.samabunShimeiSmall2 = item.get様文氏名Small2();
        source.samaBun2 = item.get様文2();
        source.kakkoRight2 = item.get右括弧2();
        source.kakkoLeft1 = item.get左括弧1();
        source.samabunShimei1 = item.get様文氏名1();
        source.samaBun1 = item.get様文1();
        source.kakkoRight1 = item.get右括弧1();
        source.samabunShimeiSmall1 = item.get様文氏名Small1();
        source.customerBarCode = item.get顧客場番号();
        // TODO 世帯主名
        // TODO 様方
        source.yubinBango = item.get郵便番号Bango();
        source.shozaichi = item.get所在地();
        source.choshaBushoName = item.get庁舎部署名();
        source.tantoName = item.get担当名();
        source.telNo = item.get電話番号();
        source.naisenLabel = item.get内線ラベル();
        source.naisenNo = item.get内線番号();
        return source;
    }

}
