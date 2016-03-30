/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプEditor
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerEditor implements
        ITokubetsuChoshuKaishiTsuchishoKariSealerEditor {

    private final TokubetsuChoshuKaishiTsuchishoKariSealerItem item;

    /**
     * コンストラクタです
     *
     * @param item TokubetsuChoshuKaishiTsuchishoKariSealerItem
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerEditor(TokubetsuChoshuKaishiTsuchishoKariSealerItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariSealerSource edit(TokubetsuChoshuKaishiTsuchishoKariSealerSource source) {
        source.birthYMD = item.get生年月日();
        source.hihokenshaJusho = item.get被保険者住所１();
        source.hihokenshaKatagaki = item.get被保険者方書１();
        source.hihokenshaName = item.get被保険者氏名();
        source.hokenryoGaku4Gatsu1 = item.get保険料額4月1();
        source.hokenryoGaku4Gatsu2 = item.get保険料額4月2();
        source.hokenryoGaku6Gatsu1 = item.get保険料額6月1();
        source.hokenryoGaku6Gatsu2 = item.get保険料額6月2();
        source.hokenryoGaku8Gatsu1 = item.get保険料額8月1();
        source.hokenryoGaku8Gatsu2 = item.get保険料額8月2();
        source.hokenryoGakuZen10Gatsu = item.get保険料額前10月();
        source.hokenryoGakuZen12Gatsu = item.get保険料額前12月();
        source.hokenryoGakuZen2Gatsu = item.get保険料額前2月();
        source.hokenryoGokei = item.get保険料合計();
        source.hyojicode1 = item.get表示コード１();
        source.hyojicode2 = item.get表示コード２();
        source.hyojicode3 = item.get表示コード３();
        source.hyojicodeName1 = item.get表示コード名称１();
        source.hyojicodeName2 = item.get表示コード名称２();
        source.hyojicodeName3 = item.get表示コード名称３();
        source.nendo = item.get年度();
        source.nendo2 = item.get年度２();
        source.nendo3 = item.get年度３();
        source.nendo4 = item.get年度４();
        source.nendo5 = item.get年度５();
        source.nendo6 = item.get年度６();
        source.nendo7 = item.get年度７();
        source.nendo8 = item.get年度８();
        source.nendo9 = item.get年度９();
        source.seibetsu = item.get性別();
        source.setaiCode = item.get世帯コード();
        source.setainushiName = item.get世帯主名();
        source.tokuchoGimushaName = item.get特徴義務者名称();
        source.tokuchoTaishoNenkinName = item.get特徴対象年金名称();
        source.tsuchishoNo = item.get通知書番号();
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
        // TODO 様方
        source.denshiKoin = item.get電子公印();
        source.hakkoYMD = item.get署名発行年月日();
        // TODO 市町村名
        // TODO 市長名
        source.koinShoryaku = item.get公印省略();
        return source;
    }

}
