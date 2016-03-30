/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;

/**
 * 特別徴収開始通知書（本算定） B5横タイプ帳票Editor
 */
public class TokubetsuChoshuKaishiTsuchishoB5Editor implements
        ITokubetsuChoshuKaishiTsuchishoB5Editor {

    private final TokubetsuChoshuKaishiTsuchishoB5Item item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoB5Item
     */
    public TokubetsuChoshuKaishiTsuchishoB5Editor(TokubetsuChoshuKaishiTsuchishoB5Item item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoB5Source edit(TokubetsuChoshuKaishiTsuchishoB5Source source) {
        source.nendo = item.get年度();
        source.nendo2 = item.get年度2();
        source.setaiCode2 = item.get世帯コード2();
        source.tsuchishoNo2 = item.get通知書番号2();
        source.hihokenshaName2 = item.get被保険者氏名2();
        source.birthYMD2 = item.get生年月日2();
        source.seibetsu2 = item.get性別2();
        source.tokuchoGimushaName2 = item.get特別徴収業務者名2();
        source.tokuchoTaishonenkinName2 = item.get特別徴収対象年金名2();
        source.atenaRenban2 = item.get宛名連番2();
        source.nendo3 = item.get年度3();
        source.hokenryoGokei = item.get保険料合計();
        source.atenaRenban1 = item.get宛名連番1();
        source.tsukiSu = item.get月数();
        source.shotokuDankai = item.get所得段階区分();
        source.kikan = item.get期間();
        source.tsuchibunNendo = item.get通知文年度();
        source.hokenryoRitsu = item.get保険料率();
        source.hokenryoCalGaku = item.get保険料算出額();
        source.hokenryoGaku = item.get保険料額();
        source.fuchoNofuGaku = item.get普通徴収で納付する額();
        source.hyojicodeName1 = item.get表示コード名1();
        source.hyojicodeName2 = item.get表示コード名2();
        source.hyojicodeName3 = item.get表示コード名3();
        source.hyojicode1 = item.get表示コード1();
        source.hyojicode2 = item.get表示コード2();
        source.hyojicode3 = item.get表示コード3();
        source.setaiCode1 = item.get世帯コード1();
        source.tsuchishoNo1 = item.get通知書番号1();
        source.hokenryoGaku4Gatsu = item.get保険料額4月仮徴収額();
        source.hokenryoGaku10Gatsu2 = item.get保険料額10月本徴収額();
        source.hihokenshaName1 = item.get被保険者氏名1();
        source.hokenryoGaku6Gatsu = item.get保険料額6月仮徴収額();
        source.hokenryoGaku12Gatsu2 = item.get保険料額12月本徴収額();
        source.birthYMD1 = item.get生年月日1();
        source.seibetsu1 = item.get性別1();
        source.hokenryoGaku8Gatsu = item.get保険料額8月仮徴収額();
        source.hokenryoGaku2Gatsu2 = item.get保険料額2月本徴収額();
        source.setainushiName1 = item.get世帯主名1();
        source.tokuchoGimushaName1 = item.get特別徴収業務者名1();
        source.tokuchoTaishoNenkinName1 = item.get特別徴収対象年金名1();
        source.hokenryoGaku10Gatsu1 = item.get保険料額10月();
        source.hokenryoGaku12Gatsu1 = item.get保険料額12月();
        source.hokenryoGaku2Gatsu1 = item.get保険料額2月();
        source.hokenshaName = item.get被保険者氏名();
        source.yubinNo = item.get郵便番号();
        source.gyoseiku = item.get行政区();
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
        source.hakkoYMD = item.get発行年月日();
        source.denshiKoin = item.get電子公印();
        source.koinMojiretsu = item.get公印文字列();
        source.koinShoryaku = item.get公印書略();
        source.ninshoshaShimeiKakenai = item.get承認者公印掛けない();
        source.ninshoshaShimeiKakeru = item.get承認者公印掛ける();
        source.ninshoshaYakushokuMei = item.get承認者役職名();
        source.ninshoshaYakushokuMei1 = item.get承認者役職名１();
        source.ninshoshaYakushokuMei2 = item.get承認者役職名２();
        return source;
    }

}
